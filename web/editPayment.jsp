<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="styles/editPayment.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>




</head>
<body>


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
            <div class="header">Edit Payment</div>
            <form method="post" class="ui huge form" id="form" action="<%=request.getContextPath()%>/paymentEditServlet">


                <%--@declare id="vehicleregino"--%><%--@declare id="customername"--%><%--@declare id="estimateamount"--%>
                <%--@declare id="cash"--%><%--@declare id="paymentdate"--%>


                <div class="field">
                    <input type ="hidden" name="payId" value="<%=request.getAttribute("payId")%>">

                    <div class="field" id="form-container">
                        <label for="vehicleRegiNo">Vehicle Registration number</label>
                        <input type="text" name="registrationNumber" id="vehicleRegiNo" value="<%=request.getAttribute("registrationNumber")%>" >


                    </div>


                    <div class="field" id="form-container2">
                        <label  for="estimateAmount">Estimation Amount</label>
                        <input type="text" name="estimateAmount"  id="estimateAmount" value="<%=request.getAttribute("estimateAmount")%>" >

                        <small class="estimate-error" style="color: red;visibility: hidden;">Cannot Enter Text Inputs</small>
                    </div>

                    <div class="field" id="form-container3">
                        <label for="cash">Cash</label>
                        <input type="text"   name="cash" id="cash"  value="<%=request.getAttribute("cash")%>" >

                        <small class="cash-error" style="color: red;visibility: hidden;">Cannot Enter Text Inputs</small>
                    </div>



                    <div class="field" id="form-container4">
                        <label for="paymentDate">Date of Payment</label>
                        <input type="date"  name="paymentDate" id="paymentDate" value="<%=request.getAttribute("paymentDate")%>">


                    </div>






                    <button>Update</button>
                </div>
            </form>
        </div>
    </div>


</div>
<script src="financial_script/editPayment.js"></script>
</body>
</html>