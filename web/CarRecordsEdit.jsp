<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 3/26/2021
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Registration Form</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css" >
    <link rel="stylesheet" href="styles/CarRecords_Edit.css">

</head>
<body>

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item side-nav__item--active">
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

                    <%-- edit form--%>

        <div class="main-content">

            <div class = "ui grid form-container">

                <div class="sixteen wide column">

                    <form id="form" method = "post" class="form" action = "<%=request.getContextPath()%>/CarRecordUpdateServlet">

                        <div class="ui huge form" id="form-container">
                            <div class="header">Car Registration Edit Page</div>
                        </div>

                            <div class="form-control" id="form-container1">
                                <label for="regNumber">Registration Number</label>
                                <input type="text" name="regNumber" id="regNumber" value="<%=request.getAttribute("regNumber")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Cannot Modify Registration Number!</small>
                            </div>

                            <div class="form-control" id="form-container2">
                                <label for="fname">First Name</label>
                                <input type="text" name="fname" id="fname" value="<%=request.getAttribute("fname")%>"
                                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                                <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                                <small>Please enter  valid first name</small>
                            </div>

                        <div class="form-control" id="form-container3">
                            <label for="lname">Last name</label>
                            <input type="text" name="lname" id="lname" value="<%=request.getAttribute("lname")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid last name</small>
                        </div>

                        <div class="form-control" id="form-container4">
                            <label for="id">NIC</label>
                            <input type="text" name="id" id="id" value="<%=request.getAttribute("id")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid NIC number</small>
                        </div>


                        <div class="form-control" id="form-container5">
                            <label for="address">Address</label>
                            <input type="text" name="address" id="address" value="<%=request.getAttribute("address")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid address</small>
                        </div>


                        <div class="form-control" id="form-container6">
                            <label for="phone">Phone number</label>
                            <input type="text" name="phone" id="phone" value="<%=request.getAttribute("phone")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid phone number</small>
                        </div>


                        <div class="form-control" id="form-container7">
                            <label for="email">email</label>
                            <input type="email" name="email" id="email" value="<%=request.getAttribute("email")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid email address</small>
                        </div>


                        <div class="form-control" id="form-container8">
                            <label for="bookNumber">Vehicle Book number</label>
                            <input type="text" name="bookNumber" id="bookNumber" value="<%=request.getAttribute("bookNumber")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid Book number</small>
                        </div>

                        <div class="form-control" id="form-container9">
                            <label for="model">Vehicle Model</label>
                            <input type="text" name="model" id="model" value="<%=request.getAttribute("model")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid vehicle model</small>
                        </div>


                        <div class="form-control" id="form-container10">
                            <label for="seatAmount">Vehicle seat amount</label>
                            <input type="text" name="seatAmount" id="seatAmount" value="<%=request.getAttribute("seatAmount")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid seatAmount</small>
                        </div>


                        <div class="form-control" id="form-container11">
                            <label for="distance">Distance</label>
                            <input type="text" name="distance" id="distance" value="<%=request.getAttribute("distance")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid distance</small>
                        </div>

                        <div class="form-control" id="form-container12">
                            <label for="carType">Car Condition</label>
                            <input type="text" name="carType" id="carType" value="<%=request.getAttribute("carType")%>"
                                <i class="fa fa-check-circle" aria-hidden="true"></i>
                            <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                            <small>Please enter valid car type</small>
                        </div>

                        <div class="justified">
                            <button type ="submit"> Update Details</button>
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
