
function validation(){
    var x = document.forms["myForm"]["year"].value;
    if(x == "" ){
        alert("cannot be null");
        return false;
    }
    if(isNaN(x)){
        alert("year cannot be a text");
        return false;
    }
    if(x.length!= 4){
        alert("Year is not proper.Please check");
        return false;
    }
    if(x < 2021){
        alert("cannot enter previous years");
        return false;
    }
}