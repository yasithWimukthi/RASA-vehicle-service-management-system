<%@ page import="com.rasa.model.Customer" %><%--
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
    Customer customer ;

    try {
        customer = (Customer) request.getAttribute("customer");
    }catch (Exception e){
        customer = null;
        e.printStackTrace();
    }

    String firstName = "";
    String lastName = "";
    String nicNumber = "";
    String address = "";
    String mobile = "";
    String email = "";
    boolean update = false;

    try {
        if(customer != null){
            firstName = customer.getFirstName();
            lastName = customer.getLastName();
            nicNumber = customer.getNICno().toUpperCase();
            address = customer.getAddress();
            mobile = customer.getPhoneNo();
            email = customer.getEmail();
            update = true;
        }
    }catch (Exception e){
        e.printStackTrace();
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
                        <form method="POST" id="search-form" action="SearchClientServlet">
                            <div class="ui action input massive searchBar">
                                <input type="text" placeholder="Enter NIC Number..." id="input-box" class="searchWord" name="nic_number">
                                <button type="submit" class="ui icon button" style="height: 69%" id="search-submit">
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
                    <form method="post" id="customerRegForm">
                        <div class="ui huge form" id="form-container">

                            <div class="two fields">
                                <div class="field" id="fnameContainer">
                                    <label>First Name</label>
                                    <input placeholder="First Name" type="text" name="fname" id="fname" value="<%= firstName%>">
                                </div>
                                <div class="field" id="lnameContainer">
                                    <label>Last Name</label>
                                    <input placeholder="Last Name" type="text" name="lname" id="lname" value="<%=lastName%>">
                                </div>
                            </div>

                            <div class="two fields">
                                <div class="field" id="nicContainer">
                                    <label>NIC Number</label>
                                    <input placeholder="NIC Number" type="text" name="nic" id="nic" value="<%=nicNumber%>" disabled="<%=update%>">
                                </div>
                                <div class="field" id="mobileContainer">
                                    <label>Phone Number</label>
                                    <input placeholder="Phone Number" type="text" name="mobile" id="mobile" value="<%=mobile%>">
                                </div>
                            </div>

                            <div class="field" id="addressContainer">
                                <label>Address</label>
                                <input placeholder="Address" type="text" name="address" id="address" value="<%=address%>">
                            </div>

                            <div class="field " id="emailContainer">
                                <label>Email</label>
                                <input placeholder="Email" type="Email" name="email" id="email" value="<%=email%>">
                            </div>

                            <input type="hidden" name="update" value="<%=update%>">
                            <input type="hidden" name="nicNumber" value="<%=nicNumber%>">

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
<script src="scripts/customerManagement.js"></script>
</body>
</html>