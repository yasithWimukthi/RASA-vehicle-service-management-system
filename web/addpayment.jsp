<%@ page import="com.rasa.service.addPaymentService" %><%--
  Created by IntelliJ IDEA.
  User: Tharukshi
  Date: 3/22/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
    <title>Add payment</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >
    <link rel="stylesheet" href="styles/addpayment.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
</head>
<body>

<!-- nav bar -->
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


            <div id="wrapper">
            <h1>Estimate Amount</h1>
                <%--get verhicle service id using session--%>
               <%


                    addPaymentService paymentService = new addPaymentService();
                    int sid = (int) request.getAttribute("sid");%>
                <table id="keywords" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th><span>Id</span></th>
                        <th ><span>Services</span></th>
                        <th ><span>Amount</span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>1</td>
                        <td>Painting</td>
                        <td><%=paymentService.CalcTotalEstimates("painting",sid)%></td>

                    </tr>
                    <tr>

                        <td>2</td>
                        <td>Remove and Refting</td>
                        <td><%=paymentService.CalcTotalEstimates("Remove and refting",sid)%></td>

                    </tr>
                    <tr>

                        <td>3</td>
                        <td>Replace items</td>
                        <td><%=paymentService.CalcTotalEstimates("Remove items",sid)%></td>

                    </tr>


                    <tr>

                        <td>4</td>
                        <td>items to be replace</td>
                        <td><%=paymentService.CalcTotalEstimates("replace items",sid)%></td>

                    </tr>




                    </tbody>

                    <tfoot class="amount" align="center">
                    <tr>
                        <td></td>
                        <td>Total Amount</td>
                        <td><%=paymentService.totEstimates(sid)%></td>
                    </tr>

                    </tfoot>
                </table>
            </div>


            <div class="box">
                <form method="post" class="form" id="form" action="<%=request.getContextPath()%>/paymentListServlet" >


                    <%--@declare id="vehicleregino"--%><%--@declare id="customername"--%><%--@declare id="estimateamount"--%>
                    <%--@declare id="cash"--%><%--@declare id="paymentdate"--%>

                    <div class="header">Add payment</div>

                    <br>
                    <input type ="hidden" name="payId">
                    <div class="form-control" id="form-container">
                        <label for="vehicleRegiNo">Vehicle Registation number</label>
                        <input type="text" name="registrationNumber" id="vehicleRegiNo" >
                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                        <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                        <small>Please enter vehicle Registration number</small>
                    </div>


                    <div class="form-control" id="form-container2">
                        <label  for="estimateAmount">Estimation Amount</label>
                        <input type="text" name="estimateAmount"  id="estimateAmount"  >
                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                        <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                        <small>Please Enter valid estimation amount </small>
                    </div>

                    <div class="form-control" id="form-container3">
                        <label for="cash">Cash</label>
                        <input type="text"   name="cash" id="cash"  >
                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                        <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                        <small>Please enter cash amount and invalid input cannot be entered</small>
                    </div>



                    <div class="form-control" id="form-container4">
                        <label for="paymentDate">Date of Payment</label>
                        <input type="date"  name="paymentDate" id="paymentDate" >
                        <i class="fa fa-check-circle" aria-hidden="true"></i>
                        <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
                        <small>Please enter payment date</small>
                    </div>



                    <input type="hidden"  name="sid" value="<%=sid%>">






                    <button type="submit">submit</button>
                </form>

            </div>

        </div>

    </div>
</div>
<script src="financial_script/addpayment.js"></script>
</body>
</html>

