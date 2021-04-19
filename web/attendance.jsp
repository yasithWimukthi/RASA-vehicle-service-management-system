<%@ page import="com.rasa.service.EmployeeLoadingService" %><%--
  Created by IntelliJ IDEA.
  User: Yasith Wimukthi
  Date: 3/9/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Initial Template</title>
    <link href="../../a/employeePayment/web/styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="../../a/employeePayment/web/styles/style.css" rel="stylesheet" >
    <link href="../../a/employeePayment/web/styles/attendance.css" rel="stylesheet" >


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
                <div id="att_div" class="div">
                    <% EmployeeLoadingService retrieve = new EmployeeLoadingService();

                        List<Employee> list=  retrieve.loadToPaymentTable();%>
                    <center>
                        <table>
                            <thead>
                            <tr>
                                <th> ID </th>
                                <th> fname </th>
                                <th> lname </th>
                                <th> attendance </th>
                                <th id="save_clm"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%for(Employee i:list){ %>
                            <tr>
                                <td><%=i.getEmployeeID()%></td>
                                <td><%=i.getFname()%></td>
                                <td><%=i.getLname()%></td>
                                <td>
                                    <input type="radio" name="att" value="present" id="present">
                                    <label>present</label>
                                    <input type="radio" name="att" value="absent" id="absent">
                                    <label>absent</label>
                                    <input type="radio" name="att" value="hald day" id="half day">
                                    <label>half day</label>
                                    <input type="radio" name="att" value="short leave"  id="short leave">
                                    <label>short leave</label>
                                </td>
                                <td>
                                    <center><button type=submit class="btn_tbl">save</button></center>
                                </td>
                            </tr>
                            <%} %>
                            </tbody>
                        </table>
                    </center>
                </div>

            </div>
    </div>
</div>

</body>
</html>

