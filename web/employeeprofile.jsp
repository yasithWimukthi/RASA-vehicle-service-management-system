<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/10/2021
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><h2>employee Record</h2></title>
    <link rel="stylesheet" href="styles/employeeprofile.css">
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
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
            <center>
                <div class="form_div" >
                    <form class="add_frm">
                        <center><h1>Employee Profile</h1></center><br>
                        <label > ID </label><p class="valuep"> 001</p><br>
                        <label> fname </label><p class="valuep"> kavindu</p><br>
                        <label> lname </label><p class="valuep"> balasooriya</p><br>
                        <label> Gender </label><p class="valuep"> Male</p><br>
                        <label>Date of Birth </label><p class="valuep">1983.02.25</p><br>
                        <label>NIC </label><p class="valuep">83459723v</p><br>
                        <label>Basic Salary</label><p class="valuep">25000.00</p><br>
                        <label>Mobile Number</label><p class="valuep">0762245763</p><br>
                        <label>Email</label><p class="valuep">kavindu185@gmail.com</p><br>
                        <label>Address</label><p class="valuep">"kavindu",kanatha road,Athurugiriya.</p><br>

                    </form>
                    <input  class="button" type="submit" class="name" name="submit" value="Print Report" class="btn btn-primary btn-block">
                </div>
        </div>
    </div>
</div>

</body>
</html>
