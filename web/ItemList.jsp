<%@ page import="com.rasa.service.Iinventory" %>
<%@ page import="com.rasa.service.InventoryService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.model.Item" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/13/2021
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item list</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet" type="text/css">
    <link href="styles/style1.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles/itemTable.css">
</head>
<body>

<%Iinventory inventoryService = new InventoryService();%>
<%ArrayList<Item> itemslist = inventoryService.retriveAllItemList();%>

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
                <%if(request.getAttribute("updated") != null){%>
            <div class="ui success message">
                <i class="close icon"></i>
                <div class="header">
                  Product updated successfully
                </div>
            </div>
                <%}%>
            <div id="clr_div">
                <div id="att_div" class="div">
                    <a href="addItem.html"><button type="submit" class="btn_sup">Add New Item</button></a>
                    <center>
                        <table>
                            <thead>
                            <tr>
                                <th>ItemCode</th>
                                <th> ItemName</th>
                                <th>SupplerID</th>
                                <th> Unit Price </th>
                                <th> Quantity </th>
                                <th>date </th>
                                <th id="save_clm">Update</th>
                                <th id="save_clm">Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%for(Item item :itemslist) {%>

                            <tr>
                                <td><%=item.getItemCode()%></td>
                                <td><%=item.getItemName()%></td>
                                <td><%=item.getsupplyName()%></td>
                                <td><%=item.getPrice()%></td>
                                <td><%=item.getQuantity()%></td>
                                <td><%=item.getDate()%></td>
                                <td>
                                    <form method="post" action="<%=request.getContextPath()%>/GetItemdataServlet">
                                        <input type="hidden" name="Icode" value="<%=item.getItemCode()%>">
                                        <input type="hidden" name="sname" value="<%=item.getsupplyName()%>">
                                        <input type="hidden" name = "date" value="<%=item.getDate()%>">
                                        <center><button type=submit class="btn_tbl">Update</button></center>
                                    </form>
                                </td>
                                <td>
                                    <center><button type=submit class="btn_tb2">Delete</button></center>
                                </td>
                            </tr>
                            <%}%>

                            </tbody>
            </table>
        </center>
                    <!-- implement fuctions here -->

    </div>
    <div class="div" id="btn_div" >

    </div>
</div>




</body>
</html>
