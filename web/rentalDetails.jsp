<%@ page import="com.rasa.service.RentCarService" %>
<%@ page import="com.rasa.service.IRentCarService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.Rent" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/19/2021
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >

    <link rel="stylesheet" href="styles/nav.css">
    <link rel="stylesheet" href="styles/tableStyles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
    <title>Rental Details</title>
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
            <%
                IRentCarService iRentCarService = new RentCarService();
                ArrayList<Rent> list = iRentCarService.retrieveRentalDetails();

            %>
            <div class="form-container">
                <h1>Rented Cars</h1>
                </br>
                <div>
                    <table>
                        <tr>
                            <th>Rent ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Address</th>
                            <th>Pick up Date</th>
                            <th>Drop off Date</th>
                            <th>Rental Price</th>
                            <th>Registration Number</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <%for(Rent rent : list){%>
                        <tr>
                            <td><%=rent.getRentID()%></td>
                            <td><%=rent.getFirstName()%></td>
                            <td><%=rent.getLastName()%></td>
                            <td><%=rent.getEmail()%></td>
                            <td><%=rent.getMobile()%></td>
                            <td><%=rent.getAddress()%></td>
                            <td><%=rent.getPickUpDate()%></td>
                            <td><%=rent.getDropOffDate()%></td>
                            <td><%=rent.getRentalPrice()%></td>
                            <td><%=rent.getRegistrationNo()%></td>
                            <form action="<%=request.getContextPath()%>/RetriveUpdateRentalDServlet" method="post">
                                <input type="hidden" name="rid" value="<%=rent.getRentID()%>">
                                <td><button class="button button2">Update</button></td>
                            </form>
                            <form action="<%=request.getContextPath()%>/DeleteRentalDetailsServlet" method="post">
                                <input type="hidden" name="rid" value="<%=rent.getRentID()%>">
                                <td><button class="button button2">Delete</button></td>
                            </form>
                        </tr>
                    <%}%>
                    </table>
                </div>
                </br>
                <div>
                    <div>
                        <span>Select the year and month to generate report</span>
                        <select name="year" id="year">
                            <option value="">Select Year</option>
                        </select>
                        <select name="month" id="month">
                            <option value="">Select Month</option>
                        </select>
                    </div>
                    </br>
                    <div id="btn">
                        <button class="button button2">Generate Report</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
