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
    <title>Initial Template</title>
    <link href="../../a/employeePayment/web/styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="../../a/employeePayment/web/styles/style.css" rel="stylesheet">
    <link href="../../a/employeePayment/web/styles/attendance.css" rel="stylesheet">
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
            <!-- implement fuctions here -->
            <div id="clr_div">
                <div id="act_div">
                    <% EmployeePaymentService retrieve = new EmployeePaymentService();

                        List<EmployeePayment> list=  retrieve.showAllPayment(); %>
                    <table id="act_tbl">
                        <thead>
                        <th> ID </th>


                        <th> payment</th>
                        </thead>
                        <tbody>
                        <%for(EmployeePayment i:list){ %>

                        <tr>

                            <td>
                                <%=i.getEmpID()  %>
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