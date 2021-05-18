<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/19/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><h2>employee Record</h2></title>
    <link rel="stylesheet" href="styles/employeeprofile.css">
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
</head>
<body>
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
            <!-- implement fuctions here -->
            <center>
                <div class="form_div" >
                    <form class="add_frm" action="<%=request.getContextPath()%>/ReportServlet?ID=<%=request.getAttribute("employeeID")%>"  method="post">
                        <center><h1>Employee Profile</h1></center><br>
                        <label > ID </label><p class="valuep"><%=request.getAttribute("employeeID")%></p><br>
                        <label> fname </label><p class="valuep"><%=request.getAttribute("fname")%></p><br>
                        <label> lname </label><p class="valuep"><%=request.getAttribute("lname")%></p><br>
                        <label> Gender </label><p class="valuep"><%=request.getAttribute("gender")%></p><br>
                        <label>Date of Birth </label><p class="valuep"><%=request.getAttribute("DOB")%></p><br>
                        <label>NIC </label><p class="valuep"><%=request.getAttribute("NIC")%></p><br>
                        <label>Basic Salary</label><p class="valuep"><%=request.getAttribute("basicSalary")%></p><br>
                        <label>Mobile Number</label><p class="valuep"><%=request.getAttribute("mobile")%></p><br>
                        <label>Email</label><p class="valuep"><%=request.getAttribute("email")%></p><br>
                        <label>Address</label><p class="valuep"><%=request.getAttribute("address")%></p><br>

                        <input  class="button" type="submit" class="name" name="submit" value="Print Report" class="btn btn-primary btn-block">
                    </form>
                </div>
        </div>
    </div>
</div>

</body>
</html>