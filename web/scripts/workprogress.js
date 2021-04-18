//check user enter valid service
function checkform() {
    if(document.getElementById('select_service').value == ""){
        document.getElementById('select_service').style.borderColor = "red";
        document.getElementById("error").innerHTML = "Please Enter service type"
        document.getElementById("errID").style.display="flex";
        return false;
    }
}
function checkComponentForm() {
    var estimateAmount = document.getElementById('estiID').value;
    if(estimateAmount == ""){
        document.getElementById('estiID').style.borderColor = "red";
        document.getElementById('errID').innerHTML = "Enter estimate amount";
        document.getElementById('errCon').style.display ='flex';
        return false;

   }

   if(isNaN(Number(estimateAmount))){
       document.getElementById('estiID').style.borderColor = "red";
       document.getElementById('errID').innerHTML = "Invalid Amount";
       document.getElementById('errCon').style.display ='flex';
       return false;
   }
}
