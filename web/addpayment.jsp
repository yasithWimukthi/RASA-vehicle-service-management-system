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
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="styles/addpayment.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>
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
                <h2>Estimated amounts</h2>
                <%--get verhicle service id using session--%>
                <%


                    addPaymentService paymentService = new addPaymentService();
                    int sid = (int) request.getAttribute("sid");%>

                <%--estimated amount table --%>
                <table  class="ui celled table">
                    <thead>
                    <tr>
                        <th><span>ID</span></th>
                        <th ><span>Services</span></th>
                        <th ><span>Amount</span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>1</td>
                        <td>Painting</td>
                        <td>Rs : <%=paymentService.CalcTotalEstimates("painting",sid)%></td>

                    </tr>
                    <tr>

                        <td>2</td>
                        <td>Remove and Refting</td>
                        <td>Rs : <%=paymentService.CalcTotalEstimates("Remove and refting",sid)%></td>

                    </tr>
                    <tr>

                        <td>3</td>
                        <td>Replace items</td>
                        <td>Rs : <%=paymentService.CalcTotalEstimates("Remove items",sid)%></td>

                    </tr>


                    <tr>

                        <td>4</td>
                        <td>items to be replace</td>
                        <td>Rs : <%=paymentService.CalcTotalEstimates("replace items",sid)%></td>

                    </tr>




                    </tbody>

                    <tfoot>
                    <tr>
                        <td></td>
                        <td>Total Amount</td>
                        <td>Rs : <%=paymentService.totEstimates(sid)%></td>
                    </tr>

                    </tfoot>
                </table>
            </div>


            <%-- payments insert form --%>
            <form method="post"  class="ui huge form" id="form" action="<%=request.getContextPath()%>/paymentListServlet" >


                <%--@declare id="vehicleregino"--%><%--@declare id="customername"--%><%--@declare id="estimateamount"--%>
                <%--@declare id="cash"--%><%--@declare id="paymentdate"--%>

                <h2 class="ui left aligned dividing grey header">Enter Payment Details</h2>

                <input type ="hidden" name="payId">
                <div class="field">

                    <div class="two fields">
                        <div class="field" id="form-container">

                            <label for="vehicleRegiNo">Vehicle Registation number</label>
                            <input type="text" name="registrationNumber" id="vehicleRegiNo" placeholder="Enter registration Number" >


                        </div>


                        <div class="field" id="form-container2">
                            <label  for="estimateAmount">Estimation Amount</label>
                            <input type="text" name="estimateAmount"  id="estimateAmount" value="0" placeholder="Enter Estimate amount " >

                            <small class="estimate-error" style="color: red;visibility: hidden;">Cannot Enter Text Inputs</small>
                        </div>
                    </div>
                </div>

                <div class="field">
                    <div class="two fields">
                        <div class="field" id="form-container3">
                            <label for="cash">Cash</label>
                            <input type="text"   name="cash" id="cash" placeholder="Enter cash amount" >

                            <small class="cash-error" style="color: red;visibility: hidden;">Cannot Enter Text Inputs</small>
                        </div>



                        <div class="field" id="form-container4">
                            <label for="paymentDate">Date of Payment</label>
                            <input type="date"  name="paymentDate" id="paymentDate" placeholder="Enter payment date" >


                        </div>
                    </div>
                </div>

                <input type="hidden"  name="sid" value="<%=sid%>">




                <div class="ssbtn">
                    <button type="submit">submit</button>
                </div>
            </form>



        </div>

    </div>
</div>
<script src="financial_script/addpayment.js"></script>
</body>
</html>

