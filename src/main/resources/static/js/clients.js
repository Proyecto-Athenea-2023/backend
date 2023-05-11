// Variables Globales
let URL_BASE = "http://localhost:8080"
let client = null;

// Carga Inicial
$(document).ready(function(){
    $("#modalClient").hide();
    getAllClients();
});


// Funciones utilitarias
function updateClientsTable(clients){
    $("#tblClients").find("tr:gt(0)").remove();
    let data = "";

}

// Consumir servicios de CRUD
function getAllClients(){
    $.ajax({
        url: URL_BASE + "/clients/all",
        type: "GET",
        datatype: "JSON"
    })
    .done(function(response){
        console.log(response);

    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error en getAllClients. " + textStatus);
        alert("Hemos tenido una falla obteniendo los clientes. Por favor, intente de nuevo mas tarde.");
    });
}