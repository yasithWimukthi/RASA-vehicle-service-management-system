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



            <section class="ui container">








                <h2 class="main-title">Payments</h2>
                <div class="bill_button">
                    <button class="big ui right labeled icon green button">
                        <i class="arrow alternate circle right icon"></i>
                        Bill
                    </button>
                </div>
                    <% paymentService pays = new paymentService();

                    List<paymentList> payList=  pays.selectAllPayment(); %>
                <section class="details">
                    <div class="card">
                        <table class="ui selectable compact blue table">
                            <thead>
                            <tr>
                                <th>Payment ID</th>
                                <th>Registration Number</th>

                                <th>Estimate Amount</th>
                                <th>Cash</th>
                                <th>Date</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- table data -->
                            <%for(paymentList i:payList){ %>
                            <tr>
                                <td>
                                    <%=i.getPayId() %>
                                </td>
                                <td>
                                    <%=i.getRegistrationNumber() %>
                                </td>

                                <td>
                                    <%=i.getEstimateAmount() %>
                                </td>

                                <td>
                                    <%=i.getCash() %>
                                </td>
                                <td>
                                    <%=i.getPaymentDate() %>
                                </td>
                                <td><a href="retriveEditServlet?payId=<%=i.getPayId()%>" > <i class="yellow pen square icon"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a  href="paymentDeleteServlet?payId=<%=i.getPayId()%>" > <i class="red trash icon"></i></a></td>
                            </tr>
                            <%} %>




                            </tbody>

                        </table>

                    </div>
                </section>



        </div>
    </div>
</div>
</div>


</body>

</html>
