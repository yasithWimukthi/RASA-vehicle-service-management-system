<%--
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

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item ">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon"></i>
                        <div class="side-nav__text">Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item side-nav__item--active">
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
                                            <p>Repair Type </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Entry Date </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Accident Date </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Repair Type</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Douments</p>
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
                                            <p>Client Name </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>NIC Number </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Email </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Telephone Number</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p> Address </p>
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
                                            <p>Registration Number </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Manufactured Year </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Brand </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Model</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="event">
                                    <div class="content">
                                        <div class="summary">
                                            <p>Color</p>
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

                    <button class="ui red fluid button" style="width:95%; height:35px">
                        <i class="trash icon"> </i>
                        Delete Entry
                    </button>

                    <button class="ui blue fluid button" style="width:95%; height:35px">
                        <i class="address card outline icon"> </i>
                        Client Report
                    </button>

                    <button class="ui blue fluid button" style="width:95%; height:35px">
                        <i class="clipboard outline icon"> </i>
                        Entry Report
                    </button>

                    <button class="ui green fluid button" style="width:95%; height:35px">
                        <i class="chart line icon"> </i>
                        Work Progress
                    </button>

                </div>

            </div>
            <!-- second row end -->

            <div class="ui grid">
                <div class="sixteen wide column">
                    <div class="ui placeholder segment" style="width:95%">
                        <div class="ui icon header">
                            <i class="file image outline icon"></i>
                            No images are listed for this customer.
                        </div>
                        <div class="ui primary button">Add Images</div>
                    </div>
                </div>
            </div>

            <div class="ui grid" style="margin-bottom: 100px;">
                <div class="sixteen wide column">
                    <div class="ui placeholder segment" style="width:95%">
                        <div class="ui icon header">
                            <i class="file image outline icon"></i>
                            No images are listed for this customer.
                        </div>
                        <div class="ui primary button">Add Images</div>
                    </div>
                </div>
            </div>

            <!-- entry model form -->
            <div class="ui modal entry-edit-form" style="padding:50px">
                <i class="close icon"></i>
                <div class="header">
                    Update Entry
                </div>

                <form method="post" id="entryUpdateForm">
                    <div class="ui huge form" style="margin:50px" id="form-container">
                        <div class="two fields">
                            <div class="field">
                                <label>Customer Name</label>
                                <input placeholder="Customer Name" type="text" >
                            </div>
                            <div class="field">
                                <label>Vehicle Registration Number</label>
                                <input placeholder="Registration Number" type="text" disabled>
                            </div>
                        </div>

                        <div class="field" id="entryDateContainer">
                            <label>Entry Date</label>
                            <input placeholder="Entry Date" type="date" id="entryDate">
                        </div>

                        <div class="inline fields">
                            <label for="repair">Repair Type:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="reapir" checked="" tabindex="10" class="hidden">
                                    <label>Insuarance</label>
                                </div>
                            </div>

                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="reapir" checked="" tabindex="0" class="hidden">
                                    <label>Non-Insuarance</label>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label>Accident Date</label>
                            <input placeholder="Accident Date" type="date">
                        </div>

                        <div class="inline field">
                            <label for="repair">Repair Type:</label>
                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden">
                                <label>Customer No objection</label>
                            </div>

                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden">
                                <label>Insuarance No objection</label>
                            </div>

                            <div class="ui checkbox">
                                <input type="checkbox" tabindex="0" class="hidden">
                                <label>Claim Form</label>
                            </div>
                        </div>

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

                <form method="post" id="clientUpdateForm">
                    <div class="ui huge form error"style="margin:50px">

                        <div class="two fields">
                            <div class="field " id="fnameContainer">
                                <label>First Name</label>
                                <input placeholder="First Name" type="text" id="fname">
                            </div>
                            <div class="field" id="lnameContainer">
                                <label>Last Name</label>
                                <input placeholder="Last Name" type="text" id="lname">
                            </div>
                        </div>

                        <div class="two fields">
                            <div class="field" id="nicContainer">
                                <label>NIC Number</label>
                                <input placeholder="NIC Number" type="text" id="nic">
                            </div>
                            <div class="field" id="mobileContainer">
                                <label>Phone Number</label>
                                <input placeholder="Phone Number" type="text" id="mobile">
                            </div>
                        </div>

                        <div class="field" id="addressContainer">
                            <label>Address</label>
                            <input placeholder="Address" type="text" id="address">
                        </div>

                        <div class="field" id="emailContainer">
                            <label>Email</label>
                            <input placeholder="Email" type="Email" id="email">
                        </div>

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
            <div class="ui modal vehicle-edit-form" style="padding:50px">

                <i class="close icon"></i>
                <div class="header">
                    Update Vihicle Information
                </div>

                <form method="post" id="vehicleUpdateForm">
                    <div class="ui huge form error"style="margin:50px">
                        <div class="field">
                            <label>Vehicle Registration Number</label>
                            <input type="text" placeholder="Registration Number">
                        </div>

                        <div class="field" id="brandContainer" >
                            <label>Brand Name</label>
                            <select class="ui search dropdown" id="brand">
                                <option value="Toyota">Toyota</option>
                                <option value="Nissan">Nissan</option>
                                <option value="Susuki">Susuki</option>
                                <option value="BMW">BMW</option>
                                <option value="Benze">Benze</option>
                                <option value="Other" id="other">Other</option>
                            </select>
                        </div>

                        <div class="field" id="OtherBrandContainer" style="display: none">
                            <label>Brand Name</label>
                            <input type="text" placeholder="Brand Name" id="otherBrand">
                        </div>

                        <div class="two fields">
                            <div class="field" id="modelContainer">
                                <label>Model</label>
                                <input placeholder="Vehile Model" type="text" id="model">
                            </div>
                            <div class="field" id="colorContainer">
                                <label>Color</label>
                                <input placeholder="Vehicle Color" type="text" id="color">
                            </div>
                        </div>

                        <div class="field" id="manufactYearContainer">
                            <label>Manufactured Year</label>
                            <input type="text" placeholder="Brand Name" id="manufactYear">
                        </div>

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

        </div>

    </div>
</div>

<script src="scripts/entry.js"></script>

</body>
</html>
