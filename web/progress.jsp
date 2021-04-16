<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.RepairService" %><%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>assign Employee</title>
      <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
      <link href="styles/style.css" rel="stylesheet">
      <link href="styles/workprogress.css" rel="stylesheet">
</head>
<body>

<%-- get vehcile entry Id using session --%>
<%int sid = (int)session.getAttribute("sid");%>;
<%-- gather pid--%>
<%Iworkprogress_service iworkprogress_service = new Workprogress_service();%>
<%String pid = iworkprogress_service.getProgressId(sid);%>
<%ArrayList<RepairService> rlist = iworkprogress_service.displayServicelist(pid);%>
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
                  <div class="form-box-assignEmp">
                        <%-- if pid null page is redirect to add services page--%>
                        <%if(pid == null){%>
                              <div class="ser_header">
                                    <h1><i class="cogs icon"></i>Currently No progress!</h1>
                              </div>
                              <div class="form-assign">
                                    <form method="post" action="<%=request.getContextPath()%>/CreateWorkProgressServlet">
                                          <button class="ui positive button"  id="estimatebtn">+ Add Services</button>
                                          <input type="hidden" name ="sid" value="<%=sid%>">
                                    </form>
                               </div>

                              <%-- if pid not null user can add items--%>
                              <%} else{%>
                              <div class="header_container">
                                    <h1><i class="tint icon"></i>Vehicle Service Onprogress..!</h1>
                                    <a href="<%=request.getContextPath()%>/add_services.jsp"><button class="ui positive button">Show Progress</button></a>
                                    <a href="<%=request.getContextPath()%>/add_services.jsp"><button class="ui positive button">Show Estimate</button></a>
                              </div>
                              <div class="btn-container">
                                    <h1><i class="wrench icon"></i>Add Components</h1>
                                    <%for(RepairService repairService : rlist){%>
                                    <form method="post" action="<%=request.getContextPath()%>/RetriveWorkServiceServlet">
                                          <button id="s01" class="ui positive button"><%=repairService.getSer_type()%></button>
                                          <!--hidden types -->
                                          <input type="hidden" name="ser_id" value="<%=repairService.getSer_Id()%>">
                                          <input type="hidden" name="pid" value="<%=pid%>">
                                          <input type="hidden" name="ser_name" value="<%=repairService.getSer_type()%>">
                                          <!--hidden types -->
                                    </form>
                                    <%}%>
                              </div>
                              <%}%>
                  </div>
            </div>
      </div>

</div>
</body>
</html>



