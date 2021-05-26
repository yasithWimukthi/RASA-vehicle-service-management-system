<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/19/2021
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update form</title>
    <link rel="stylesheet" href="styles/style1.css">
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
            <div class="container1">
                <form class="form" action="<%=request.getContextPath()%>/EmployeeUpdate?ID=<%=request.getAttribute("id")%>" method="post">
                    <center><h1><b>Update Form</b></h1></center>
                    <div class="form-field">
                        <label for="fname">First name:</label>
                        <input type="text" name="fname" id="fname" autocomplete="off" value="<%=request.getAttribute("fname")%>">
                        <small></small>
                    </div>
                    <div class="form-field">
                        <label for="lname">Last name:</label>
                        <input type="text" name="lname" id="lname" autocomplete="off"  value="<%=request.getAttribute("lname")%>" >
                        <small></small>
                    </div>
                    <div class="gender">
                        <%--@declare id="gender"--%><label for="gender">Gender:</label>
                        <input class="radio" type="radio" id="male" name="gender" value="<%=request.getParameter("gender")%>" >
                        <label for="male">Male</label>
                        <input class="radio" type="radio" id="female" name="gender" value="<%=request.getAttribute("gender")%>" ><label for="female">Female</label><br>
                    </div>


                    <div class="form-field">
                        <label for="DOB">Date Of Birth:</label>
                        <input type="date" name="DOB" id="DOB" autocomplete="off" value="<%=request.getAttribute("DOB")%>" >
                        <small></small>
                    </div>
                    <div class="form-field">
                        <label for="NIC">NIC:</label>
                        <input type="text" name="NIC" id="NIC" autocomplete="off"  value="<%=request.getAttribute("NIC")%>">
                        <small></small>
                    </div>

                    <div class="form-field">
                        <label for="basicSalary">Basic Salary:</label>
                        <input type="text" name="basicSalary" id="basicSalary" autocomplete="off" value="<%=request.getAttribute("basicSalary")%>">
                        <small></small>
                    </div>

                    <div class="form-field">
                        <label for="Email">Email:</label>
                        <input type="email" name="email" id="email" autocomplete="off" value="<%=request.getAttribute("email")%>" >
                        <small></small>
                    </div>

                    <div class="form-field">
                        <label for="mobile">Mobile:</label>
                        <input type="text" name="mobile" id="mobile" autocomplete="off"  value="<%=request.getAttribute("mobile")%>">
                        <small></small>
                    </div>


                    <div class="form-field">
                        <label for="address">Address:</label>
                        <input type="text" name="address" id="address" autocomplete="off" value="<%=request.getAttribute("address")%>">
                        <small></small>
                    </div>

                    <div class="form-field">

                        <input type="submit" class="btn" value="RESET">
                    </div>
                </form>
            </div>
        </div>

</body>
</html>