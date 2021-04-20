<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.service.Iinventory" %>
<%@ page import="com.rasa.service.InventoryService" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.rasa.model.Item" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/10/2021
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>update Items</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet" type="text/css">
    <link href="styles/style1.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles/additem.css">
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
            <!-- implement fuctions here -->
            <p><%Item i = (Item)request.getAttribute("Oitem");%></p>
            <div class="main">
                <div class="register">

                    <h2>Update Item </h2>
                    <form method="post" id="register" action="<%=request.getContextPath()%>/UpdateItemServlet" >

                        <label>Item Name :</label><br>
                        <select name="itemName" class="name2" >
                            <option value="<%=i.getItemName()%>"><%=i.getItemName()%></option>
                        </select>
                        <br><br>

                        <label>Supplier Name :</label><br>
                        <select name="supplerName" class="name2" >
                            <option value="<%=i.getsupplyName()%>"><%=i.getsupplyName()%></option>
                        </select>
                        <br><br>

                        <label>Unit Price :</label><br>
                        <input type="number" value="<%=i.getPrice()%>" name="price">
                        <br><br>

                        <label>Qunatity :</label><br>
                        <input type="number" value="<%=i.getQuantity()%>" name="quantity">
                        <br><br>
                        <input type="hidden" name="date" value="<%=i.getDate()%>">
                        <button type="submit" id="submit" class="saveform">submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>