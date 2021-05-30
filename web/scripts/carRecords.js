
const emailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
const idRegex = /^([0-9]{9}[x|X|v|V]|[0-9]{12})$/;

let carRecordsForm = document.querySelector("#form");

carRecordsForm.addEventListener("submit", e =>{
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let id = document.getElementById("id").value;
    let address= document.getElementById("address").value;
    let phone= document.getElementById("phone").value;
    let email= document.getElementById("email").value;
    let bookNumber= document.getElementById("bookNumber").value;
    let model= document.getElementById("model").value;
    let seatAmount= document.getElementById("seatAmount").value;
    let distance= document.getElementById("distance").value;
    let carType= document.getElementById("carType").value;

    if(fname.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container2").classList.add("error");
        document.querySelector("#fname").classList.add("error");

    }

    if(lname.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container3").classList.add("error");
        document.querySelector("#lname").classList.add("error");

    }
    if(id.trim().length == 0 || !idRegex.test(id.trim())){
        document.querySelector("#form-container4").classList.add("error");
        document.querySelector("#id").classList.add("error");
        e.preventDefault();
    }
    if( address.trim() ==="") {
        e.preventDefault();
        document.querySelector("#form-container5").classList.add("error");
        document.querySelector("#address").classList.add("error");
    }

    if (phone.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container6").classList.add("error");
        document.querySelector("#phone").classList.add("error");

    }

    if (email.trim().length == 0  || !emailRegex.test(email.trim())) {
        e.preventDefault();
        document.querySelector("#form-container7").classList.add("error");
        document.querySelector("#email").classList.add("error");
        e.preventDefault();
    }
    if (bookNumber.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container8").classList.add("error");
        document.querySelector("#bookNumber").classList.add("error");

    }
    if (model.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container9").classList.add("error");
        document.querySelector("#model").classList.add("error");

    }
    if (seatAmount.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container10").classList.add("error");
        document.querySelector("#seatAmount").classList.add("error");

    }
    if (distance.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container11").classList.add("error");
        document.querySelector("#distance").classList.add("error");

    }
    if (carType.trim() === "") {
        e.preventDefault();
        document.querySelector("#form-container12").classList.add("error");
        document.querySelector("#carType").classList.add("error");

    }

    return 1;

});