<%--
  Created by IntelliJ IDEA.
  User: yasith wimukthi
  Date: 3/23/2021
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
</head>
<body>

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
                        <form method="get">
                            <div class="ui action input massive searchBar">
                                <input type="text" placeholder="Enter NIC Number..." id="input-box">
                                <button type="submit" class="ui icon button">
                                    <i class="search icon"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!--STEP BAR-->

            <div class="ui steps" style="width: 90%; margin-top:50px; margin-bottom:0">
                <div class=" active step">
                    <i class="user icon"></i>
                    <div class="content">
                        <div class="title">Customer Registration</div>
                        <div class="description">Enter client details</div>
                    </div>
                </div>
                <div class=" disabled step">
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

            <!-- CUSTOMER DETAILS FORM -->
            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <form method="post">
                        <div class="ui huge form error">

                            <div class="two fields">
                                <div class="field error">
                                    <label>First Name</label>
                                    <input placeholder="First Name" type="text">
                                </div>
                                <div class="field error">
                                    <label>Last Name</label>
                                    <input placeholder="Last Name" type="text">
                                </div>
                            </div>

                            <div class="two fields">
                                <div class="field error">
                                    <label>NIC Number</label>
                                    <input placeholder="NIC Number" type="text">
                                </div>
                                <div class="field error">
                                    <label>Phone Number</label>
                                    <input placeholder="Phone Number" type="text">
                                </div>
                            </div>

                            <div class="field error">
                                <label>Address</label>
                                <input placeholder="Address" type="text">
                            </div>

                            <div class="field error">
                                <label>Email</label>
                                <input placeholder="Email" type="Email">
                            </div>

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

</body>
</html>
