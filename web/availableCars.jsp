<%@ page import="com.rasa.service.IRentCarService" %>
<%@ page import="com.rasa.service.RentCarService" %>
<%@ page import="com.rasa.model.AvailableCars" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/19/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Cars</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <link rel="stylesheet" href="styles/nav.css">
    <link rel="stylesheet" href="styles/tableStyles.css">
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
            <%
                IRentCarService iRentCarService = new RentCarService();
                ArrayList<AvailableCars> list = iRentCarService.retrieveAvailableCars();
            %>
            <div class="form-container">
                <div>
                    <div>
                        <h1>Cars Available</h1>
                    </div>
                    </br>
                    <div class="search-bar-container">
                        <form action="availableCars">
                            <input type="text" placeholder="Search.." name="search">
                            <button type="submit" id="search-submit-btn"><i class="fa fa-search" style="font-size:24px"></i></button>
                        </form>
                    </div>
                </div>
                <div>
                    <table>
                        <tr>
                            <th>Registration Number</th>
                            <th>Brand</th>
                            <th>Model</th>
                            <th>No of Seats</th>
                            <th>Price Per Day</th>
                            <!--<th>Status</th>-->
                            <th></th>
                            <th></th>
                        </tr>
                        <%for(AvailableCars availableCars : list){%>
                        <tr>
                            <td><%=availableCars.getRegistrationNumber()%></td>
                            <td><%=availableCars.getBrand()%></td>
                            <td><%=availableCars.getModel()%></td>
                            <td><%=availableCars.getNumberOfSeats()%></td>
                            <td><%=availableCars.getPricePerDay()%></td>
                            <!--<td></td>-->
                            <td><button class="button button2">Update</button></td>
                            <form action="<%=request.getContextPath()%>/RetrieveRegNoServlet" method="post">
                                <input type="hidden" name="registrationnumber" value="<%=availableCars.getRegistrationNumber()%>">
                                <td><button class="button button2">Rent Out</button></td>
                            </form>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
