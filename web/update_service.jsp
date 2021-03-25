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
    <title>update service</title>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet">
    <link href="styles/addServices.css" rel="stylesheet">
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
            <div class="createS-form-box">
                <div class="form-contenter">
                    <h1><i class="cog icon"></i>Update Service Status</h1>
                    <form class="ui form" id="cre_form" method="" action="">
                        <div class="field">
                            <label>Enter Service type</label>
                            <input type="text" placeholder="Service Name" id="Ser_type" value="" disabled>
                        </div>
                        <div class="field">
                            <label>description</label>
                            <input type="text" placeholder="description" id="Description" value="">
                        </div>
                        <div class="field">
                            <label>Update Status</label>
                            <select class="fluid dropdown" id="update_status">
                                <option value="">Select Status</option>
                                <option value="Finished">Finished</option>
                                <option value="Process">Process</option>
                            </select>
                        </div>
                        <button class="ui positive button" id="ser_add_btn"><i class="edit icon"></i>Save Changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
