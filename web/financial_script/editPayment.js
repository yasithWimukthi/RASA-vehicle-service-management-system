let paymentForm = document.querySelector("#form");

paymentForm.addEventListener("submit", e =>{
    let vehicleRegiNo = document.querySelector("#vehicleRegiNo").value;
    let estimateAmount = document.querySelector("#estimateAmount").value;
    let cash = document.querySelector("#cash").value;
    let paymentDate = document.querySelector("#paymentDate").value;





    if(vehicleRegiNo.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#vehicleRegiNo").classList.add("error");

    }else {
        document.querySelector("#vehicleRegiNo").classList.remove("error");

    }

    if(estimateAmount.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container2").classList.add("error");
        document.querySelector("#estimateAmount").classList.add("error");

    }else {
        document.querySelector("#estimateAmount").classList.remove("error");

    }


    if(cash.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container3").classList.add("error");
        document.querySelector("#cash").classList.add("error");

    }else {
        document.querySelector("#cash").classList.remove("error");

    }
    if(paymentDate.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container4").classList.add("error");
        document.querySelector("#paymentDate").classList.add("error");

    }else {
        document.querySelector("#paymentDate").classList.remove("error");

    }
    if(isNaN(estimateAmount)){
        e.preventDefault();
        document.querySelector("#form-container2").classList.add("error");
        document.querySelector("#estimateAmount").classList.add("error");
        document.querySelector(".estimate-error").style.visibility = "visible";
    }
    else{
        document.querySelector("#estimateAmount").classList.remove("error");
        document.querySelector(".estimate-error").style.visibility = "hidden";
    }
    if(isNaN(cash)){
        e.preventDefault();
        document.querySelector("#form-container3").classList.add("error");
        document.querySelector("#cash").classList.add("error");
        document.querySelector(".cash-error").style.visibility = "visible";
    }else{
        document.querySelector("#cash").classList.remove("error");
        document.querySelector(".cash-error").style.visibility = "hidden";
    }
});

