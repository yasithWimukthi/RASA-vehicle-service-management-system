/****************************************
 *              jQuery
 ***************************************/

$('select.dropdown')
    .dropdown();

$( "#entry-edit" ).click(function () {
    //alert( "Handler for .submit() called." );
    $('.ui.modal.entry-edit-form')
        .modal('show');
});

$( "#update-client" ).click(function () {
    //alert( "Handler for .submit() called." );
    $('.ui.modal.client-edit-form')
        .modal('show');
});

$( "#update-vehicle" ).click(function () {
    //alert( "Handler for .submit() called." );
    $('.ui.modal.vehicle-edit-form')
        .modal('show');
});

$( "#deleteBtn" ).click(function () {
    //alert( "Handler for .submit() called." );
    $('.ui.tiny.modal.delete-modal')
        .modal('show');
});

$('.ui.modal.update-message')
    .modal('show');

$('.ui.modal.create-message')
    .modal('show');

$('.ui.radio.checkbox')
    .checkbox();

$('.ui.checkbox')
    .checkbox();


$( "#deleteBtn" ).click(function () {
    $('.ui.tiny.modal')
        .modal('show');
});


/*************************************************
 *              Entry form validation
 *************************************************/

const showUpdateEntryModel = ()=>{
        $('.ui.modal.entry-edit-form')
            .modal('show');
}

const showUpdateClientModel = () =>{
    $('.ui.modal.client-edit-form')
        .modal('show');
}

const showUpdateVehicleModel = () =>{
    $('.ui.modal.vehicle-edit-form')
        .modal('show');
}

const entryUpdateForm = document.querySelector("#entryUpdateForm");

document.querySelector("#insurance").addEventListener("change",()=>{
    if(document.querySelector("#insurance").checked){
        document.querySelector("#document-container").style.display = "inline";
    }
});

document.querySelector("#nonInsurance").addEventListener("change",()=>{
    if(document.querySelector("#nonInsurance").checked){
        document.querySelector("#document-container").style.display = "none";
    }
});

entryUpdateForm.addEventListener("submit",e=>{
    let entryDate = document.querySelector("#entryDate").value;
    let accidentDate = document.querySelector("#accidentDate").value;

    if(entryDate.trim() == ""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#entryDateContainer").classList.add("error");
        showUpdateEntryModel();

    }else{
        document.querySelector("#entryDateContainer").classList.remove("error");
    }

    if(accidentDate.trim() == ""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#accidentDateContainer").classList.add("error");
        showUpdateEntryModel();
    }else{
        document.querySelector("#accidentDateContainer").classList.remove("error");
    }
});

/*************************************************
 *              Client form validation
 *************************************************/

const clientUpdateForm = document.querySelector("#clientUpdateForm");

const tldEmailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

clientUpdateForm.addEventListener("submit",e =>{
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let mobile = document.getElementById("mobile").value;
    let address = document.getElementById("address").value;
    let email = document.getElementById("email").value;

    if(fname.trim().length == 0){
        document.querySelector("#client-form-container").classList.add("error");
        document.querySelector("#fnameContainer").classList.add("error");
        e.preventDefault();
        showUpdateClientModel();
    }else {
        document.querySelector("#fnameContainer").classList.remove("error");
    }

    if(lname.trim().length == 0){
        document.querySelector("#client-form-container").classList.add("error");
        document.querySelector("#lnameContainer").classList.add("error");
        e.preventDefault();
        showUpdateClientModel();
    }else{
        document.querySelector("#lnameContainer").classList.remove("error");
    }


    if(mobile.trim().length !== 10){
        document.querySelector("#client-form-container").classList.add("error");
        document.querySelector("#mobileContainer").classList.add("error");
        e.preventDefault();
        showUpdateClientModel();
    }else{
        document.querySelector("#mobileContainer").classList.remove("error");
    }

    if(address.trim().length == 0 ){
        document.querySelector("#client-form-container").classList.add("error");
        document.querySelector("#addressContainer").classList.add("error");
        e.preventDefault();
        showUpdateClientModel();
    }else {
        document.querySelector("#addressContainer").classList.remove("error");
    }

    if(!tldEmailRegex.test(email.trim()) || !emailRegex.test(email.trim())){
        document.querySelector("#client-form-container").classList.add("error");
        document.querySelector("#emailContainer").classList.add("error");
        e.preventDefault();
        showUpdateClientModel();
    }else {
        document.querySelector("#emailContainer").classList.remove("error");
    }
});


/*************************************************
 *              Vehicle form validation
 *************************************************/
const vehicleUpdateForm = document.querySelector("#vehicleUpdateForm");


vehicleUpdateForm.addEventListener("submit",e=>{
    let brand = document.querySelector("#brand").value;
    let model = document.querySelector("#model").value;
    let color = document.querySelector("#color").value;
    let manufactYear = document.querySelector("#manufactureYear").value;

    if(brand === ""){
        e.preventDefault();
        showUpdateVehicleModel();
        document.querySelector("#vehicleUpdateFormContainer").classList.add("error");
        document.querySelector("#brandContainer").classList.add("error");
    }else {
        document.querySelector("#brandContainer").classList.remove("error");
    }

    if (model.trim() === "") {
        e.preventDefault();
        showUpdateVehicleModel();
        document.querySelector("#vehicleUpdateFormContainer").classList.add("error");
        document.querySelector("#modelContainer").classList.add("error");
    }else {
        document.querySelector("#modelContainer").classList.remove("error")
    }

    if (color.trim() === "") {
        e.preventDefault();
        showUpdateVehicleModel();
        document.querySelector("#vehicleUpdateFormContainer").classList.add("error");
        document.querySelector("#colorContainer").classList.add("error");
    }else{
        document.querySelector("#colorContainer").classList.remove("error")
    }

    if (manufactYear.trim() === "" || !numbersRegex.test(manufactYear.trim())) {
        e.preventDefault();
        showUpdateVehicleModel();
        document.querySelector("#vehicleUpdateFormContainer").classList.add("error");
        document.querySelector("#manufactYearContainer").classList.add("error");
    }else{
        document.querySelector("#manufactYearContainer").classList.remove("error");
    }
});