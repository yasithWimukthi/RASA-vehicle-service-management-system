<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="styles/editPayment.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



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
        <div class="box">
            <form method="post" class="form" id="form" action="<%=request.getContextPath()%>/paymentEditServlet">


                <%--@declare id="vehicleregino"--%><%--@declare id="customername"--%><%--@declare id="estimateamount"--%>
                <%--@declare id="cash"--%><%--@declare id="paymentdate"--%>

                <div class="header">Edit Payment</div>


                <input type ="hidden" name="payId" value="<%=request.getAttribute("payId")%>">
                <div class="form-control" id="form-container">
                    <label for="vehicleRegiNo">Vehicle Registration number</label>
                    <input type="text" name="registrationNumber" id="vehicleRegiNo" value="<%=request.getAttribute("registrationNumber")%>" >
                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                    <small>Please enter vehicle registation number</small>
                </div>


                <div class="form-control" id="form-container2">
                    <label  for="estimateAmount">Estimation Amount</label>
                    <input type="text" name="estimateAmount"  id="estimateAmount" value="<%=request.getAttribute("estimateAmount")%>" >
                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                    <small>Please enter estimate amount</small>
                </div>

                <div class="form-control" id="form-container3">
                    <label for="cash">Cash</label>
                    <input type="text"   name="cash" id="cash"  value="<%=request.getAttribute("cash")%>" >
                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                    <small>Please enter cash amount</small>
                </div>



                <div class="form-control" id="form-container4">
                    <label for="paymentDate">Date of Payment</label>
                    <input type="date"  name="paymentDate" id="paymentDate" value="<%=request.getAttribute("paymentDate")%>">
                    <i class="fa fa-check-circle" aria-hidden="true"></i>
                    <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                    <small>Please enter payment date</small>
                </div>






                <button>submit</button>
            </form>
        </div>
        <script src="financial_script/editPayment.js"></script>
    </div>
</div>
</body>
</html>