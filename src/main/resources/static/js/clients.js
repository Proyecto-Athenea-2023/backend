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
        data += "<td>" + "<span onclick=\"openModal("+ clients[i].idClient +")\">Actualizar</span>" + "</td>";
        data += "<td>" + "<span onclick=\"deleteClient("+ clients[i].idClient +")\">Eliminar</span>" + "</td>";
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
