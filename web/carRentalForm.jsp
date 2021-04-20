<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/19/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Rental Form</title>
</head>
    <title>Car Rental Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <link rel="stylesheet" href="styles/nav.css">
    <link rel="stylesheet" href="styles/carRentalForm.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
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
                <div class="form-container">
                    <h1>Rent the Car</h1>
                    <form action="<%=request.getContextPath()%>/InsertRentalDetailsServlet" method="post">
                        <div class="row">
                            <div class="col-25">
                                <label>First name</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="firstname" placeholder="First name" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Last name</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="lastname" placeholder="Last name" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>E-mail</label>
                            </div>
                            <div class="col-75">
                                <input type="email" name="email" placeholder="abc@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Mobile Number</label>
                            </div>
                            <div class="col-75">
                                <input type="phone" name="mobile"  pattern="[0-9]{10}" placeholder="1234567890" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Address</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="address" placeholder="Address" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Pick up Date</label>
                            </div>
                            <div class="col-75">
                                <input type="date" name="pickupdate" placeholder="Pick up date" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Drop off Date</label>
                            </div>
                            <div class="col-75">
                                <input type="date" name="dropoffdate" placeholder="Drop off date" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Rental Price</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="rentalprice" placeholder="Rental price" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label>Registration Number</label>
                            </div>
                            <div class="col-75">
                                <input type="text" name="registrationnumber" placeholder="Registration Number" value="<%=request.getAttribute("regNo")%>" required>
                            </div>
                        </div></br>
                        <div class="row">
                            <input type="submit" class="submit-btn" value="Rent">
                            <input type="reset" class="submit-btn" value="Reset">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>