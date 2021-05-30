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
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav_item side-nav_item--active">
                    <a href="#" class="side-nav__link">
                        <i class="car icon side-nav__icon" style="margin-bottom: 8px; margin-right: 10px;"></i>
                        <div class="side-nav__text">Add Service Entry</div>
                    </a>
                </li>

                <li class="side-nav__item">
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
                    <a href="availableCars.jsp" class="side-nav__link">
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
            <div class="form-container">
                <div>
                    <div>
                        <h1>Cars Available</h1>
                    </div>
                    </br>
                    <div class="search-bar-container">
                        <form action="<%=request.getContextPath()%>/SearchAvailableCarsServlet" method="post">
                            <input type="text" placeholder="Search.." name="search">
                            <button type="submit" id="search-submit-btn"><i class="fa fa-search" style="font-size:24px"></i></button>
                        </form>
                    </div>
                </div>
                <div>
                    <table>
                        <!--<tr>
                            <th>Registration Number</th>
                            <th>Brand</th>
                            <th>Model</th>
                            <th>No of Seats</th>
                            <th>Price Per Day</th>

                            <th></th>
                            <th></th>
                        </tr>-->
                        <%  ArrayList<AvailableCars> list = (ArrayList<AvailableCars>)request.getAttribute("object");

                            if(list.isEmpty()){%>
                                <tr>
                                    <div style="font-size: large">
                                        <i class='far fa-frown' style='font-size:36px'></i>
                                        <span>No Search Results Found</span>
                                    </div>
                                </tr>
                            <%}
                            else{%>
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
                                        <!--<td><button class="button button2">Update</button></td>-->
                                        <form action="<%=request.getContextPath()%>/RetrieveRegNoServlet" method="post">
                                            <input type="hidden" name="registrationnumber" value="<%=availableCars.getRegistrationNumber()%>">
                                            <td><button class="button1">Rent Out</button></td>
                                        </form>
                                    </tr>
                                <%}
                            }%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>