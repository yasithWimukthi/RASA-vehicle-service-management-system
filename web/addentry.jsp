<%--
  Created by IntelliJ IDEA.
  User: yasith wimukthi
  Date: 3/23/2021
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Entry</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    //String fullName = (String) request.getAttribute("fullName");
    String regID = (String) request.getAttribute("regID");
    String nic = (String) request.getAttribute("nic");
%>

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

        <div class="main-content">

            <!--STEP BAR-->

            <div class="ui steps" style="width: 90%; margin-top:50px; margin-bottom:0">
                <div class="step">
                    <i class="user icon"></i>
                    <div class="content">
                        <div class="title">Customer Registration</div>
                        <div class="description">Enter client details</div>
                    </div>
                </div>
                <div class=" step">
                    <i class="car icon"></i>
                    <div class="content">
                        <div class="title">Vehicle Registration</div>
                        <div class="description">Enter Vehicle Information</div>
                    </div>
                </div>
                <div class="active step">
                    <i class="clipboard outline icon"></i>
                    <div class="content">
                        <div class="title">Service Entry</div>
                        <div class="description">Enter Service Entry Information</div>
                    </div>
                </div>
            </div>

            <!-- ADD ENTRY FORM -->
            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <form method="post" id="entry-form"action="AddServiceEntryServlet">
                        <div class="ui huge form" id="form-container">

<%--                            <div class="two fields">--%>
<%--                                <div class="field">--%>
<%--                                    <label>Customer Name</label>--%>
<%--                                    <input placeholder="Customer Name" type="text" name="customerName" value="<%=fullName%>">--%>
<%--                                </div>--%>
<%--                                <div class="field">--%>
<%--                                    <label>Vehicle Registration Number</label>--%>
<%--                                    <input placeholder="Registration Number" type="text" name="registrationNumber" value="<%=regID%>">--%>
<%--                                </div>--%>
<%--                            </div>--%>

                            <div class="field">
                                <label>Vehicle Registration Number</label>
                                <input placeholder="Registration Number" type="text" name="regID" value="<%=regID%>" disabled>
                            </div>

                            <div class="field">
                                <label>NIC Number</label>
                                <input placeholder="NIC Number" type="text" name="nic" value="<%=nic%>" disabled>
                            </div>

                            <div class="field" id="entryDateContainer">
                                <label>Entry Date</label>
                                <input placeholder="Entry Date" type="date" name="entryDate" id="entryDate">
                            </div>

                            <div class="field" id="accidentDateContainer">
                                <label>Accident Date</label>
                                <input placeholder="Accident Date" type="date" id="accidentDate" name="accidentDate">
                            </div>

                            <div class="inline fields">
                                <label for="repair">Repair Type:</label>
                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="repair" checked tabindex="10" class="hidden" id="insurance" value="Insuarance">
                                        <label style="font-size: 16px">Insuarance</label>
                                    </div>
                                </div>

                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="repair"  tabindex="0" class="hidden" id="nonInsurance" value="Non Insurance">
                                        <label style="font-size: 16px">Non-Insuarance</label>
                                    </div>
                                </div>
                            </div>

                            <div class="inline field" id="document-container" style="display: none">
                                <label >Repair Type:</label>
                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden" name="customerNoObjection">
                                    <label style="font-size: 16px; margin-right: 15px;margin-bottom: 30px">Customer No objection</label>
                                </div>

                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden" name="insuranceNoObjection">
                                    <label style="font-size: 16px; margin-right: 15px">Insuarance No objection</label>
                                </div>

                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden" name="claimForm">
                                    <label style="font-size: 16px">Claim Form</label>
                                </div>
                            </div>

                            <input type="hidden" value="<%=regID%>" name="registrationNumber">
                            <input type="hidden" value="<%=nic%>" name="nicNumber">

                            <div class="ui error message">
                                <div class="header">Action Forbidden</div>
                                <p>Form is incomplete.</p>
                            </div>

                            <button type="submit" class="ui fluid inverted green labeled icon button submit-btn" id="entry-submit">
                                <i class="right check icon" style="font-size: 1.5em;margin-top: 10px"></i>
                                complete
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="scripts/entryValidate.js">
    // $('.ui.radio.checkbox')
    //     .checkbox();
    //
    // $('.ui.checkbox')
    //     .checkbox();
    //
    // // $( "#submit-btn" ).click(function() {
    // //     $('.ui.basic.modal')
    // //     .modal('show');
    // // });
    //
    // $( "#entry-form" ).submit(function( event ) {
    //     //alert( "Handler for .submit() called." );
    //     event.preventDefault();
    //     $('.ui.basic.modal')
    //         .modal('show');
    // });
</script>


</body>
</html>
