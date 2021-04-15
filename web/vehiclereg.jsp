<%@ page import="com.rasa.model.Vehicle" %><%--
  Created by IntelliJ IDEA.
  User: yasith wimukthi
  Date: 3/23/2021
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vehicle registration</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>
    <style>
        .search-bar-container {
            height: 50px;
        }

        .search-wrapper {
            width: 100%;
            margin: 5px;
        }

        .searchBar {
            width: 90%;
            height: 100%;
        }

        form #input-box {
            width: 100%;
            height: 4rem;
            background: var(--input-box-bg);
            padding: 1.5rem;
            font-size: 1.5rem;
            font-weight: bold;
            font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            color: #333;
            outline: none;
            border: none;
        }

        form #search-submit-btn {
            width: 3.5rem;
            height: 2.8rem;
            margin-left: -3.5rem;
            background: none;
            border: none;
            outline: none;
        }

        form #search-submit-btn:hover {
            cursor: pointer;
        }
    </style>
</head>
<body>

<%
    Vehicle vehicle = new Vehicle();
    vehicle = (Vehicle) request.getAttribute("vehicle");

    String fullName = (String) request.getAttribute("fullName");

    String registrationNumber = "";
    String year = "";
    String model = "";
    String color = "";
    String brand = "";
    boolean update = false;
    boolean isExist = false;

    try {
        if (vehicle != null){
            registrationNumber = vehicle.getRegistrationNo().toUpperCase();
            year = String.valueOf(vehicle.getYear());
            model = vehicle.getModel();
            color = vehicle.getColor();
            brand = vehicle.getBrand();
            update = true;
        }
    }catch (NullPointerException e){
        e.printStackTrace();
        registrationNumber = "";
        year = "";
        model = "";
        color = "";
        brand = "";
        isExist = true;
    }


%>

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item side-nav__item--active">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon"></i>
                        <div class="side-nav__text">Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item">
                    <a href="#" class="side-nav__link">
                        <i class="search icon side-nav__icon"></i>
                        <div class="side-nav__text">Search Entry</div>
                    </a>
                </li>

                <li class="side-nav__item">
                    <a href="#" class="side-nav__link">
                        <i class="tasks icon side-nav__icon"></i>
                        <div class="side-nav__text">Work Progress</div>
                    </a>
                </li>

            </ul>

            <div class="legal">
                &copy; 2021 by RASA. All rights reserved.
            </div>
        </div>

        <div class="main-content">

            <!-- TOP SERARCH BAR -->

            <div class="ui grid search-bar-container">
                <div class="sixteen wide column">
                    <div class="search-wrapper">
                        <form method="post" id="search-form" action="SearchVehicleServlet">
                            <div class="ui action input massive searchBar">
                                <input type="text" placeholder="Enter Registration Number..." id="input-box" class="searchWord" name="registrationNumber" >
                                <button type="submit" class="ui icon button" style="height: 69%">
                                    <i class="search icon" ></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <!--STEP BAR-->

            <div class="ui steps" style="width: 90%; margin-top:50px; margin-bottom:0">
                <div class="step">
                    <i class="user icon"></i>
                    <div class="content">
                        <div class="title">Customer Registration</div>
                        <div class="description">Enter client details</div>
                    </div>
                </div>
                <div class="active step">
                    <i class="car icon"></i>
                    <div class="content">
                        <div class="title">Vehicle Registration</div>
                        <div class="description">Enter Vehicle Information</div>
                    </div>
                </div>
                <div class="disabled step">
                    <i class="clipboard outline icon"></i>
                    <div class="content">
                        <div class="title">Service Entry</div>
                        <div class="description">Enter Service Entry Information</div>
                    </div>
                </div>
            </div>

            <!-- MESSAGE -->
            <% if(vehicle != null && update) {%>
            <div class="ui success message" style="width: 90%">
                <i class="close icon"></i>
                <div class="header">
                    Vehicle is already exist.
                </div>
                <p>You can update vehicle details. </p>
            </div>
            <% } %>

            <% if(isExist) {%>
            <div class="ui error message" style="width: 90%">
                <i class="close icon"></i>
                <div class="header">
                    Vehicle is not exist.
                </div>
                <p>You can enter vehicle details. </p>
            </div>
            <% } %>



            <!-- VEHICLE DETAILS FORM -->
            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <form method="post" id="vehicleRegForm" action="AddVehicleServlet">
                        <div class="ui huge form" id="form-container">

                            <div class="field">
                                <label>Vehicle Registration Number</label>
                                <input type="text" placeholder="Registration Number" name="regID" id="regID" value="<%= registrationNumber%>" <%=update ? "disabled" : "null"%>>
                            </div>

                            <% if(!update) {%>
                                <div class="field" id="brandContainer" >
                                    <label>Brand Name</label>
                                    <select class="ui search dropdown" name="brand" id="brand">
                                        <option value="Toyota">Toyota</option>
                                        <option value="Nissan">Nissan</option>
                                        <option value="Susuki">Susuki</option>
                                        <option value="BMW">BMW</option>
                                        <option value="Benze">Benze</option>
                                        <option value="Other">Other</option>
                                    </select>
                                </div>

                                <div class="field" id="OtherBrandContainer" style="display: none">
                                    <label>Brand Name</label>
                                    <input type="text" placeholder="Brand Name" name="otherBrand" id="otherBrand" >
                                </div>
                            <% }else {%>
                                <div class="field" id="updateBrandContainer" style="display: block">
                                    <label>Brand Name</label>
                                    <input type="text" placeholder="Brand Name" name="brand" id="updateBrand" value="<%=vehicle.getBrand()%>">
                                </div>
                            <% }%>

                            <div class="two fields">
                                <div class="field" id="modelContainer">
                                    <label>Model</label>
                                    <input placeholder="Vehile Model" type="text" name="model" id="model" value="<%= model%>">
                                </div>
                                <div class="field" id="colorContainer">
                                    <label>Color</label>
                                    <input placeholder="Vehicle Color" type="text" name="color" id="color" value="<%= color%>">
                                </div>
                            </div>

                            <div class="field" id="manufactYearContainer">
                                <label>Manufactured Year</label>
                                <input type="text" placeholder="Brand Name" name="manufactureYear" id="manufactureYear" value="<%= year%>">
                            </div>

                            <input type="hidden" value="<%=update%>" name="update">
                            <input type="hidden" value="<%=registrationNumber%>" name="vehicleNumber">
                            <input type="hidden" value="<%=fullName%>" name="fullName">

                            <div class="ui error message">
                                <div class="header">Action Forbidden</div>
                                <p>Form is incomplete.</p>
                            </div>

                            <button type="submit" class="ui fluid inverted orange labeled icon button submit-btn">
                                <i class="right arrow icon" style="font-size: 1.5em;"></i>
                                Next
                            </button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="scripts/vehicleRegistration.js"></script>

</body>
</html>
