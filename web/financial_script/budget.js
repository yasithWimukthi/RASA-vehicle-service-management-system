
function validation(){
    var x = document.forms["myForm"]["year"].value;
       if(x == "" ){
        alert("cannot be null");
       }
      if(x.length!= 4){
           alert("year cannot be less than 4 years");
           return false;
       }
      if(x < 2021){
           alert("cannot enter previous years");
           return false;
       }
       if(isNaN(x)){
           alert("year cannot be a text");
           return false;
       }
}