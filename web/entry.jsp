<%@ page import="com.rasa.model.Repair" %>
<%@ page import="com.rasa.model.Customer" %>
<%@ page import="com.rasa.model.Vehicle" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/31/2021
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service Entry</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>
</head>
<body>

<%
    Repair repair = (Repair) request.getAttribute("repair");
    Customer customer = (Customer) request.getAttribute("client");
    Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
    String documents = "";

    if (repair.isCustomerNoObjection()){
        documents = documents+" "+"Customer No Objection";
    }
    if (repair.isLeasingNoObjection()){
        documents = documents+", "+"Leasing No Objection";
    }
    if (repair.isClaimForm())
    {
        documents = documents+", "+"Claim Form";
    }
%>

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item ">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                        <div class="side-nav__text">Add Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item side-nav__item--active">
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

            <div class="ui grid" style="margin-top:20px">

                <!-- Entry detail card -->

                <div class="eight wide column">
                    <div class="ui card" style="width: 95%; ">
                        <div class="content">
                            <div class="header" style="margin: 0 auto;">Entry Information</div>
                        </div>
                        <div class="content">
                            <div class="ui large feed">
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Repair Type      : <%=repair.getPaymentType()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Entry Date       : <%=repair.getEntryDate()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Accident Date    : <%=repair.getAccidentDate()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Progress         : <%=repair.getProgress()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Documents : <%=documents%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="extra content">
                            <button class="ui active green fluid button huge " id="entry-edit">
                                <i class="edit icon"></i>
                                edit
                            </button>
                        </div>
                    </div>
                </div>


                <!-- customer detail card -->
                <div class="eight wide column">
                    <div class="ui card" style="width: 95%;">
                        <div class="content">
                            <div class="header" style="margin: 0 auto;">Client Information</div>
                        </div>
                        <div class="content">
                            <div class="ui large feed">
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Client Name : <%=customer.getFirstName()%> <%=customer.getLastName()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>NIC Number : <%=customer.getNICno()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Email : <%=customer.getEmail()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Telephone Number : <%=customer.getPhoneNo()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Address : <%=customer.getAddress()%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="extra content">
                            <button class="ui active green fluid button huge" id="update-client">
                                <i class="edit icon"></i>
                                edit
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- firs row end -->

            <div class="ui grid" style="margin-top:20px">

                <!-- vehicle details card -->
                <div class="eight wide column">
                    <div class="ui card" style="width: 95%; ">
                        <div class="content">
                            <div class="header" style="margin: 0 auto;">Vehicle Information</div>
                        </div>
                        <div class="content">
                            <div class="ui large feed">
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Registration Number : <%=vehicle.getRegistrationNo().toUpperCase()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Manufactured Year : <%=vehicle.getYear()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Brand : <%=vehicle.getBrand()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Model : <%=vehicle.getModel()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Color : <%=vehicle.getColor()%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="extra content">
                            <button class="ui active green fluid button huge" id="update-vehicle">
                                <i class="edit icon"></i>
                                edit
                            </button>
                        </div>
                    </div>
                </div>

                <!-- Buttons -->
                <div class="class= eight wide column button-container" >

                    <form method="post" action="DeleteServiceEntryServlet" class="mb-10">
                        <input type="hidden" name="serviceID" value="<%=repair.getRepairId()%>">
                        <button class="ui red fluid button" type="submit" style="width:95%; height:35px">
                            <i class="trash icon"> </i>
                            Delete Entry
                        </button>
                    </form>
<%--                    <button class="ui red fluid button " type="button" id="deleteBtn" style="width:95%; height:35px">--%>
<%--                        <i class="trash icon"> </i>--%>
<%--                        Delete Entry--%>
<%--                    </button>--%>

                    <button class="ui blue fluid button" style="width:95%; height:35px; margin-bottom: 10px;" class="mb-10">
                        <i class="address card outline icon"> </i>
                        Client Report
                    </button>

                    <button class="ui blue fluid button" style="width:95%; height:35px;margin-bottom: 10px" class="mb-10">
                        <i class="clipboard outline icon"> </i>
                        Entry Report
                    </button>

                    <form method="post" action="NavigateToWorkprogressServlet">
                        <input type="hidden" name="sid" value="<%=repair.getRepairId()%>">
                        <button type="submit" class="ui green fluid button" style="width:95%; height:35px;margin-bottom: 10px" class="mb-10">
                            <i class="chart line icon"> </i>
                            Work Progress
                        </button>
                    </form>

                    <form method="post" action="NavigateToWorkprogressServlet" style="margin-bottom: 100px">
                        <input type="hidden" name="sid" value="<%=repair.getRepairId()%>">
                        <button type="submit" class="ui green fluid button" style="width:95%; height:35px" class="mb-10">
                            <i class="dollar sign icon icon"> </i>
                            Financial Management
                        </button>
                    </form>
                </div>

            </div>
            <!-- second row end -->

