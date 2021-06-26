<%@ page import="com.rasa.service.EmployeePaymentService" %>
<%@ page import="com.rasa.model.EmployeePayment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kavindu Balasooriya
  Date: 4/10/2021
  Time: 6:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>payment list</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/alladvance.css" rel="stylesheet">
    <link href="styles/nav.css" rel="stylesheet">
</head>
<body>


<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item ">
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
                <div id="act_div">
                    <% EmployeePaymentService retrieve = new EmployeePaymentService();

                        List<EmployeePayment> list=  retrieve.showAllPayment(); %>
                    <table id="act_tbl">
                        <thead>
                        <th> ID </th>
                        <th> Date</th>
                        <th> Bonus</th>
                        <th> Deduct</th>
                        <th> payment</th>
                        </thead>
                        <tbody>
                        <%for(EmployeePayment i:list){ %>

                        <tr>

                            <td>
                                <%=i.getEmpID()  %>
                            </td>

                            <td>
                                <%=i.getDate() %>
                            </td>

                            <td>
                                <%=i.getBonus()  %>
                            </td>

                            <td>
                                <%=i.getDeduct() %>
                            </td>

                            <td>
                                <%=i.getAmount() %>
                            </td>

                        </tr>

                        <%} %>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>