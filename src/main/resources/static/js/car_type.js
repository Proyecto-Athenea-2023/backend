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
let carType = null;

// Carga Inicial
$(document).ready(function(){
    closeModal();
    getAllCarTypes();
});

// Manejo del modal
function openModal(carTypeId){
    if(carTypeId == -1){ // Crear un nuevo tipo de carro
        $("#modalTitle").html("Nuevo Tipo de Carro")
        $("#btnAddCarType").show();
        $("#btnUpdateCarType").hide();

        $("#txtId").val("");
        $("#txtId").hide();
        $("#txtLevel").val("");
        $("#txtLine").val("");
    }
    else{ // Actualizar un nuevo tipo de carro
        $("#modalTitle").html("Actualizar Tipo de Carro")
        $("#btnAddCarType").hide();
        $("#btnUpdateCarType").show();

        getCarType(carTypeId);
        $("#txtId").val(carType.carTypeId);
        $("#txtId").hide();
        $("#txtLevel").val(carType.level);
        $("#txtLine").val(carType.line);
    }
    $("#modalCarType").show();
}

function closeModal(){
    $("#modalCarType").hide();
}

// Funciones utilitarias
function updateCarTypesTable(carTypes){
    $("#tblCarTypes").find("tr:gt(0)").remove();
    let data = "";
    for(let i=0; i < carTypes.length; i++){
        data += "<tr>";
        data += "<td>" + carTypes[i].level + "</td>";
        data += "<td>" + carTypes[i].line + "</td>";
        data += "<td>" + "<span onclick=\"openModal("+ carTypes[i].carTypeId +")\">Actualizar</span>" + "</td>";
        data += "<td>" + "<span onclick=\"deleteCarType("+ carTypes[i].carTypeId +")\">Eliminar</span>" + "</td>";
        data += "</tr>";
    }
    $("#tblCarType > tbody:last-child").append(data);
}

// Consumir servicios de CRUD
function getAllCarTypes(){
    $.ajax({
        url: URL_BASE + "/car_types/all",
        type: "GET",
        datatype: "JSON"
    })
    .done(function(response){
        updateCarTypesTable(response);
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error en getAllCarTypes. " + textStatus);
        alert("Hemos tenido una falla obteniendo los tipos de carro. Por favor, intente de nuevo mas tarde.");
    });
}


function getCarType(carTypeId){
    $.ajax({
        url: URL_BASE + "/car_types/by_id/" + carTypeId,
        type: "GET",
        datatype: "JSON",
        async: false
    })
    .done(function(response){
        carType = response;
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in getCarType. " + carTypeId + "." + textStatus);;
        alert("Hemos tenido una falla obteniendo el tipo de carro. Por favor, intente de nuevo mas tarde.");
    });
}

function insertCarType(){
    carType = {
        line: $("#txtLine").val(),
        level: $("#txtLevel").val()
    }

    let body = JSON.stringify(carType);
    $.ajax({
        url: URL_BASE + "/car_types/insert",
        type: "POST",
        datatype: "JSON",
        data: body,
        contentType: "application/json;charset=UTF-8"
    })
    .done(function(response){
        alert("Tipo de carro agregado.");
        getAllCarTypes();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in insertCarType. " + textStatus);
        alert("Falla creando el tipo de carro. Intente de nuevo mas tarde.");
    });
    closeModal();
}


function updateCarType(){
    carType = {
        carTypeId: $("#txtId").val(),
        line: $("#txtLine").val(),
        level: $("#txtLevel").val()
    }

    let body = JSON.stringify(carType);
    $.ajax({
        url: URL_BASE + "/car_types/update",
        type: "PUT",
        datatype: "JSON",
        data: body,
        contentType: "application/json;charset=UTF-8"
    })
    .done(function(response){
        alert("TIpo de carro correctamente actualizado.");
        getAllCarTypes();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in updateCarType. " + textStatus);
        alert("Falla actualizando el tipo de carro. Intente de nuevo mas tarde.");
    });
    closeModal();
}


function deleteCarType(carTypeId){
    $.ajax({
        url: URL_BASE + "/car_type/delete/" + carTypeId,
        type: "DELETE",
        datatype: "JSON"
    })
    .done(function(response){
        alert("Tipo de carro eliminado satisfactoriamente.");
        getAllCarTypes();
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in deleteCarType. " + carTypeId + ". " + textStatus);
        alert("Falla eliminando el tipo de carro. Intente de nuevo mas tarde.");
    });
}
