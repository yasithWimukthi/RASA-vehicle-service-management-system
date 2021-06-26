<%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/8/2021
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>assign Employee</title>
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
            <div class="form-box-assignEmp">
                <div class="form-assign">
                    <form method="" action="" class="ui form" id="form_emp">
                        <h3>Vehicle No : Ab123</h3>
                        <h1><i class="user icon"></i>Assign employee</h1>
                        <select class="fluid dropdown" >
                            <option value="">Select Employee</option>
                            <option value="">Select Employee</option>
                            <option value="">Select Employee</option>
                            <option value="">Select Employee</option>
                        </select>
                        <button class="ui positive button" id="assign_btn"><i class="check icon"></i>Assign and save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
