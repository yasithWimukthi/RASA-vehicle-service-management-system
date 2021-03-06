/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

const idRegex = /^([0-9]{9}[x|X|v|V]|[0-9]{12})$/;
const tldEmailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

let nicError = document.querySelector(".nic-error");


/**************************************************
 TOP SEARCH BAR VALIDATION
 ***************************************************/
let topSearchBar = document.querySelector("#search-form");

topSearchBar.addEventListener("submit", e =>{
    let searchWord = document.querySelector(".searchWord").value;

    if(searchWord.trim().length == 0){
        e.preventDefault();
    }
});

/**************************************************
 CUSTOMER INFORMATION VALIDATION
 ***************************************************/

let customerRegForm = document.querySelector("#customerRegForm");


customerRegForm.addEventListener("submit",e =>{
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let nic = document.getElementById("nic").value;
    let mobile = document.getElementById("mobile").value;
    let address = document.getElementById("address").value;
    let email = document.getElementById("email").value;

    if(fname.trim().length == 0){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#fnameContainer").classList.add("error");
        e.preventDefault();
    }else{
        document.querySelector("#fnameContainer").classList.remove("error");
    }

    if(lname.trim().length == 0){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#lnameContainer").classList.add("error");
        e.preventDefault();
    }else{
        document.querySelector("#lnameContainer").classList.remove("error");
    }

    if(nic.trim().length == 0 || !idRegex.test(nic.trim())){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#nicContainer").classList.add("error");
        nicError.style.visibility="visible";
        e.preventDefault();
    }else{
        document.querySelector("#nicContainer").classList.remove("error");
        nicError.style.visibility="hidden";
    }

    if(mobile.trim().length !== 10){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#mobileContainer").classList.add("error");
        document.querySelector(".mobile-error").style.visibility = "visible";
        e.preventDefault();
    }else{
        document.querySelector("#mobileContainer").classList.remove("error");
        document.querySelector(".mobile-error").style.visibility = "hidden";
    }

    if(address.trim().length == 0 ){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#addressContainer").classList.add("error");
        e.preventDefault();
    }else {
        document.querySelector("#addressContainer").classList.remove("error");
    }

    if(!tldEmailRegex.test(email.trim()) || !emailRegex.test(email.trim())){
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#emailContainer").classList.add("error");
        document.querySelector(".email-error").style.visibility="visible";
        e.preventDefault();
    }else {
        document.querySelector("#emailContainer").classList.remove("error");
        document.querySelector(".email-error").style.visibility="hidden";
    }

    return 1;
});


/**************************************************
                        jQuery
 ***************************************************/

$('.message .close')
    .on('click', function() {
        $(this)
            .closest('.message')
            .transition('fade')
        ;
    })
;

$('.ui.modal')
    .modal('show');