<%@ page import="com.rasa.service.paymentService" %>
<%@ page import="com.rasa.model.paymentList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="styles/allPayments.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>




</head>
<body >

<% List<paymentList> list = (List<paymentList>)request.getAttribute("pay");%>
<%
    boolean isSuccess = false;
    boolean isEmpty = false;


    try {
        isEmpty = (boolean) request.getAttribute("isEmpty");
    }catch (Exception e){
        isEmpty =false;
    }
%>
<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                        <div class="side-nav__text">Add Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item side-nav__item--active">
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








                <h2 class="main-title">Payments</h2>





                <%--search box --%>

                <div class="ui grid search-bar-container">
                    <div class="sixteen wide column">
                        <div class="search-wrapper">
                            <form method="get" id="form" action="<%=request.getContextPath()%>/searchPaymentsServlet">
                                <div class="ui action input searchBar" style="height: 45px ;width:95%">

                                    <input type="date" placeholder="Search..." name="date" id ="date">

                                    <button type="submit" class="ui button">
                                        <i class="search icon"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <%--Error message --%>
                    <% if(isEmpty) {%>
                <div class="ui negative icon message" style="width: 90%; margin-top: 35px">

                    <div class="content">
                        <div class="header">
                            Payments not found!
                        </div>
                    </div>
                </div>
                    <%} %>

                <%--payments--%>
                    <% if (list !=null && list.size()>0 ){%>
                <section class="details">
                    <div class="card">



                        <table class="ui celled padded table" id="table-id">





                            <thead>


                            <tr>
                                <th>Payment ID</th>
                                <th>Registration Number</th>

                                <th>Estimate Amount</th>
                                <th>Cash</th>
                                <th>Date</th>

                            </tr>
                            </thead>
                            <!-- table data -->
                            <%for(paymentList i:list){ %>
                            <tbody>

                            <tr>
                                <td>
                                    <%=i.getPayId() %>
                                </td>
                                <td>
                                    <%=i.getRegistrationNumber() %>
                                </td>

                                <%if(i.getEstimateAmount() == 0.0){%>

                                <td>None</td>
                                <%}else{%>
                                <td>
                                    <%=i.getEstimateAmount() %>
                                </td>
                                <%}%>
                                <td>
                                    <%=i.getCash() %>
                                </td>
                                <td>
                                    <%=i.getPaymentDate() %>
                                </td>

                            </tr>

                            <%} %>




                            </tbody>



                        </table>


                    </div>
                </section>

                    <%}%>

        </div>
    </div>
</div>
</div>

<script src="financial_script/allPayment.js"></script>
</body>

</html>
