/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/


/**************************************************
 TOP SEARCH BAR VALIDATION
 ***************************************************/
let topSearchBar = document.querySelector("#search-form");
const numbersRegex = /^[0-9]+$/;

topSearchBar.addEventListener("submit", e =>{
    let searchWord = document.querySelector(".searchWord").value;

    if(searchWord.trim().length == 0){
        e.preventDefault();
    }
});

/**************************************************
 VEHICLE INFORMATION VALIDATION
 ***************************************************/

let vehicleRegistrationForm = document.querySelector("#vehicleRegForm");

document.querySelector("#brand").addEventListener("change",()=>{
    if(document.querySelector("#brand").value === "Other"){
        document.querySelector("#OtherBrandContainer").style.display = "block";
    }else{
        document.querySelector("#OtherBrandContainer").style.display = "none";
    }
})


vehicleRegistrationForm.addEventListener("submit", e =>{
    let otherBrand = document.querySelector("#otherBrand").value;
    let brand = document.querySelector("#brand").value;
    let model = document.querySelector("#model").value;
    let color = document.querySelector("#color").value;
    let manufactYear = document.querySelector("#manufactureYear").value;


    if(brand === "Other" && otherBrand.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#brandContainer").classList.add("error");
        document.querySelector("#OtherBrandContainer").classList.add("error");
    }else {
        document.querySelector("#brandContainer").classList.remove("error");
        document.querySelector("#OtherBrandContainer").classList.remove("error");
    }

    if (model.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#modelContainer").classList.add("error");
    }else {
        document.querySelector("#modelContainer").classList.remove("error")
    }

    if (color.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#colorContainer").classList.add("error");
    }else{
        document.querySelector("#colorContainer").classList.remove("error")
    }

    if (manufactYear.trim() === "" || !numbersRegex.test(manufactYear.trim())) {
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#manufactYearContainer").classList.add("error");
       // document.querySelector(".email-error").style.visibility="visible";
    }else{
        document.querySelector("#manufactYearContainer").classList.remove("error");
    }
})

/**************************************************
                    jQuery
 ***************************************************/

$('.ui.search.dropdown')
    .dropdown();

// $('.ui.search.dropdown').innerText.fontsize(30);

$('.message .close')
    .on('click', function() {
        $(this)
            .closest('.message')
            .transition('fade')
        ;
    })
;