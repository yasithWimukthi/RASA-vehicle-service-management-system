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
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="styles/budget.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>

    <title>Budget</title>
</head>
<body>
<div class="container">
    <div class="content">
        <div class="sidebar">

            <li class="side-nav__item">
                <a href="#" class="side-nav__link">

            <li class="side-nav__item ">
                <a href="index.jsp" class="side-nav__link">

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

            <li class="side-nav__item side-nav__item--active">
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
            <div class="maintitle">
                <h1>Budget/month</h1>
            </div>


            <%-- Report Button --%>
            <div class="report-button">
                <form method="post" action="<%=request.getContextPath()%>/BudgetReportServlet">


                    <button class="ui large right labeled icon teal button">
                        <i class="large right arrow icon"></i>
                        Report
                    </button>
                </form>
            </div>


            <%--Succes Message --%>
            <%if(request.getAttribute("IsConfirmed") != null){%>
            <div class="ui success message">
                <i class="close icon"></i>
                <div class="header">
                    Download Completed
                </div>
                <p>Please Check Your folder</p>
            </div>
            <%}%>


            <%-- year, date form --%>
            <div class="box">
                <form method="post" name="myForm" class="ui big form" id="budget" onsubmit="return validation()"
                      action="<%=request.getContextPath()%>/budgetServlet">
                    <div class="field">
                        <div class="two fields">
                            <div class="eight wide field">
                                <input type="text"  name="year" id="year" placeholder="Enter year ..">
                            </div>


                            <div class="eight wide field">
                                <select name="month">
                                    <option value="">Select Month</option>
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
                            </div>
                        </div>
                    </div>

                    <div class="button">
                        <button type="submit" value="submit" class="ui large teal button">Show</button>
                    </div>

                </form>
            </div>



            <%-- Budget details presenter --%>
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

                                        <%if(request.getAttribute("income") == null){%>
                                        <span class="amount">0.0</span>
                                        <%}else{%>
                                        <span class="amount">Rs:<%=request.getAttribute("income")%></span>
                                        <%}%>

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
                                        <th>car Rentals</th>
                                        <tr>

                                            <%if(request.getAttribute("rentalAmount") == null){%>
                                            <td>0.0</td>
                                            <%}else{%>
                                            <td>Rs:<%=request.getAttribute("rentalAmount")%></td>
                                            <%}%>

                                        </tr>

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
                                    <div class="price-value">

                                        <%if(request.getAttribute("profit") == null){%>
                                        <span class="amount">0.0</span>
                                        <%}else{%>
                                        <span class="amount">Rs:<%=request.getAttribute("profit")%></span>
                                        <%}%>

                                    </div>
                                    <table>


                                        <th></th>
                                        <tr>

                                            <td></td>

                                            <td></td>

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
                                        <%if(request.getAttribute("expenses") == null){%>
                                        <span class="amount">0.0</span>
                                        <%}else{%>
                                        <span class="amount">Rs:<%=request.getAttribute("expenses")%></span>
                                        <%}%>

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


                        <div id="piechart" style="width:500px; height:300px;position:absolute;top:70%;left:40%"></div>

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

