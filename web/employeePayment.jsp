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
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/employeePayment.css" rel="stylesheet">
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
                            <td><a class="btn_adv" href="addAdvance.jsp">advance</a></td>
                            <td><a class="btn_pay">payment</a></td>
                        </tr>
                        <%} %>
                        </tbody>
                    </table>
                </div>
                <div id="recent_adv">

                    <form id="adv_frm">


                        <center><h5> Latest advance record</h5></center><br>
                        <input type="text" name="empID" value="<%=request.getAttribute("empID")%>" placeholder="ID"><br>
                        <input type="text" name="amount"  value="<%=request.getAttribute("amount")%>"  placeholder="advance amount"><br><br>
                        <button class="btn_frm" id="btn_frm_update">update</button>
                        <button class="btn_frm" id="btn_frm_delete">delete</button>

                    </form>

                </div>
                <button>monthly payment</button>
                <button>advance</button>
                <div class="show">

                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>



