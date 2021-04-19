<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.rasa.model.RepairService" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work Progress</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/workprogress.css" rel="stylesheet">
    <script src="scripts/workprogress.js"></script>

</head>
<body>
<%-- get vehcile entry Id using session --%>
<%int sid = (int)session.getAttribute("sid");%>;
<%-- gather pid--%>
<%Iworkprogress_service iworkprogress_service = new Workprogress_service();%>
<%String pid = iworkprogress_service.getProgressId(sid);%>

<%--for date --%>
<%LocalDate date = LocalDate.now();%>


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
            <!-- error space -->
            <div class="error_container">
                <div id="errID" class="ui negative message" style="display:none">
                    <p id="error"></p>
                </div>
            </div>

            <%if(request.getAttribute("error") !=null){%>
            <div class="error_container">
                <div class="ui negative message">
                     <i class="close icon"></i>
                    <div class="header">
                         <p><%=request.getAttribute("error")%></p>
                    </div>
                    <p>Please check again !</p>
                </div>
            </div>
            <%}%>
            <!-- error space -->

            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <%-- Header end--%>
                    <div class="ser_header">
                        <h1><i class="cogs icon"></i>Add New Services and Items</h1>
                    </div>
                    <%-- Header end--%>

                    <%-- add service form start --%>
                    <form class="ui form" method="post" action="<%=request.getContextPath()%>/AddServiceServlet" onsubmit="return checkform()">
                        <div class="field">
                            <label>Select service</label>
                            <select class="fluid dropdown" id="select_service" name="services">
                                <option value="">Services</option>
                                <option value="Remove and Refitting">Remove and Refitting</option>
                                <option value="Repair Items">Repair Items</option>
                                <option value="Painting">Painting</option>
                                <option value="Item to be replace">Item to be replace</option>
                            </select>
                        </div>

                        <div class="field">
                            <label>Description (Optional)</label>
                            <input type="text" placeholder="description" id="description3" name="desc" value="--">
                        </div>
                        <%-- Hidden value--%>
                        <input type="hidden" name="status" value="Onprogress">
                        <input type="hidden" name="pid" value="<%=pid%>">
                        <input type="hidden" name="Wdate" value="<%=date%>">
                        <%-- Hidden value--%>
                        <button class="ui primary button" id="ser_add_btn"><i class="plus square icon"></i>Add Service</button>
                    </form>
                    <%-- estimate servie table --%>
                        <h1><%ArrayList<RepairService> rList =iworkprogress_service.displayServicelist(pid);%></h1>
                    <div class="form_container_service">
                        <table class="ui fixed single line celled table" id="service_table">
                            <thead>
                                <th>Service Name</th>
                                <th>Date</th>
                                <th>description</th>
                                <th>Status</th>
                                <th>Action</th>

                            </thead>
                            <tbody>
                            <%for(RepairService r : rList){%>
                                <td><%=r.getSer_type()%></td>
                                <td><%=r.getDate()%></td>
                                <td><%=r.getDescription()%></td>
                                <td><%=r.getStatus()%></td>
                                <!-- for Update method -->
                               <form method="post" action="<%=request.getContextPath()%>/EditserviceInfoServlet">
                                   <td><button id="Ubutton"  class="ui positive button"><i class="edit icon"></i></button></td>
                                   <input type="hidden" name="serId" value="<%=r.getSer_Id()%>">
                               </form>
                            </tbody>
                            <%}%>
                        </table>
                        <!-- back button space-->
                        <div class="backbtn1">
                            <center>
                                <a href="<%=request.getContextPath()%>/progress.jsp"><button class="ui positive button"><i class="long arrow alternate left icon"></i>Back</button></a>
                            </center>
                        </div>

                    </div>
                    <%-- estimate servie table --%>
                </div>
            </div>
            <div class="summery_content">
                <div class="inter-content">
                    <h4><%=pid%></h4>
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
<!--update form for popup modal -->
<%if(request.getAttribute("ObjectServ") != null){%>
<%RepairService repairService = (RepairService)request.getAttribute("ObjectServ");%>
<div class="update-form">
    <div class="modal_container">
        <i class="sync alternate icon"></i>
        <h1><%=repairService.getSer_type()%></h1>
        <form class="ui form" method="post" action="<%=request.getContextPath()%>/UpdateWorkServiceServlet">
            <center><div class="status_select">
                <select name="Ustatus">
                    <option>Finished</option>
                    <option>OnProgress</option>
                </select>
            </div>
            </center>
            <center>
            <div class="Udesc">
                <input type="text" name="Udesc" value="<%=repairService.getDescription()%>">
            </div>
            </center>
            <center><div class="updateBtn">
                <button class="ui button positive" type="submit">Save Changes</button>
            </div></center>

            <!-- hidden inputs-->
            <input type="hidden" name="serId" value="<%=repairService.getSer_Id()%>">

        </form>
    </div>
</div>
<%}%>
<!--update form finished-->


<%--for side bar space --%>
</body>
</html>

