<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.RepairService" %>
<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %>
<%@ page import="com.rasa.model.RepairComponent" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/14/2021
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report handler</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/workprogress.css" rel="stylesheet">
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
                String pid = session.getAttribute("pid").toString();
                int sid = Integer.parseInt(session.getAttribute("sid").toString());
                Iworkprogress_service iworkprogress_service = new Workprogress_service();
                ArrayList<RepairService> rs = iworkprogress_service.displayServicelist(pid);
            %>
            <h1 style="text-align: center">Estimate Report</h1>
            <h2 style="text-align: center">Vehicle NO : 1000D</h2>



            <div class="table-content">
                <%for(RepairService rps : rs){%>
                <div class="ui mini menu" style="font-size:9px;background-color: #d5d5d5">
                    <h4 class="active item">
                        <%=rps.getSer_type()%>
                    </h4>
                    <div class="right menu">
                        <div class="item">
                            <form method="post" action="<%=request.getContextPath()%>/RetriveWorkServiceServlet">
                                <!--hidden types -->
                                <input type="hidden" name="ser_id" value="<%=rps.getSer_Id()%>">
                                <input type="hidden" name="pid" value="<%=pid%>">
                                <input type="hidden" name="sid" value="<%=sid%>">
                                <input type="hidden" name="ser_name" value="<%=rps.getSer_type()%>">
                                <!--hidden types -->
                                <button class="ui primary button">Change Estimate</button>
                            </form>

                        </div>
                    </div>
                </div>
                 <%ArrayList<RepairComponent> rpc = iworkprogress_service.retriveRepairComponents(rps.getSer_Id());%>
                <table class="ui unstackable table">
                    <thead>
                    <tr>
                        <th>Repair Component</th>
                        <th>Estimate Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%for(RepairComponent rdc : rpc){%>
                    <tr>
                        <td><%=rdc.getVehicleComponent().getV_Item_name()%></td>
                        <td>RS: <%=rdc.getEstimateAmount()%></td>
                    </tr>
                    <%}%>

                    </tbody>
                </table>
                <%}%>

                <button class="ui positive button">DownLoad Estimate Report</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>
