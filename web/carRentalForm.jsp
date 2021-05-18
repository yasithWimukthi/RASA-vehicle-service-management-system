<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/19/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Rental Form</title>
</head>
    <title>Car Rental Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <link rel="stylesheet" href="styles/nav.css">
    <link rel="stylesheet" href="styles/carRentalForm.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
    <script>
        function validate(){
            let num = document.myForm.rentalprice.value;
            let fName = document.myForm.firstname.value;
            let lName = document.myForm.lastname.value;
            let email = document.myForm.email.value;
            let mobile = document.myForm.mobile.value;
            let atPosition = email.indexOf("@");
            let dotPosition = email.lastIndexOf(".");
            let address = document.myForm.address.value;
            let pickUpDate = document.myForm.pickupdate.value;
            let dropOffDate = document.myForm.dropoffdate.value;

            if(fName==null || fName==""){
                document.getElementById("fname").style.borderColor="red";
                document.getElementById("fnameloc").innerHTML="First name can't be blank";
                return false;
            }if(lName==null || lName==""){
                document.getElementById("lname").style.borderColor="red";
                document.getElementById("lnameloc").innerHTML="Last name can't be blank";
                return false;
            }if(atPosition<1 || dotPosition<atPosition+2 || dotPosition+2>=email.length){
                document.getElementById("email").style.borderColor="red";
                document.getElementById("emailloc").innerHTML="Please enter a valid e-mail address.Ex:abc@gmail.com"
                return false;
            }if(mobile==null || mobile==""){
                document.getElementById("mobile").style.borderColor="red";
                document.getElementById("mobileloc").innerHTML="Mobile number can't be blank"
                return false;
            }if(address==null || address==""){
                document.getElementById("address").style.borderColor="red";
                document.getElementById("addressloc").innerHTML="Address can't be blank";
                return false;
            }if(pickUpDate==null || pickUpDate==""){
                document.getElementById("pickupdate").style.borderColor="red";
                document.getElementById("pickuploc").innerHTML="Pick up date can't be blank";
                return false;
            }if(dropOffDate==null || dropOffDate==""){
                document.getElementById("dropoffdate").style.borderColor="red";
                document.getElementById("dropoffloc").innerHTML="Drop off date can't be blank";
                return false;
            }if(num==null || num=="") {
                document.getElementById("rprice").style.borderColor="red";
                document.getElementById("numloc").innerHTML = "Rent price can't be blanck";
                return false;
            }if(isNaN(num)) {
                document.getElementById("rprice").style.borderColor="red";
                document.getElementById("numloc").innerHTML = "Enter Numeric values only";
                return false;
            }
            else{
                return true;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="sidebar">
                <ul class="side-nav">

                    <li class="side-nav_item side-nav_item--active">
                        <a href="#" class="side-nav__link">
                            <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Add Service Entry</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="searchservice.jsp" class="side-nav__link">
                            <i class="search icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Search Entry</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="#" class="side-nav__link">
                            <i class="dollar sign icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Budget Management</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="#" class="side-nav__link">
                            <i class="truck icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Inventory Management</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="#" class="side-nav__link">
                            <i class="address book outline icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Employee Management</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="#" class="side-nav__link">
                            <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Car Rent</div>
                        </a>
                    </li>

                    <li class="side-nav__item">
                        <a href="#" class="side-nav__link">
                            <i class="file outline icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                            <div class="side-nav__text">Car Record</div>
                        </a>
                    </li>

                </ul>

                <div class="legal">
                    &copy; 2021 by RASA. All rights reserved.
                </div>
            </div>

            <div class="main-content">
                <div class="form-container">
                    <h1>Rent the Car</h1>
                    <form action="<%=request.getContextPath()%>/InsertRentalDetailsServlet" id="carRentForm" name="myForm" method="post" onsubmit="return validate()">
                        <div id="form-container">
                            <div class="row" id="">
                                <div class="col-25">
                                    <label>First name</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="firstname" id="fname" placeholder="First name"><div class="ui-icon-alert"><span style="color:red"id="fnameloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Last name</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="lastname" id="lname" placeholder="Last name"><div class="ui-icon-alert"><span style="color:red"id="lnameloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>E-mail</label>
                                </div>
                                <div class="col-75">
                                    <input type="email" name="email" id="email" placeholder="abc@gmail.com"><div class="ui-icon-alert"><span style="color:red"id="emailloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Mobile Number</label>
                                </div>
                                <div class="col-75">
                                    <input type="phone" name="mobile" id="mobile" pattern="[0-9]{10}" placeholder="1234567890"><div class="ui-icon-alert"><span style="color:red"id="mobileloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Address</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="address" id="address" placeholder="Address"><div class="ui-icon-alert"><span style="color:red"id="addressloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Pick up Date</label>
                                </div>
                                <div class="col-75">
                                    <input type="date" name="pickupdate" id="pickupdate" placeholder="Pick up date"><div class="ui-icon-alert"><span style="color:red"id="pickuploc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Drop off Date</label>
                                </div>
                                <div class="col-75">
                                    <input type="date" name="dropoffdate" id="dropoffdate" placeholder="Drop off date"><div class="ui-icon-alert"><span style="color:red"id="dropoffloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Rental Price</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="rentalprice" id="rprice" placeholder="Rental price"><div class="ui-icon-alert"><span style="color:red"id="numloc"></span></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label>Registration Number</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="registrationnumber" placeholder="Registration Number" value="<%=request.getAttribute("regNo")%>" required>
                                </div>
                            </div></br>
                            <div class="row">
                                <input type="submit" class="submit-btn" value="Rent">
                                <input type="reset" class="submit-btn" value="Reset">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>