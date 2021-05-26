<%@ page import="com.rasa.service.EmployeeLoadingService" %>
<%@ page import="com.rasa.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.rasa.servlet.ShowLatestEmployeeAdvanceServlet" %>
<%@ page import="com.rasa.servlet.ShowAllAdvanceServlet" %><%--
  Created by IntelliJ IDEA.
  User: Yasith Wimukthi
  Date: 3/9/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employee payment</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/employeePayment.css" rel="stylesheet">
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
            <div id="clr_div">
                <ul class="ul">
                    <li class="li"><a class="a" href="attendance.jsp">Attendance</a></li>
                    <li class="li"><a class="a" href="employeePayment.jsp">Employee Payment</a></li>
                    <li class="li"><a class="a" href="allEmployeeAdvance.jsp">Advance list</a></li>
                    <li class="li"><a class="a" href="allEmployeePayment.jsp">Salary list</a></li>
                    <li class="li"><a class="a" href="empReport.jsp">Report</a></li>
                </ul>
                <div id="act_div">
                    <% EmployeeLoadingService retrieve = new EmployeeLoadingService();

                        List<Employee> list=  retrieve.loadToPaymentTable();%>
                    <table id="act_tbl">
                        <thead>
                        <th> ID </th>
                        <th> fname </th>
                        <th> lname </th>
                        <th> Advance </th>
                        <th> payment</th>
                        </thead>
                        <tbody>
                        <%for(Employee i:list){ %>
                        <tr>
                            <td><%=i.getEmployeeID()%></td>
                            <td><%=i.getFname()%></td>
                            <td><%=i.getLname()%> </td>
                            <td><a class="btn_adv" href="<%=request.getContextPath()%>/LoadToAdvanceServlet?id=<%=i.getEmployeeID()%>">advance</a></td>
                            <td><a class="btn_pay"href="<%=request.getContextPath()%>/LoadToPaymentFormServlet?id=<%=i.getEmployeeID()%>">payment</a></td>
                        </tr>
                        <%} %>
                        </tbody>
                    </table>
                </div>
                <div id="recent_adv">

                    <form id="adv_frm" method="post">


                        <center><h5> Latest advance record</h5></center><br>
                        <input type="number" name="empID" value="<%=request.getAttribute("empID")%>" placeholder="ID"><br>
                        <input type="number" name="amount"  value="<%=request.getAttribute("amount")%>"  placeholder="advance amount"><br><br>
                        <a class="btn_frm" id="btn_frm_get" href="<%=request.getContextPath()%>/ShowLatestEmployeeAdvanceServlet">get</a>
                        <a class="btn_frm" id="btn_frm_update" href="<%=request.getContextPath()%>/UpdateAdvanceServlet">update</a>
                        <a class="btn_frm" id="btn_frm_delete" href="<%=request.getContextPath()%>/DeleteAdvanceServlet">delete</a>

                    </form>

            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>