<%--            <div class="ui grid">--%>
<%--                <div class="sixteen wide column">--%>
<%--                    <div class="ui placeholder segment" style="width:95%">--%>
<%--                        <div class="ui icon header">--%>
<%--                            <i class="file image outline icon"></i>--%>
<%--                            No images are listed for this customer.--%>
<%--                        </div>--%>
<%--                        <div class="ui primary button">Add Images</div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="ui grid" style="margin-bottom: 100px;">--%>
<%--                <div class="sixteen wide column">--%>
<%--                    <div class="ui placeholder segment" style="width:95%">--%>
<%--                        <div class="ui icon header">--%>
<%--                            <i class="file image outline icon"></i>--%>
<%--                            No images are listed for this customer.--%>
<%--                        </div>--%>
<%--                        <div class="ui primary button">Add Images</div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

            <!-- entry model form -->
            <div class="ui modal entry-edit-form" style="padding:50px">
                <i class="close icon"></i>
                <div class="header">
                    Update Entry
                </div>

                <form method="post" id="entryUpdateForm" action="UpdateEntryServlet" >
                    <div class="ui huge form" style="margin:50px" id="form-container">
                        <div class="two fields">
                            <div class="field">
                                <label>Customer Name</label>
                                <input placeholder="Customer Name" type="text"  value="<%=customer.getFirstName()%> <%=customer.getLastName()%>" disabled>
                            </div>
                            <div class="field">
                                <label>Vehicle Registration Number</label>
                                <input placeholder="Registration Number" type="text" value="<%=vehicle.getRegistrationNo().toUpperCase()%>" disabled>
                            </div>
                        </div>

                        <div class="field" id="entryDateContainer">
                            <label>Entry Date</label>
                            <input placeholder="Entry Date" type="date" id="entryDate" value="<%=repair.getEntryDate()%>">
                        </div>

                        <div class="inline fields">
                            <label for="repair">Repair Type:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="reapir" checked tabindex="10" class="hidden" id="insurance" value="insurance">
                                    <label>Insuarance</label>
                                </div>
                            </div>

                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="reapir"  tabindex="0" class="hidden" id="nonInsurance" value="nonInsurance">
                                    <label>Non-Insuarance</label>
                                </div>
                            </div>
                        </div>

                        <div class="field"  id="accidentDateContainer">
                            <label>Accident Date</label>
                            <input placeholder="Accident Date" type="date" id="accidentDate" name="accidentDate" value="<%=repair.getAccidentDate()%>">
                        </div>

                        <div class="inline field" id="document-container" style="display: none; ">
                            <label for="repair">Repair Type:</label>
                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden" name="customerNoObjection">
                                <label>Customer No objection</label>
                            </div>

                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden" name="insuranceNoObjection">
                                <label>Insuarance No objection</label>
                            </div>

                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden" name="claimForm">
                                <label>Claim Form</label>
                            </div>
                        </div>

                        <input type="hidden" value="<%=repair.getRepairId()%>" name="repairId">
                        <input type="hidden" value="<%=customer.getNICno()%>" name="nic">
                        <input type="hidden" value="<%=vehicle.getRegistrationNo()%>" name="registrationNumber" >

                        <div class="ui error message">
                            <div class="header">Action Forbidden</div>
                            <p>Form is incomplete.</p>
                        </div>

                        <div class="actions">
                            <div class="ui red huge deny button">
                                Cancel
                            </div>
                            <button type="submit" class="ui positive right labeled icon huge button">
                                Edit
                                <i class="checkmark icon"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- client model form end-->
            <div class="ui modal client-edit-form" style="padding:50px">

                <i class="close icon"></i>
                <div class="header">
                    Update Client Information
                </div>

                <form method="post" id="clientUpdateForm" action="UpdateClientServlet">
                    <div class="ui huge form" id="client-form-container" style="margin:50px">

                        <div class="two fields">
                            <div class="field " id="fnameContainer">
                                <label>First Name</label>
                                <input placeholder="First Name" type="text" id="fname" name="fname" value="<%=customer.getFirstName()%>">
                            </div>
                            <div class="field" id="lnameContainer">
                                <label>Last Name</label>
                                <input placeholder="Last Name" type="text" id="lname" name="lname" value="<%=customer.getLastName()%>">
                            </div>
                        </div>

                        <div class="two fields">
                            <div class="field" id="nicContainer">
                                <label>NIC Number</label>
                                <input placeholder="NIC Number" type="text" id="nic" name="nicNumber" value="<%=customer.getNICno()%>" disabled>
                            </div>
                            <div class="field" id="mobileContainer">
                                <label>Phone Number</label>
                                <input placeholder="Phone Number" type="text" id="mobile" name="mobile" value="<%=customer.getPhoneNo()%>">
                            </div>
                        </div>

                        <div class="field" id="addressContainer">
                            <label>Address</label>
                            <input placeholder="Address" type="text" id="address" name="address" value="<%=customer.getAddress()%>">
                        </div>

                        <div class="field" id="emailContainer">
                            <label>Email</label>
                            <input placeholder="Email" type="Email" id="email" name="email" value="<%=customer.getEmail()%>">
                        </div>

                        <input type="hidden" name="nic" value="<%=customer.getNICno()%>">
                        <input type="hidden" value="<%=repair.getRepairId()%>" name="repairId">
                        <input type="hidden" value="<%=vehicle.getRegistrationNo()%>" name="registrationNumber" >

                        <div class="ui error message">
                            <div class="header">Action Forbidden</div>
                            <p>Form is incomplete.</p>
                        </div>

                        <div class="actions">
                            <div class="ui red huge deny button">
                                Cancel
                            </div>
                            <button type="submit" class="ui positive right labeled icon huge button">
                                Edit
                                <i class="checkmark icon"></i>
                            </button>
                        </div>

                    </div>
                </form>
            </div>

            <!-- edit vehicle information form -->
            <div class="ui modal vehicle-edit-form" style="padding:50px" >

                <i class="close icon"></i>
                <div class="header">
                    Update Vihicle Information
                </div>

                <form method="post" id="vehicleUpdateForm" action="UpdateVehicleServlet">
                    <div class="ui huge form" style="margin:50px" id="vehicleUpdateFormContainer">
                        <div class="field">
                            <label>Vehicle Registration Number</label>
                            <input type="text" placeholder="Registration Number" value="<%=vehicle.getRegistrationNo().toUpperCase()%>" disabled>
                        </div>

                        <div class="field" id="brandContainer" >
                            <label>Brand Name</label>
                            <input type="text" placeholder="Brand Name" id="brand" value="<%=vehicle.getBrand()%>" name="brand">
                        </div>

                        <div class="two fields">
                            <div class="field" id="modelContainer">
                                <label>Model</label>
                                <input placeholder="Vehicle Model" type="text" id="model" name="model" value="<%=vehicle.getModel()%>">
                            </div>
                            <div class="field" id="colorContainer">
                                <label>Color</label>
                                <input placeholder="Vehicle Color" type="text" id="color" name="color" value="<%=vehicle.getColor()%>">
                            </div>
                        </div>

                        <div class="field" id="manufactYearContainer">
                            <label>Manufactured Year</label>
                            <input type="text" placeholder="Manufacture Year" name="manufactureYear" id="manufactureYear" value="<%=vehicle.getYear()%>">
                        </div>

                        <input type="hidden" value="<%=vehicle.getRegistrationNo().toUpperCase()%>" name="registrationNumber">
                        <input type="hidden" name="nic" value="<%=customer.getNICno()%>">
                        <input type="hidden" value="<%=repair.getRepairId()%>" name="repairId">

                        <div class="ui error message">
                            <div class="header">Action Forbidden</div>
                            <p>Form is incomplete.</p>
                        </div>

                        <div class="actions">
                            <div class="ui red huge deny button">
                                Cancel
                            </div>
                            <button type="submit" class="ui positive right labeled icon huge button">
                                Edit
                                <i class="checkmark icon"></i>
                            </button>
                        </div>

                    </div>
                </form>
            </div>

<%--                confirm delete model--%>
            <div class=" ui tiny modal ">
                <div class="header">Header</div>
                <div class="content">
                    <p>Are You Want To Delete This Service Entry ?</p>
                </div>
                <div class="actions">
                    <button class="ui approve button">Delete</button>
                    <div class="ui cancel button">Cancel</div>
                </div>
            </div>

        </div>

    </div>
</div>

<script src="scripts/entry.js"></script>

</body>
</html>
