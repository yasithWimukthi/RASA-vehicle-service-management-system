<%@ page import="java.util.List" %>
<%@ page import="com.rasa.model.Repair" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/14/2021
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Service</title>
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
    List<Repair> repairsList ;
    repairsList = (List<Repair>) request.getAttribute("services");
    boolean isSuccess = false;
    boolean isEmpty = false;
    String progress;
    String icon;
    String color;
    String serviceType;

    try {
        isEmpty = (boolean) request.getAttribute("isEmpty");
    }catch (Exception e){
        isEmpty =false;
    }

    try {
        isSuccess = (boolean) request.getAttribute("isSuccess");
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

            <!-- TOP SERARCH BAR -->

            <div class="ui grid search-bar-container">
                <div class="sixteen wide column">
                    <div class="search-wrapper">
                        <form method="get" action="SearchServiceServlet">
                            <div class="ui action input searchBar" style="height: 50px">
                                <input type="text" placeholder="Search..." name="key">
                                <select class="ui compact selection dropdown" name="type">
                                    <option value="nicNumber">NIC Number</option>
                                    <option selected="" value="registrationNumber" default>Registration Number</option>
                                </select>
                                <button type="submit" class="ui button">
                                    <i class="search icon"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- MESSAGE -->
            <% if(isEmpty) {%>
                <div class="ui negative icon message" style="width: 90%; margin-top: 35px">
                    <i class="frown outline icon"></i>
                    <div class="content">
                        <div class="header">
                            Service entries can not be found.
                        </div>
                    </div>
                </div>
            <%} %>

            <!-- SERVICE ENTRY TABLE -->
            <% if (repairsList !=null && repairsList.size()>0 ){%>
                <div class="ui grid form-container">
                    <div class="sixteen  wide column">
                        <table class="ui celled table">
                            <thead>
                            <tr>
                                <th>Registration Number</th>
                                <th>Entry Date</th>
                                <th>Type</th>
                            </tr>
                            </thead>
                            <tbody>
                                <% for (Repair repair : repairsList) {
                                        progress = repair.getProgress().toLowerCase();
                                        if (progress.equals("complete")){
                                            icon = "checkmark";
                                            color = "positive";
                                        }else {
                                            icon = "close";
                                            color = "negative";
                                        }

                                        if (repair.getPaymentType().toLowerCase().equals("insuarance")){
                                            serviceType = "Insurance";
                                        }else {
                                            serviceType = "Non Insurance";
                                        }
                                %>

                                    <tr class="<%=color%>">
                                        <td>
                                            <i class="icon <%=icon%> "></i>
                                            <%= repair.getVehicleRegistrationNo()%>
                                        </td>
                                        <td> <%=repair.getEntryDate()%></td>
                                        <td><%=serviceType%></td>
                                        <td class="negative" style="text-align: center">
                                            <form method="post" action="GetServiceDetailsServlet">
                                                <input type="hidden" name="serviceID" value="<%=repair.getRepairId()%>">
                                                <input type="submit" value="view" class="ui primary big button">
                                            </form>
                                        </td>
                                    </tr>

                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            <% }%>

            <% if (isSuccess){%>
                <div class="ui modal" style="padding-top:50px;z-index: 100 " >
                    <i class="close icon"></i>
                    <div style="display:flex;justify-content: center;">
                        <i class="check circle outline icon green" style="font-size:200px; margin-top:50px "></i>
                    </div>
                    <div style="display:flex;justify-content: center;" class="header">
                        <p style="font-size:50px; margin-bottom:50px" class="red">DELETE  SUCCESSFULY !</p>
                    </div>
                </div>
            <%}%>
        </div>
    </div>
</div>

<script>
    $('select.dropdown')
        .dropdown()
    ;

    $('.ui.modal')
        .modal('show');
</script>


</body>
</html>
