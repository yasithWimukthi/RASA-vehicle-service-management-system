<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.RepairService" %>
<%@ page import="com.rasa.model.RepairComponent" %><%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>progress</title>
      <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
      <link href="styles/style.css" rel="stylesheet">
      <link href="styles/workprogress.css" rel="stylesheet">
</head>
<body>

<%-- get vehcile entry Id using session --%>
<%--Runtime check sid is invalid --%>
<%int sid = 0;%>
<%if(request.getAttribute("sid") != null){%>
      <%=sid = (int)request.getAttribute("sid")%>
<%}else{%>
      <script>
            alert("internal server error");
      </script>
<%}%>
<%--Runtime check sid is invalid end --%>
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

                              <div class="form-createP">
                                    <h1><i class="cogs icon"></i>Currently No progress!</h1>
                                    <form method="post" action="<%=request.getContextPath()%>/CreateWorkProgressServlet">
                                          <button class="ui positive button"  id="estimatebtn"><i class="plus icon"></i>Add Services</button>
                                          <input type="hidden" name ="sid" value="<%=sid%>">
                                    </form>
                               </div>
                              <%-- if pid not null user can add items--%>
                              <%} else{%>

                                    <div class="header_container">
                                          <form method="post" action="<%=request.getContextPath()%>/CreateWorkProgressServlet">
                                                <h1><i class="tint icon"></i>Vehicle Service Onprogress..!</h1>
                                                <input type="hidden" value="<%=sid%>" name="sid">
                                                <button class="ui positive button"><i class="plus icon"></i>Show Progress</button>
                                          </form>
                                          <!-- navigate estimate report -->
                                          <button class="ui positive button"><i class="calendar icon"></i>Show Estimate</button>
                                          <!-- navigate estimate report-->
                                    </div>
                              <div class="p_container">
                                    <div class="btn-container">
                                          <h1><i class="wrench icon"></i>Add Components</h1>
                                          <%for(RepairService repairService : rlist){%>
                                          <form method="post" action="<%=request.getContextPath()%>/RetriveWorkServiceServlet">
                                                 <button id="s01" class="ui positive button"><%=repairService.getSer_type()%></button>
                                          <!--hidden types -->
                                                <input type="hidden" name="ser_id" value="<%=repairService.getSer_Id()%>">
                                                <input type="hidden" name="pid" value="<%=pid%>">
                                                <input type="hidden" name="sid" value="<%=sid%>">
                                                <input type="hidden" name="ser_name" value="<%=repairService.getSer_type()%>">
                                          <!--hidden types -->
                                          </form>
                                          <%}%>
                                    </div>
                              </div>
                              <%}%>
                              <!-- estimate total amounts-->
                              <div class="table_estimate">
                                    <h4>Current total estimate</h4>
                                    <table class="ui celled table">
                                          <thead>
                                          <tr>
                                                <th>Service type</th>
                                                <th>Total estimate Amount</th>
                                                <th>Total Components</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                          <%for(RepairService repairService : rlist){%>
                                          <%ArrayList<RepairComponent> LCount = iworkprogress_service.retriveRepairComponents(repairService.getSer_Id());%>
                                          <tr>
                                                <td data-label=""><%=repairService.getSer_type()%></td>
                                                <td data-label=""><%=iworkprogress_service.CalcTotalEstimates(repairService.getSer_type(),sid)%></td>
                                                <td data-label=""><%=LCount.size()%></td>
                                          </tr>
                                          <%}%>
                                          </tbody>
                                    </table>
                              </div>
                              <!-- estimate total amount-->
                  </div>
            </div>
      </div>

</div>
</body>
</html>



