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