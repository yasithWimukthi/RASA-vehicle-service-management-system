function validation() {
    let id= document.forms["adv_form"]["employeeID"].value;
    let advance = document.forms["adv_form"]["amount"].value;
    if (id == "" && advance == "") {
        alert("Form must be filled out");
        return false;
    }
    else {

        if (id == "") {
            alert("ID must be filled out");
            return false;
        }
        if (advance == "") {
            alert("Amount must be filled out");
            return false;
        }

        if (advance < 0 ) {
            alert("Amount must be greater than 0");
            return false;
        }
    }

    if(isNaN(id)){
        alert("EmpID must be a number");
        return false;
    }

}