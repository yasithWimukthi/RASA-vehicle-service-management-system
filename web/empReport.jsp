<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/10/2021
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reports</title>
    <link rel="stylesheet" href="styles/employeeupdate.css">
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/empReport.css" rel="stylesheet">
    <link href="styles/nav.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item side-nav__item">
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
            <ul class="ul">
                <li class="li"><a class="a" href="attendance.jsp">Attendance</a></li>
                <li class="li"><a class="a" href="employeePayment.jsp">Employee Payment</a></li>
                <li class="li"><a class="a" href="allEmployeeAdvance.jsp">Advance list</a></li>
                <li class="li"><a class="a" href="allEmployeePayment.jsp">Salary list</a></li>
                <li class="li"><a class="a" href="empReport.jsp">Report</a></li>
            </ul>

            <div class="form">
            <form method="post" id="frm"  onsubmit="return validation()" action="<%=request.getContextPath()%>/ReportGenerateServlet" class="">
                <input type="number" name="year" id="year">
                <select name="month" class="drop">
                    <option value="1" >january</option>
                    <option value="2" >february</option>
                    <option value="3" >march</option>
                    <option value="4" >april</option>
                    <option value="5" >may</option>
                    <option value="6" >june</option>
                    <option value="7" >july</option>
                    <option value="8" >august</option>
                    <option value="9" >september</option>
                    <option value="10" >octomber</option>
                    <option value="11" >november</option>
                    <option value="12" >december</option>
                </select>
            <select name="type" class="drop">
                <option value="salary" >month salary</option>
                <option value="advance" >advance</option>
            </select>
            <button type="submit">generate</button>
            </form></div>

        </div>
        </div>
    </div>
</div>
<script src="scripts/report.js"></script>
</body>
</html>