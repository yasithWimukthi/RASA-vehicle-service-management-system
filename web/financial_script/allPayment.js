let paymentForm = document.querySelector("#form");

paymentForm.addEventListener("submit", e => {
    let date = document.querySelector("#date").value;

    if(date.trim() ===""){
        e.preventDefault();
        document.querySelector("#form-container").classList.add("error");
        document.querySelector("#date").classList.add("error");

    }else {
        document.querySelector("#date").classList.remove("error");

    }

});