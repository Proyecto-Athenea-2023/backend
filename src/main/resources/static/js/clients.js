/*
* <p>Copyright: Copyright (c) 2023</p>
*
* <h3>License</h3>
*
* Copyright (c) 2023 by Carlos Andres Sierra Virguez. <br>
* All rights reserved. <br>
*
* <p>Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*   <ul>
*       <li> Redistributions of source code must retain the above copyright notice,
*            this list of conditions and the following disclaimer.
*       <li> Redistributions in binary form must reproduce the above copyright notice,
*            this list of conditions and the following disclaimer in the documentation
*            and/or other materials provided with the distribution.
*       <li> Neither the name of the copyright owners, their employers, nor the
*            names of its contributors may be used to endorse or promote products
*            derived from this software without specific prior written permission.
*   </ul>
* <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
*    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
*    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
*    DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
*    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
*    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
*    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
*    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
*    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
*    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
*    POSSIBILITY OF SUCH DAMAGE.
*
* @author <A HREF="https://www.linkedin.com/in/casierrav/"> Carlos Andres Sierra </A>
* (E-mail: <A HREF="mailto:carlos.andres.sierra.v@gmail.com">carlos.andres.sierra.v@gmail.com</A> )
* @version 1.0
*/

// Variables Globales
let URL_BASE = "http://localhost:8080"
let client = null;

// Carga Inicial
$(document).ready(function(){
    closeModal();
    getAllClients();
});

// Manejo del modal
function openModal(clientId){
    if(clientId == -1){ // Crear un nuevo cliente
        $("#modalTitle").html("Nuevo Cliente")
        $("#btnAddClient").show();
        $("#btnUpdateClient").hide();
        $("#txtId").val("");
        $("#txtId").prop("disabled", false);
        $("#txtNames").val("");
        $("#txtLastnames").val("");
        $("#txtAddress").val("");
        $("#txtPhones").val("");
        $("#txtEmail").val("");
        $("#txtNickname").val("");
        $("#txtNickname").prop("disabled", false);
        $("#txtPassword").val("");
    }
    else{ // Actualizar un nuevo cliente
        $("#modalTitle").html("Actualizar Cliente")
        $("#btnAddClient").hide();
        $("#btnUpdateClient").show();

        getClient(clientId);
        $("#txtId").val(client.idClient);
        $("#txtId").prop("disabled", true);
        $("#txtNames").val(client.name);
        $("#txtLastnames").val(client.lastnames);
        $("#txtAddress").val(client.address);
        $("#txtPhones").val(client.phones);
        $("#txtEmail").val(client.email);
        $("#txtNickname").val(client.nickname);
        $("#txtNickname").prop("disabled", true);
        $("#txtPassword").val(client.password);
    }
    $("#modalClient").show();
}

function closeModal(){
    $("#modalClient").hide();
}

// Funciones utilitarias
function updateClientsTable(clients){
    $("#tblClients").find("tr:gt(0)").remove();
    let data = "";
    for(let i=0; i < clients.length; i++){
        data += "<tr>";
        data += "<td>" + clients[i].idClient + "</td>";
        data += "<td>" + clients[i].name + " " + clients[i].lastnames + "</td>";
        data += "<td>" + clients[i].address + "</td>";
        data += "<td>" + clients[i].phones + "</td>";
        data += "<td>" + clients[i].email + "</td>";
        data += "<td>" + clients[i].nickname + "</td>";
        data += "<td>" + "<span onclick=\"openModal("+ clients[i].idClient +")\"><img src=\"media/update.png\" alt=\"A\" width=\"25px\" height=\"25px\"></span>" + "</td>";
        data += "<td>" + "<span onclick=\"deleteClient("+ clients[i].idClient +")\"><img src=\"media/delete.png\" alt=\"E\" width=\"25px\" height=\"25px\"></span>" + "</td>";
        data += "</tr>";
    }
    $("#tblClients > tbody:last-child").append(data);
}

// Consumir servicios de CRUD
function getAllClients(){
    $.ajax({
        url: URL_BASE + "/clients/all",
        type: "GET",
        datatype: "JSON"
    })
    .done(function(response){
        updateClientsTable(response);
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error en getAllClients. " + textStatus);
        alert("Hemos tenido una falla obteniendo los clientes. Por favor, intente de nuevo mas tarde.");
    });
}


function getClient(clientId){
    $.ajax({
        url: URL_BASE + "/clients/by_id/" + clientId,
        type: "GET",
        datatype: "JSON",
        async: false
    })
    .done(function(response){
        client = response;
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in getClient. " + clientId + "." + textStatus);;
        alert("Hemos tenido una falla obteniendo el cliente. Por favor, intente de nuevo mas tarde.");
    });
}

function insertClient(){
    client = {
        idClient: $("#txtId").val(),
        name: $("#txtNames").val(),
        lastnames: $("#txtLastnames").val(),
        address: $("#txtAddress").val(),
        phones: $("#txtPhones").val(),
        email: $("#txtEmail").val(),
        nickname: $("#txtNickname").val(),
        password: $("#txtPassword").val()
    }

    let body = JSON.stringify(client);
    $.ajax({
        url: URL_BASE + "/clients/insert",
        type: "POST",
        datatype: "JSON",
        data: body,
        contentType: "application/json;charset=UTF-8"
    })
    .done(function(response){
        console.log(body);
        console.log(response);
        alert("Cliente agregado.");
        getAllClients();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in insertClient. " + textStatus);
        alert("Falla creando el cliente. Intente de nuevo mas tarde.");
    });
    closeModal();
}


function updateClient(){
    client = {
        idClient: $("#txtId").val(),
        name: $("#txtNames").val(),
        lastnames: $("#txtLastnames").val(),
        address: $("#txtAddress").val(),
        phones: $("#txtPhones").val(),
        email: $("#txtEmail").val(),
        nickname: $("#txtNickname").val(),
        password: $("#txtPassword").val()
    }

    let body = JSON.stringify(client);
    $.ajax({
        url: URL_BASE + "/clients/update",
        type: "PUT",
        datatype: "JSON",
        data: body,
        contentType: "application/json;charset=UTF-8"
    })
    .done(function(response){
        alert("Cliente correctamente actualizado.");
        getAllClients();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in updateClient. " + textStatus);
        alert("Falla actualizando el cliente. Intente de nuevo mas tarde.");
    });
    closeModal();
}


function deleteClient(clientId){
    $.ajax({
        url: URL_BASE + "/clients/delete/" + clientId,
        type: "DELETE",
        datatype: "JSON"
    })
    .done(function(response){
        alert("Cliente eliminado satisfactoriamente.");
        getAllClients();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in deleteClient. " + clientId + ". " + textStatus);
        alert("Falla eliminando el cliente. Intente de nuevo mas tarde.");
    });
}
