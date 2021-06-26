function  validation() {

    let bonus= document.forms["pay_form"]["bonus"].value;
    let deduct= document.forms["pay_form"]["deduct"].value;

    if(isNaN(bonus)){
        alert("bonus must be a numer");
    }
    if(isNaN(bonus)){
        alert("ededuct must be a number");
    }
}