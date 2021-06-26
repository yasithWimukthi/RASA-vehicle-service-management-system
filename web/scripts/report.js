function validation(){
    let year = document.forms["frm"]["year"].value;
    if(year==""){
        alert("cannot be null");
        return false;
    }
    if(isNaN(year)){
        alert("cannot be text");
        return false;
    }
    if(year.length != 4 ){
        alert("check again");
        return false;
    }
}