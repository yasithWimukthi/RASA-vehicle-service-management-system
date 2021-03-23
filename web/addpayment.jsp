<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 3/22/2021
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
    <title>Add payment</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >
    <link rel="stylesheet" href="styles/addpayment.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>
</head>
<body>

<!-- nav bar -->
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


            <div id="wrapper">
                <h1>Estimate Amount</h1>

                <table id="keywords" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th><span>Id</span></th>
                        <th ><span>Services</span></th>
                        <th ><span>Amount</span></th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>1</td>
                        <td>Painting</td>
                        <td>10000</td>

                    </tr>
                    <tr>

                        <td>2</td>
                        <td>Remove and Refting</td>
                        <td>5000</td>

                    </tr>
                    <tr>

                        <td>3</td>
                        <td>Replace items</td>
                        <td>5000</td>

                    </tr>
                    <tr>

                        <td></td>
                        <td></td>
                        <td></td>

                    </tr>


                    </tbody>

                    <tfoot class="amount" align="center">
                    <tr>
                        <td>CB1234</td>
                        <td>Total Amount</td>
                        <td>Rs 20000</td>
                    </tr>

                    </tfoot>
                </table>
            </div>

            <div class="esti-wrapper">
                <div class="form">
                    <h2>Payment Form</h2>

                    <div class="inputfield">
                        <label>vehicle RegisterNo</label>
                        <input type="text" class="input" name="vehicle No">
                    </div>

                    <div class="inputfield">
                        <label>customer Name</label>
                        <input type="text" class="input" name="customerName">
                    </div>
                    <div class="inputfield">
                        <label>Estimation Amount</label>
                        <input type="text" class="input" name="etimation">
                    </div>
                    <div class="inputfield">
                        <label>Claim Amount</label>
                        <input type="text"  class="input" name="insurance">
                    </div>
                    <div class="inputfield">
                        <label>Cash </label>
                        <input type="text"  class="input"name="cash amount">
                    </div>
                    <div class="inputfield">
                        <label>Payment Date</label>
                        <input type="date" class="input" name="dateofPayment">
                    </div>



                    <div class="inputfield">
                        <input type="submit" class="btn"value="save">
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>

