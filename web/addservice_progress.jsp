
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work Progress</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/addServices.css" rel="stylesheet">
</head>
<body>
<%--for side bar space --%>
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
            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <%-- Header end--%>
                    <div class="ser_header">
                        <h1><i class="cogs icon"></i>Add New Services and Items</h1>
                    </div>
                    <%-- Header end--%>

                    <%-- add service form start --%>
                    <form class="ui form" method="" action="">
                        <div class="field">
                            <label>Select service</label>
                            <select class="fluid dropdown" id="select_service">
                                <option value="">Services</option>
                                <option value="Remove and Refitting">Remove and Refitting</option>
                                <option value="Repair Items">Repair Items</option>
                                <option value="Painting">Painting</option>
                                <option value="Item to be replace">Item to be replace</option>
                            </select>
                        </div>

                        <div class="field">
                            <label>Description (Optional)</label>
                            <input type="text" placeholder="description" id="description3" value="  ">
                        </div>
                        <button class="ui primary button" id="ser_add_btn"><i class="plus square icon"></i>Add Service</button>
                    </form>
                    <%-- estimate servie table --%>
                    <div class="form_container_service">
                        <table class="ui fixed single line celled table" id="service_table">
                            <thead>
                            <th>Service Name</th>
                            <th>Date</th>
                            <th>description</th>
                            <th>Status</th>
                            <th>Action</th>
                            <th>Action</th>
                            <th>Action</th>
                            </thead>
                            <tbody>
                            <td>Painting</td>
                            <td>2020-02-4</td>
                            <td> -- </td>
                            <td>finished</td>
                            <!-- for Update method -->
                            <form action="<%=request.getContextPath()%>/update-service.jsp">
                                <td><button class="ui positive button"><i class="edit icon"></i></button></td>
                            </form>
                            <!-- for delete method -->
                            <form action="">
                                <td><button class="negative ui button"><i class="trash icon"></i></button></td>
                            </form>


                            </tbody>
                            <tbody>
                            <td>Remove and refetting </td>
                            <td>2020-02-4</td>
                            <td> -- </td>
                            <td>finished</td>
                            <!-- for Update method -->
                            <form action="<%=request.getContextPath()%>/update_service.jsp">
                                <td><button class="ui positive button"><i class="edit icon"></i></button></td>
                            </form>
                            <!-- for delete method -->
                            <form action="">
                                <td><button class="negative ui button"><i class="trash icon"></i></button></td>
                            </form>

                            </tbody>
                        </table>
                        <button id ="estimate_btn" class="ui positive button">Show Estimate report</button>
                    </div>
                    <%-- estimate servie table --%>
                </div>
            </div>
            <div class="summery_content">
                <div class="inter-content">
                    <h4>Vehicle NO : AB454344</h4>
                    <h4>Total estimate amount</h4>
                    <h4>Assign Employee</h4>
                    <%-- redirect to assign employee page --%>
                    <%-- if any employee is assign space to implementation--%>
                    <a href="<%=request.getContextPath()%>/assignemp.jsp"><button class="ui positive button">Assign</button></a>
                    <%-- if any employee is assign space to implementation--%>
                </div>
            </div>
        </div>
    </div>
</div>
<%--for side bar space --%>
</body>
</html>
