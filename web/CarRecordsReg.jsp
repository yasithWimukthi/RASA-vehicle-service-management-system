<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 3/26/2021
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/CarRecords_Reg.css">

</head>
<body>

                            <%--body in form--%>

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                        <div class="side-nav__text">Add Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item">
                    <a href="#" class="side-nav__link">
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

                <li class="side-nav__item side-nav__item--active">
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

            <div class = "ui grid form-container">

                <div class="sixteen wide column">

                    <form id="form" method = "post" class="form" action = "<%=request.getContextPath()%>/CarRecordInsertServlet">

                        <div class="ui huge form" id="form-container">
                            <div class="header">Car Registration</div>
                        </div>

                                <div class="form-control" id="form-container2">
                                    <label for="FirstName">First Name</label>
                                    <input type="text" name="fname" id="fname" placeholder="Enter First Name..!!">
                                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                    <small>Please enter  valid first name</small>
                                </div>


                         <div class="form-control" id="form-container3">
                                <label for="lname">Last name</label>
                                <input type="text" name="lname" id="lname" placeholder="Enter Last Name..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid last name</small>
                            </div>

                            <div class="form-control" id="form-container4">
                                <label for="id">NIC</label>
                                <input type="text" name="id" id="id" placeholder="Enter ID number..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid NIC number</small>
                            </div>


                            <div class="form-control" id="form-container5">
                                <label for="address">Address</label>
                                <input type="text" name="address" id="address" placeholder="Enter ID number..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid address</small>
                            </div>


                            <div class="form-control" id="form-container6">
                                <label for="phone">Phone number</label>
                                <input type="text" name="phone" id="phone" placeholder="Enter ID number..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid phone number</small>
                            </div>


                            <div class="form-control" id="form-container7">
                                <label for="email">email</label>
                                <input type="email" name="email" id="email" placeholder="Enter Email Address..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid email address</small>
                            </div>


                            <div class="form-control" id="form-container8">
                                <label for="bookNumber">Vehicle Book number</label>
                                <input type="text" name="bookNumber" id="bookNumber" placeholder="Enter Car Book Number..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid Book number</small>
                            </div>

                            <div class="form-control" id="form-container9">
                                <%--@declare id="model"--%><label for="model">Vehicle Model</label>
                                <input type="text" name="model" id="model" placeholder="Enter Vehicle Model..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid vehicle model</small>
                            </div>


                            <div class="form-control" id="form-container10">
                                <label for="seatAmount">Vehicle seat amount</label>
                                <input type="text" name="seatAmount" id="seatAmount" placeholder="Enter Seat Amount..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid seatAmount</small>
                            </div>


                            <div class="form-control" id="form-container11">
                                <label for="distance">Distance</label>
                                <input type="text" name="distance" id="distance" placeholder="Enter Distance before Registration..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid distance</small>
                            </div>

                            <div class="form-control" id="form-container12">
                                <label for="carType">Car Condition</label>
                                <input type="text" name="carType" id="carType" placeholder="Enter Car Condition..!!">
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter valid car type</small>
                            </div>

                            <div class="justified">
                                <button type ="submit"> Register</button>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="scripts/carRecords.js"></script>
</body>
</html>

                            <%-- js link in external format

                            <script>
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

                            </script>--%>


