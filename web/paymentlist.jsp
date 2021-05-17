<%@ page import="com.rasa.service.paymentService" %>
<%@ page import="com.rasa.model.paymentList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Tharukshi
  Date: 3/22/2021
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
    <title>PaymentManagement</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >
    <link rel="stylesheet" href="styles/paymentlist.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>




</head>
<body >



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
                    <a href="budget.jsp" class="side-nav__link">
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



            <section class="ui container">








                <h2 class="main-title">Latest Payment</h2>
                <div class="bill_button">
                    <form method="post" action="<%=request.getContextPath()%>/AllPaymentsServlet">


                    <button class="big ui right labeled icon green button">
                        <i class="arrow alternate circle right icon"></i>
                        All Payments
                    </button>
                    </form>
                </div>

                <div class="card">
                <div class="ui grid form-container">
                    <div class="sixteen  wide column">
                        <table class="ui celled table">
                            <thead>
                            <tr>

                                <th>Payment ID</th>
                                <th>Registration Number</th>
                                <th>Estimate Amount</th>
                                <th>Cash Amount</th>
                                <th>Payment Date</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- table data -->

                            <tr>

                                <td>
                                    <%=request.getAttribute("payId") %>
                                </td>
                                <td>
                                    <%=request.getAttribute("registationNumber") %>
                                </td>

                                <td>
                                    <%=request.getAttribute("estimateAmount") %>
                                </td>

                                <td>
                                    <%=request.getAttribute("cash") %>
                                </td>
                                <td>
                                    <%=request.getAttribute("paymentDate") %>
                                </td>
                                <td><a href="retriveEditServlet?payId=<%=request.getAttribute("payId")%>" > <i class="yellow pen square icon"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a  href="paymentDeleteServlet?payId=<%=request.getAttribute("payId")%>" > <i class="red trash icon"></i></a> &nbsp;&nbsp;&nbsp<a href="BillServlet?payId=<%=request.getAttribute("payId")%>" ><i class="blue file icon"></i></a></td>
                            </tr>





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
