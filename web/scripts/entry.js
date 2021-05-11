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

const entryUpdateForm = document.querySelector("#entryUpdateForm");
alert("event")

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
    }else{
        document.querySelector("#entryDateContainer").classList.remove("error");
    }

    if(accidentDate.trim() == ""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#accidentDateContainer").classList.add("error");
    }else{
        document.querySelector("#accidentDateContainer").classList.remove("error");
    }
});