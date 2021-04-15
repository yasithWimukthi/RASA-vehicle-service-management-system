<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.RepairComponent" %>
<%@ page import="com.rasa.service.Iworkprogress_service" %>
<%@ page import="com.rasa.service.Workprogress_service" %>
<%@ page import="com.rasa.model.VehicleComponent" %><%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/12/2021
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Repair Items components</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/workprogress.css" rel="stylesheet">
</head>
<body>
<!--session variable spaces -->
<%String ser_id = (String)session.getAttribute("serviceId");
  String ser_name = (String)session.getAttribute("serviceName");
  Iworkprogress_service iworkprogress_service = new Workprogress_service();
  ArrayList<RepairComponent> LrepairCom = iworkprogress_service.retriveRepairComponents(ser_id);
  ArrayList<VehicleComponent> LVehcileCom = iworkprogress_service.retriveVehcileComponents();

%>

<!-- -->
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
            <h1>Add Repair Components</h1>
            <div class="createS-form-box">
                <div class="addItems_form-contenter">
                    <h1><%=ser_name%></h1>

                    <form method="post" action="<%=request.getContextPath()%>/AddRepairItemsServlet">
                        <center>
                            <select name="RItems">
                                <%for(VehicleComponent v :LVehcileCom){%>
                                <option value="<%=v.getV_itemId()%>"><%=v.getV_Item_name()%></option>
                                <%}%>
                            </select>
                        </center>
                        <center>
                            <input type="text" name="estimateAmount">
                        </center>
                        <center>
                            <button class="ui positive button">Add and Display</button>
                        </center>
                        <!-- hidden values-->
                        <input type="hidden" name="ser_id" value="<%=ser_id%>">
                        <!-- hidden values -->
                    </form>
                </div>
            </div>
<!-- Display list -->
            <div class="form_container_component" style="position:absolute; width:37%; top:20%;left:60%;">
                <table class="ui fixed single line celled table" id="service_table">
                    <thead>
                        <th>ComponentName</th>
                        <th>Estimate Amount</th>

                        <th>Action</th>
                        <th>Action</th>

                    </thead>

                    <%if(LrepairCom.isEmpty()){%>
                        <td colspan="4"><p>No Components added</p></td>
                    <%}else%>

                    <%for(RepairComponent repairComponent : LrepairCom){%>
                      <tbody>
                            <td><%=repairComponent.getVehicleComponent().getV_Item_name()%></td>
                            <td><%=repairComponent.getEstimateAmount()%></td>
                     <!-- for Update method -->
                            <form method="post" action="<%=request.getContextPath()%>/addrepaircomponent.jsp">
                               <td><button id="Ubutton"  class="ui positive button"><i class="edit icon"></i></button></td>
                               <input type="hidden" name="serId" value="">
                             </form>
                     <!--for delete method -->
                            <form method="post" action="<%=request.getContextPath()%>/addrepaircomponent.jsp">
                                <td><button id="Dbutton"  class="negative ui button"><i class="trash icon"></i></button></td>
                                <input type="hidden" name="serId" value="">
                            </form>
                            <%}%>
                      </tbody>
                </table>
            </div>
            <!-- Display list  end-->


        </div>
    </div>
</div>
</body>
</html>

