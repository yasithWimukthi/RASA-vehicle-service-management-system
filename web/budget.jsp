<%@ page import="com.rasa.service.budgetService" %>

<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tharukshi
  Date: 3/22/2021
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >
    <link rel="stylesheet" href="styles/budget.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
    <title>Budget</title>
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
            <div class="maintitle">
                <h1>Budget/month</h1>
            </div>

            <div class="report-button">
                <button class="big ui right labeled icon orange button">
                    <i class="right arrow icon"></i>
                    Report
                </button>
            </div>


            <div class="box">
                <form method="post" name="myForm" id="budget" onsubmit="return validation()"
                      class="form" action="<%=request.getContextPath()%>/budgetServlet">
                    <div class="form-control">
                        <input type="text"  name="year" id="year">

                        <select name="month" >
                            <option value="1">January</option>
                            <option value="2">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <button type="submit" value="submit" class="ui primary button">Show</button>
                    </div>
                </form>
            </div>



            <div class="demo">
                <div class="budget_container">

                    <div class="row">
                        <div class="col-md-4 col-sm-6">
                            <div class="pricingTable">
                                <div class="pricingTable-header">

                                    <h3 class="title">Income</h3>
                                </div>
                                <div class="pricing-content">
                                    <div class="price-value">

                                        <span class="amount">Rs:<%=request.getAttribute("income")%></span>

                                    </div>

                                    <table>

                                        <th>Vehicle Repairs</th>
                                        <tr>
                                            <%if(request.getAttribute("Ramount") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("Ramount")%></td>
                                            <%}%>
                                        </tr>
                                        <th>Rental income</th>
                                        <tr>
                                            <%if(request.getAttribute("rentalAmount") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("rentalAmount")%></td>
                                            <%}%>
                                        </tr>
                                        </ul>
                                    </table>

                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 col-sm-7">
                            <div class="pricingTable_Pro">
                                <div class="pricingTable-header-pro">

                                    <h3 class="title">Profit</h3>
                                </div>
                                <div class="pricing-content_pro">

                                    <table>
                                        <tr>
                                            <%if(request.getAttribute("profit") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("profit")%></td>
                                            <%}%>
                                        </tr>


                                    </table>

                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 col-sm-8">
                            <div class="pricingTable_Ex">
                                <div class="pricingTable-header_Ex">

                                    <h3 class="title">Expenses</h3>
                                </div>
                                <div class="pricing-content_Ex">
                                    <div class="price-value">
                                        <span class="amount">Rs:<%=request.getAttribute("expenses")%></span>

                                    </div>
                                    <table>
                                        <th>Employee payments</th>
                                        <tr>
                                            <%if(request.getAttribute("empPayments") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("empPayments")%></td>
                                            <%}%>
                                        </tr>
                                        <th>Inventory expenses</th>
                                        <tr>
                                            <%if(request.getAttribute("inventoryExpenses") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("inventoryExpenses")%></td>
                                            <%}%>
                                        </tr>


                                    </table>


                                </div>
                            </div>
                        </div>



                    </div>
                </div>

            </div>

        </div>
    </div>
<script src="financial_script/budget.js"></script>
</div>
</div>

</body>
</html>

