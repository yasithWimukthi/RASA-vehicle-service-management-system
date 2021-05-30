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
    <script src="scripts/workprogress.js"></script>
</head>
<body>
<!--session variable spaces -->
<%
    String ser_id = (String)session.getAttribute("serviceId");
    String ser_name = (String)session.getAttribute("serviceName");
    int sid = (int)session.getAttribute("sid");
    Iworkprogress_service iworkprogress_service = new Workprogress_service();
    ArrayList<RepairComponent> LrepairCom = iworkprogress_service.retriveRepairComponents(ser_id);
    ArrayList<VehicleComponent> LVehcileCom = iworkprogress_service.retriveVehcileComponents();

%>
<!-- session variable spaces end-->

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
            <div class="error_container1">
                <div class="ui negative message" id="errCon" style="display:none">
                    <div class="header">
                        <p id="errID"></p>
                    </div>
                </div>
                <%if(request.getAttribute("error") !=null){%>
                    <div class="ui negative message">
                        <i class="close icon"></i>
                        <div class="header">
                           <p><i class="x icon"></i><%=request.getAttribute("error")%></p>
                        </div>
            </div>
                <%}%>
                <%if(request.getAttribute("deletemsg") !=null){%>
                <div class="ui negative message">
                    <i class="close icon"></i>
                    <div class="header">
                       <p> <i class="check icon"></i><%=request.getAttribute("deletemsg")%></p>
                    </div>
                </div>
            <%}%>
                <%if(request.getAttribute("updateMsg") !=null){%>
                <div class="ui positive message">
                    <i class="close icon"></i>
                    <div class="header">
                        <p> <i class="check icon"></i><%=request.getAttribute("updateMsg")%></p>
                    </div>
                </div>
                <%}%>
            <!-- error space -->
            </div>
            <div class="header_container_repair">
                <h1><i class="plus icon"></i>Add Repair Components</h1>
            </div>

            <div class="createS-form-box">
                <div class="addItems_form-contenter">
                    <h1><%=ser_name%></h1>

                    <form method="post" action="<%=request.getContextPath()%>/AddRepairItemsServlet" onsubmit="return checkComponentForm()">
                        <center>
                            <select name="RItems">
                                <%for(VehicleComponent v :LVehcileCom){%>
                                <option value="<%=v.getV_itemId()%>"><%=v.getV_Item_name()%></option>
                                <%}%>
                            </select>
                        </center>
                        <center>
                            <input type="text" id="estiID" name="estimateAmount">
                        </center>
                        <center>
                            <button class="ui positive button">Add and Display</button>
                        </center>

                        <!-- hidden values-->
                        <input type="hidden" name="ser_id" value="<%=ser_id%>">
                        <!-- hidden values -->
                    </form>
                    <!-- back button space-->
                    <div class="backbtn">
                        <center>
                            <form method="post" action="<%=request.getContextPath()%>/NavigatetoServlet">
                                <input type="hidden" name="sid" value="<%=sid%>">
                                <button class="ui positive button"><i class="long arrow alternate left icon"></i>Back</button>
                            </form>
                        </center>
                    </div>

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
                            <form method="post" action="<%=request.getContextPath()%>/RetriveUpdateEstimateServlet">
                               <td><button id="Ubutton"  class="ui positive button"><i class="edit icon"></i></button></td>
                                <!--Hidden values -->
                                <input type="hidden" name="serId" value="<%=repairComponent.getRepairService().getSer_Id()%>">
                                <input type="hidden" name="Item_id" value="<%=repairComponent.getVehicleComponent().getV_itemId()%>">
                                <input type="hidden" name="ser_name" value="<%=repairComponent.getVehicleComponent().getV_Item_name()%>">
                                <!--Hidden values end -->
                             </form>
                     <!--for delete method -->
                            <form method="post" action="<%=request.getContextPath()%>/DeleteVeCompServlet">
                                <td><button id="Dbutton"  class="negative ui button"><i class="trash icon"></i></button></td>
                                <!-- hidden values -->
                                <input type="hidden" name="DserId" value="<%=repairComponent.getRepairService().getSer_Id()%>">
                                <input type="hidden" name="DItem_id" value="<%=repairComponent.getVehicleComponent().getV_itemId()%>">
                                <!--hidden values -->
                            </form>
                            <%}%>
                      </tbody>
                </table>

            </div>
            <!-- Display list  end-->

            <!--Update form -->
            <%if(request.getAttribute("Object_rcom") != null){%>
            <%RepairComponent r = (RepairComponent)request.getAttribute("Object_rcom");%>
            <div class="update-form-estimate">
                <div class="modal_container">
                    <i class="sync alternate icon"></i>
                    <h1>Edit Estimate</h1>
                    <form class="ui form" method="post" action="<%=request.getContextPath()%>/UpdateEstimateServlet">
                        <center>
                            <div class="Udesc">
                                <input type="text" value="<%=r.getVehicleComponent().getV_Item_name()%>" disabled>
                            </div>
                        </center>

                        <center>
                            <div class="Udesc">
                                <input type="text" name="U_estimate" value="<%=r.getEstimateAmount()%>">
                            </div>
                        </center>
                        <!-- hidden values -->
                        <input type="hidden" name="ser_id"  value="<%=r.getRepairService().getSer_Id()%>">
                        <input type="hidden" name="item_id" value="<%=r.getVehicleComponent().getV_itemId()%>">
                        <!-- hidden values -->

                        <center><div class="updateBtn">
                            <button class="ui button positive" type="submit">Save Changes</button>
                        </div></center>
                        <!-- hidden inputs-->
                    </form>
                </div>
            </div>
            <%}%>
            <!-- update form-->
        </div>
    </div>
</div>
</body>
</html>

