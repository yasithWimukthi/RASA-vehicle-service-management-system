<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/19/2021
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update form</title>
    <link rel="stylesheet" href="styles/employeeupdate.css">
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
            <div class="container">
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6"></div>
                    <div id="ui">
                        <form class="form-group" method="post">
                            <center><h1><b>Update Form</b></h1></center>
                            <div class="row">
                                <div class="col-lg-6">
                                    <label>First Name:</label><br>
                                    <input class="name" type="text" name="fname" class="form-control" placeholder="Enter First Name..">
                                </div>
                                <br>
                                <div class="col-lg-6">
                                    <label>Last Name:</label><br>
                                    <input type="text" class="name" name="lname" class="form-control" placeholder="Enter Last Name..">
                                </div><br>
                                <div class="col-lg-6">
                                    <%--@declare id="gender"--%><label for="gender">Gender:</label>
                                    <input type="radio" id="male" name="male"><label for="male">Male</label>
                                    <input type="radio" id="female" name="female"><label for="female">Female</label><br>
                                </div>

                            </div>

                            <div class="row">
                                <br>
                                <div class="col-lg-6">
                                    <%--@declare id="dob"--%><label for="dob">Choose your DOB:</label>
                                    <input type="date" class="nam" id="date" name="date">
                                </div><br>
                                <div class="col-lg-6">
                                    <label for="nic">NIC:</label><br>
                                    <input type="text" class="name" id="nic" name="nic">
                                </div><br>
                                <div class="col-lg-6">
                                    <label for="sal">Basic Salary:</label><br>
                                    <input type="text" class="name"  id="sal" name="sal">
                                </div><br>
                                <div class="col-lg-6">
                                    <label for="mobile">Mobile Number:</label><br>
                                    <input type="text" class="name"  id="mobile" name="mobile">
                                </div><br>
                                <div class="col-lg-6">
                                    <label for="email">Email:</label><br>
                                    <input type="email" class="name" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+|.[a-z]{2,3}$">
                                </div><br>
                                <div class="col-lg-6">
                                    <label for="address">Address:</label><br>
                                    <textarea id="address" class="name" name="address" rows="4" cols="5"></textarea>
                                </div>
                            </div>

                            <input  class="button" type="submit" class="name" name="submit" value="Reset" class="btn btn-primary btn-block">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>