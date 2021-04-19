<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/25/2021
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/employeedetails.css">
    <title>employee details</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
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

            <center><h1>EMPLOYEE DETAILS</h1></center>
            <section class="details">
                <div class="card">
                    <table>
                        <thead>
                        <tr>
                            <th>EMPLOYEE ID</th>
                            <th>EMPLOYEE NAME</th>
                            <th>MANAGE</th>


                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td>001</td>
                            <td>Saman</td>
                            <td><a href ="view?"> <i class="fa fa-eye" aria-hidden="true" style="color:black"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                        </tr>
                        <tr>
                            <td>002</td>
                            <td>Malan</td>
                            <td><a href ="view?" ><i class="fa fa-eye" aria-hidden="true" style="color:black"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                        </tr>
                        <tr>
                            <td>003</td>
                            <td>Bimal</td>
                            <td><a href ="view?" ><i class="fa fa-eye" aria-hidden="true" style="color:black"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                        </tr>
                        <tr>
                            <td>004</td>
                            <td>Pubudu</td>
                            <td><a href ="view?"> <i class="fa fa-eye" aria-hidden="true" style="color:black"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                        </tr>
                        <tr>
                            <td>005</td>
                            <td>Kumara</td>
                            <td><a href ="view?"> <i class="fa fa-eye" aria-hidden="true" style="color:black"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="edit? >" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
                                <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
            <br>

            <input  class="button" type="submit" class="name" name="submit" value="ADD NEW EMPLOYEE" class="btn btn-primary btn-block">

        </div>
    </div>
</div>
</body>
</html>
