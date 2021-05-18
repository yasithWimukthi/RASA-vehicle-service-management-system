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
    <script type="text/javascript">
        function selectYear(){
            let d = new Date();
            let currentYear = d.getFullYear();
            let str = "<option value='0'>Select Year</option>";
            for(let i=0; i<10; i++){
                str+="<option value="+(currentYear+i)+">"+(currentYear+i)+"</option>";
            }
            document.getElementById('year').innerHTML = str;
        }
    </script>
    <title>Rental Details</title>
</head>
<body onload="selectYear()">
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
                                <td><button class="button1">Update</button></td>
                            </form>
                            <form action="<%=request.getContextPath()%>/DeleteRentalDetailsServlet" method="post">
                                <input type="hidden" name="rid" value="<%=rent.getRentID()%>">
                                <td><button class="button2">Delete</button></td>
                            </form>
                        </tr>
                    <%}%>
                    </table>
                </div>
                </br>
                <div>
                    <form action="<%=request.getContextPath()%>/RentDetailsReportServlet" method="post">
                        <span>Select the year and month to generate report</span>
                        <select name="year" id="year">
                        </select>
                        <select name="month" id="month">
                            <option value="">Select Month</option>
                            <option value="1">January</option>
                            <option value="2">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        </br>
                        <div id="btn">
                            <button class="button1">Generate Report</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
