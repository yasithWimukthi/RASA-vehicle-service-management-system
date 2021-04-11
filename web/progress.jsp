<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %><%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Vehicle progress</title>
      <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
      <link href="styles/style.css" rel="stylesheet">
      <link href="styles/workprogress.css" rel="stylesheet">
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
                                    <h1><i class="cogs icon"></i>Currently no progress !</h1>
                              </div>

                                    <%-- get vehcile entry Id using session --%>
                                    <%int sid = (int)session.getAttribute("sid");%>;

                                    <%Iworkprogress_service iworkprogress_service = new Workprogress_service();%>
                                    <%-- check progress Id method --%>

                                    <%String pid = iworkprogress_service.getProgressId(sid);%>

                                    <%if(pid == null){%>

                                    <form method="post" action="<%=request.getContextPath()%>/CreateWorkProgressServlet">
                                          <button class="ui positive button"  id="estimatebtn">Create Estimate</button>
                                          <input type="hidden" name ="sid" value="<%=sid%>">
                                    </form>


                                    <button class="ui positive button" id="s01">Remove And refitting Items</button>
                                    <button class="ui positive button" id="s02">Painting Items</button>
                                    <button class="ui positive button" id="s03">Repair to be Items</button>
                                    <button class="ui positive button" id="s04">service 4</button>




                                    <%} else{%>
                                    <button class="ui positive button" id="s01">Remove And refitting Items</button>
                                    <button class="ui positive button" id="s02">Painting Items</button>
                                    <button class="ui positive button" id="s03">Repair to be Items</button>
                                    <button class="ui positive button" id="s04">service 4</button>

                                    <%}%>

                        </div>
                  </div>
            </div>
      </div>
  </div>
</body>
</html>
