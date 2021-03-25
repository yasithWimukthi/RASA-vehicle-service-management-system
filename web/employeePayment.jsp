<%--
  Created by IntelliJ IDEA.
  User: Yasith Wimukthi
  Date: 3/9/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Initial Template</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/employeePayment.css" rel="stylesheet">
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
            <div id="clr_div">
                <div id="act_div">
                    <table id="act_tbl">
                        <thead>
                        <th> ID </th>
                        <th> fname </th>
                        <th> lname </th>
                        <th> Advance </th>
                        <th> payment</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        <tr>
                            <td> 001 </td>
                            <td> kavindu </td>
                            <td> balasooriya </td>
                            <td><button class="btn_adv">advance</button></td>
                            <td><button class="btn_pay">payment</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="recent_adv">
                    <form id="adv_frm">
                        <center><h5> Latest advance record</h5></center><br>
                        <input type="text" name="id" placeholder="ID"><br>
                        <input type="number" name="amount" placeholder="advance amount"><br><br>
                        <button class="btn_frm" id="btn_frm_update">update</button>
                        <button class="btn_frm" id="btn_frm_delete">delete</button>
                    </form>
                </div>
                <button>monthly payment</button>
                <button>advance</button>
                <div class="show">

                </div>
            </div>
        </div>
        </div>
    </div>
</div>

</body>
</html>

