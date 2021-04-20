<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rasa.service.Iinventory" %>
<%@ page import="com.rasa.service.InventoryService" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/10/2021
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Initial Template</title>
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

            <div class="main">
                <div class="register">
                    <%if(request.getAttribute("error") != null){%>
                    <div class="ui warning message">
                        <i class="close icon"></i>
                        <div class="header">
                           <%=request.getAttribute("error")%>
                        </div>
                         try again !
                    </div>
                    <%}%>

                    <%Iinventory iinventory = new InventoryService();%>

                    <%
                        LocalDate dates = LocalDate.now();
                        ArrayList<String> list = iinventory.getItemName();
                        ArrayList<String> Slist = iinventory.getSupplerName();
                    %>

                    <h2>Add an item  </h2>
                    <form method="post" id="register" action="<%=request.getContextPath()%>/SaveItemservlet" >

                        <label>Item Name :</label><br>
                        <select name="itemName" class="name2" >
                            <%for(String s : list){%>
                            <option value="<%=s%>"><%=s%></option>
                            <%}%>
                        </select>
                        <br><br>

                        <label>Supplier Name :</label><br>
                        <select name="supplerName" class="name2" >
                            <%for(String s : Slist){%>
                            <option value="<%=s%>"><%=s%></option>
                            <%}%>
                        </select>
                        <br><br>

                        <label>Unit Price :</label><br>
                        <input type="number"id="name" name="price" placeholder="Enter the price" required>
                        <br><br>

                        <label>Qunatity :</label><br>
                        <input type="number" id="name" name="quantity" placeholder="Enter quantity" required>
                        <br><br>
                        <input type="hidden" name="date" value="<%=dates%>">
                        <button type="submit" id="submit" class="saveform">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>