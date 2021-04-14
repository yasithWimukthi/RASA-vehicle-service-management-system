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
    List<Repair> repairsList = new ArrayList<>();
    repairsList = (List<Repair>) request.getAttribute("services");

%>

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

            <!-- TOP SERARCH BAR -->

            <div class="ui grid search-bar-container">
                <div class="sixteen wide column">
                    <div class="search-wrapper">
                        <form method="get " action="SearchServiceServlet">
                            <div class="ui action input searchBar" style="height: 50px">
                                <input type="text" placeholder="Search..." name="key">
                                <select class="ui compact selection dropdown" name="type">
                                    <option value="nicNumber">NIC Number</option>
                                    <option selected="" value="registrationNumber" default>Registration Number</option>
                                </select>
                                <button type="submit"class="ui button">
                                    <i class="search icon"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- SERVICE ENTRY TABLE -->
            <% if (repairsList != null){%>
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
                            <tr class="negative">
                                <td> <i class="icon close"></i>No Name Specified</td>
                                <td>Unknown</td>
                                <td class="negative">None</td>
                                <td class="negative">None</td>
                            </tr>
                            <tr class="positive">
                                <td><i class="icon checkmark"></i>Jimmy</td>
                                <td>> Approved</td>
                                <td>None</td>
                                <td class="negative">None</td>
                            </tr>

                            <% for (Repair repair : repairsList) {%>

                                <tr class="positive">
                                    <td><i class="icon checkmark"></i> <%= repair.getVehicleRegistrationNo()%> </td>
                                    <td>> <%=repair.getEntryDate()%></td>
                                    <td><%=repair.getPaymentType()%></td>
                                    <td class="negative">
                                        <form>
                                            <input type="hidden" name="serviceID" value="<%=repair.getRepairId()%>">
                                            <input type="submit" value="view" class="btn btn-primary">
                                        </form>
                                    </td>
                                </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            <% }%>
        </div>
    </div>
</div>

<script>
    $('select.dropdown')
        .dropdown()
    ;
</script>


</body>
</html>
