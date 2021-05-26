<%@ page import="com.rasa.service.employeeService" %>
<%@ page import="com.rasa.model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/25/2021
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/employeedetails.css">
    <title>employee details</title>
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

            <center><h1>EMPLOYEE DETAILS</h1></center>
            <section class="details">
                <div class="card">
                    <%employeeService retrieve = new employeeService();
                        List<Employee> list = retrieve.viewEmployeeDetails();%>
                    <table>
                        <thead>
                        <tr>
                            <th>EMPLOYEE ID</th>
                            <th>EMPLOYEE NAME</th>
                            <th>MANAGE</th>


                        </tr>
                        </thead>

                        <tbody>
                        <%for(Employee i:list){%>
                        <tr>
                            <td name="employeeID"><%=i.getEmployeeID()%></td>
                            <td><%=i.getFname()%></td>
                            <td><a href ="view?"></a> <a href="ViewProfileServlet?ID=<%=i.getEmployeeID()%>"><i class="fa fa-eye" aria-hidden="true" style="color:black"></i> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ></a><a href="LoadServlet?ID=<%=i.getEmployeeID()%>"><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a  href="delete?>" ></a>  <a href="DeleteEmployeeServlet?employeeID=<%=i.getEmployeeID()%>">
                                        <i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i>
                                    </a></td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </section>
            <br>
            <a href="<%=request.getContextPath()%>/employeeregistration.jsp">
                <button class="button" type="submit" class="name" name="submit" class="btn btn-primary btn-block">ADD EMPLOYEE</button></a>



        </div>
    </div>
</div>
</body>
</html>
