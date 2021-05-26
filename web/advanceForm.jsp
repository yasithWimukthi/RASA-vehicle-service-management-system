<%--
  Created by IntelliJ IDEA.
  User: Yasith Wimukthi
  Date: 3/9/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>advance form</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/popup.css" rel="stylesheet">
    <link href="styles/nav.css" rel="stylesheet">
</head>
<body>
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

                <li class="side-nav__item side-nav__item--active">
                    <a href="employeedetails.jsp" class="side-nav__link">
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
            <!-- implement fuctions here -->
            <div id="clr_div">
                <ul class="ul">
                    <li class="li"><a class="a" href="attendance.jsp">Attendance</a></li>
                    <li class="li"><a class="a" href="employeePayment.jsp">Employee Payment</a></li>
                    <li class="li"><a class="a" href="allEmployeeAdvance.jsp">Advance list</a></li>
                    <li class="li"><a class="a" href="allEmployeePayment.jsp">Salary list</a></li>
                    <li class="li"><a class="a" href="empReport.jsp">Report</a></li>
                </ul>
            <div class="form_div" >
                <form  id="adv_form" class="add_frm" method="POST" action="<%=request.getContextPath()%>/AddAdvanceServlet" onsubmit="return validation()">
                    <a href="#" class="close">X</a>
                    <center><h2>ADD NEW ADVANCE</h2></center><br>
                    <label> ID </label><br>
                    <input type="text"  id="employeeID" name="empID" value="<%=request.getAttribute("id")%>"><br>

                    <label> advance </label><br>
                    <input type="number" id="amount" name="amount"><br>
                    <button class="btn_save">save</button>
                </form>
            </div>
        </div>

        </div>
    </div>
</div>
<script src="scripts/empAdvance.js"></script>
</body>
</html>
