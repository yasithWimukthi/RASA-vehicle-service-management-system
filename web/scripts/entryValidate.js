/**************************************************
 SERVICE ENTRY INFORMATION VALIDATION
 ***************************************************/


const entryForm = document.querySelector("#entry-form");

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


entryForm.addEventListener("submit", e=>{
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



/**************************************************
                        jQuery
 ***************************************************/
$('.ui.radio.checkbox')
    .checkbox();

$('.ui.checkbox')
    .checkbox();
