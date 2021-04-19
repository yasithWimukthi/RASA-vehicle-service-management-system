<%--
  Created by IntelliJ IDEA.
  User: Yasith Wimukthi
  Date: 3/9/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Initial Template</title>
    <link href="../../a/employeePayment/web/styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="../../a/employeePayment/web/styles/style.css" rel="stylesheet">
    <link href="../../a/employeePayment/web/styles/popup.css" rel="stylesheet">
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
            <div class="form_div" >
                <form class="add_frm" method="post" action="<%=request.getContextPath()%>/AddPaymentServlet">
                    <a href="#" class="close">X</a>
                    <center><h2>ADD NEW PAYMENT</h2></center><br>
                    <label > ID </label><p class="valuep"> 0001</p><br>
                    <label> fname </label><p class="valuep"> kavindu</p><br>
                    <label> lname </label><p class="valuep"> balasooriya</p><br>
                    <label> paid advance </label><p class="valuep"> 1000</p><br>
                    <label> to pay </label><p class="valuep"> 20000</p><br>
                    <label class="btm_lbl">add bouns</label><br>
                    <input class="btm_inp"type="number" name="bonus"><br>
                    <label class="btm_lbl"> deduct </label><br>
                    <input class="btm_inp"type="number" name="deduct">
                    <button class="btm_btn">save</button><br>
                    <label> net salary </label>
                    <p>25000</p><br>
                    <button class="btn_save">save</button>
                </form>
            </div>
        </div>
    </div>
    </div>
</div>

</body>
</html>
