<%--
  Created by IntelliJ IDEA.
  User: yasith wimukthi
  Date: 3/23/2021
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Entry</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="styles/Semantic-UI-CSS-master/semantic.min.js"></script>
    <link href="styles/Semantic-UI-CSS-master/semantic.css" rel="stylesheet" type="text/css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
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

            <!--STEP BAR-->

            <div class="ui steps" style="width: 90%; margin-top:50px; margin-bottom:0">
                <div class="step">
                    <i class="user icon"></i>
                    <div class="content">
                        <div class="title">Customer Registration</div>
                        <div class="description">Enter client details</div>
                    </div>
                </div>
                <div class=" step">
                    <i class="car icon"></i>
                    <div class="content">
                        <div class="title">Vehicle Registration</div>
                        <div class="description">Enter Vehicle Information</div>
                    </div>
                </div>
                <div class="active step">
                    <i class="clipboard outline icon"></i>
                    <div class="content">
                        <div class="title">Service Entry</div>
                        <div class="description">Enter Service Entry Information</div>
                    </div>
                </div>
            </div>

            <!-- ADD ENTRY FORM -->
            <div class="ui grid form-container">
                <div class="sixteen wide column">
                    <form method="post" id="entry-form">
                        <div class="ui huge form error">

                            <div class="two fields">
                                <div class="field error">
                                    <label>Customer Name</label>
                                    <input placeholder="Customer Name" type="text">
                                </div>
                                <div class="field error">
                                    <label>Vehicle Registration Number</label>
                                    <input placeholder="Registration Number" type="text">
                                </div>
                            </div>

                            <div class="field error">
                                <label>Entry Date</label>
                                <input placeholder="Entry Date" type="date" name="entryDate">
                            </div>

                            <div class="inline fields">
                                <label for="repair">Repair Type:</label>
                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="repair" checked="" tabindex="10" class="hidden">
                                        <label>Insuarance</label>
                                    </div>
                                </div>

                                <div class="field">
                                    <div class="ui radio checkbox">
                                        <input type="radio" name="repair" checked="" tabindex="0" class="hidden">
                                        <label>Non-Insuarance</label>
                                    </div>
                                </div>
                            </div>

                            <div class="field error">
                                <label>Accident Date</label>
                                <input placeholder="Accident Date" type="date">
                            </div>

                            <div class="inline field">
                                <label >Repair Type:</label>
                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden">
                                    <label>Customer No objection</label>
                                </div>

                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden">
                                    <label>Insuarance No objection</label>
                                </div>

                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden">
                                    <label>Claim Form</label>
                                </div>
                            </div>

                            <div class="ui error message">
                                <div class="header">Action Forbidden</div>
                                <p>Form is incomplete.</p>
                            </div>

                            <button type="submit" class="ui fluid inverted green labeled icon button submit-btn" id="entry-submit">
                                <i class="right check icon" style="font-size: 1.5em;"></i>
                                complete
                            </button>

                            <div class="ui basic modal">
                                <div class="ui icon header">
                                    <i class="archive icon"></i>
                                    Archive Old Messages
                                </div>
                                <div class="content">
                                    <p>Your inbox is getting full, would you like us to enable automatic archiving of old messages?</p>
                                </div>
                                <div class="actions">
                                    <div class="ui red basic cancel inverted button">
                                        <i class="remove icon"></i>
                                        No
                                    </div>
                                    <div class="ui green ok inverted button">
                                        <i class="checkmark icon"></i>
                                        Yes
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('.ui.radio.checkbox')
        .checkbox();

    $('.ui.checkbox')
        .checkbox();

    // $( "#submit-btn" ).click(function() {
    //     $('.ui.basic.modal')
    //     .modal('show');
    // });

    $( "#entry-form" ).submit(function( event ) {
        //alert( "Handler for .submit() called." );
        event.preventDefault();
        $('.ui.basic.modal')
            .modal('show');
    });
</script>


</body>
</html>
