<%@ page import="com.rasa.service.EmployeeAdvanceService" %>
<%@ page import="com.rasa.model.EmployeeAdvance" %>
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
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/alladvance.css" rel="stylesheet">
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
                    <% EmployeeAdvanceService retrieve = new EmployeeAdvanceService();

                        List<EmployeeAdvance> list=  retrieve.showAllAdvance(); %>
                    <table id="act_tbl">
                        <thead>
                        <th> ID </th>

                        <th> date</th>
                        <th> payment</th>
                        </thead>
                        <tbody>
                        <%for(EmployeeAdvance i:list){ %>


                        <tr>

                            <td>
                                <%=i.getEmpID()  %>
                            </td>

                            <td>
                                <%=i.getDate()  %>
                            </td>

                            <td>
                                <%=i.getAmount() %>
                            </td>

                        </tr>

                        <%} %>
                        </tbody>
                    </table>
                </div>

                        <button class="report_btn">Click here to report</button>


            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
