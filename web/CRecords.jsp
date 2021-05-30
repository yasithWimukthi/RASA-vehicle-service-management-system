<%@ page import="com.rasa.service.CarRecordService" %>
<%@ page import="com.rasa.model.CarRecords" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 3/26/2021
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Records</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet" type="text/css">
<link href="styles/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles/CarRecords.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div class="container">
    <div class="content">
        <div class="sidebar">
            <ul class="side-nav">

                <li class="side-nav__item side-nav__item--active">
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


                <%--Car records table--%>

    <div class="main-content">
        
        <div id="clr_div">
            <div id="att_div" class="div">

                <div class ="Records"><h1>All Car Records </h1></div>

                <center>

                    <%CarRecordService carRec = new CarRecordService();
                    List<CarRecords> carlist = carRec.CarRecordRetrieve(); %>

                    <table>
                        <thead>
                        <tr>
                            <th> RegNumber </th>
                            <th> fname </th>
                            <th> lname</th>
                            <th> ID </th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>BookNumber</th>
                            <th>Model</th>
                            <th>SeatAmount</th>
                            <th>Distance</th>
                            <th>CarType</th>
                            <th class="save_clm">Action</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%for(CarRecords i:carlist){ %>

                        <tr>
                            <td>
                                <%=i. getRegNumber() %>
                            </td>
                            <td>
                                <%=i. getFname() %>
                            </td>

                            <td>
                                <%=i.getLname() %>
                            </td>
                            <td>
                                <%=i.getId() %>
                            </td>
                            <td>
                                <%=i.getAddress() %>
                            </td>

                            <td>
                                <%=i.getPhone()  %>
                            </td>
                            <td>
                                <%=i.getEmail() %>
                            </td>
                            <td>
                                <%=i.getBookNumber() %>
                            </td>
                            <td>
                                <%=i.getModel() %>
                            </td>
                            <td>
                                <%=i.getSeatAmount() %>
                            </td>
                            <td>
                                <%=i.getDistance() %>
                            </td>
                            <td>
                                <%=i.getCarType() %>
                            </td>

                            <td><a href="CarRecordUpdateEditServlet?regNumber=<%=i.getRegNumber()%>" > <i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> <a href ="CarRecordDeleteServlet?regNumber=<%=i.getRegNumber()%>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:#ff0000"></i></a></td>

                        </tr>
                        <%} %>

                        </tbody>
                    </table>

                    <form method="post" action="<%=request.getContextPath()%>/ReportGenarateServlet">
                       <br> <button class="bt" type ="submit"> Get Customers list</button>
                    </form>

                        <form action="CarRecordsReg.jsp">
                        <br><button class="bt" type ="submit"> To New Registration</button>
                        </form>

            </div>
            <div class="div" id="btn_div">
            </div>
        </div>

    </div>
</div>
</div>

</body>
</html>
