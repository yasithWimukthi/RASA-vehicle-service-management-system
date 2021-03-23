<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 3/22/2021
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
    <title>PaymentManagement</title>

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css"
    >
    <link rel="stylesheet" href="styles/paymentlist.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.4/semantic.min.js"></script>




</head>
<body >








<div class="modalWindow_container" >
    <div class = "modalWindow">
        <div class="close"id ="close" >+</div>

        <div class="box">
            <form>

                <div class="form-main-text">Edit Payment</div>

                <br>

                <label style="float:left;margin-left:8%" for="RegiNo">RegiNo</label>
                <input type="text" class="form-input" id="RegiNo">



                <label style="float:left;margin-left:8%" for="customer_name" >Customer Name</label>
                <input type="text"  class="form-input"id="customer_name">




                <label style="float:left;margin-left:8%" for="Estimation">Estimation Amount</label>
                <input type="text" class="form-input" id="Estimation">




                <label style="float:left;margin-left:8%" for="insurance">ClaimAmount</label>
                <input type="text"class="form-input" id="insurance">




                <label style="float:left;margin-left:8%" for="cashAmount">Cash</label>
                <input type="text"  class="form-input"id="cashAmount">




                <label style="float:left;margin-left:8%" for="DateOfpayment">Date of Payment</label>
                <input type="text"class="form-input" id="DateOfpayment">




                <br>
                <label for="bi"></label>
                <button class="btn-save" type="submit" id="bi" >Save</button>


            </form>
        </div>


    </div>




</div>
</div>
</div>


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



            <div class="ui container">








                <h2 class="main-title">Payments</h2>

                <table class="ui selectable compact blue table">
                    <thead>
                    <tr>
                        <th class="ui column-width 200px">VehicleRNo</th>
                        <th>customerName</th>
                        <th>estimationAmount</th>
                        <th>insuranceAmount</th>
                        <th>cashAmount</th>
                        <th>dateOfPayment</th>

                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- table data -->
                    <tr>
                        <td>CS4123</td>
                        <td>R.M.Senanayaka</td>
                        <td>100000</td>
                        <td>50000</td>
                        <td>50000</td>
                        <td>12/10/2021</td>
                        <td><a  href="#" id="button"   ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a  href="delete?paymentId=<c:out value='${pay.paymentId}' />" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                    </tr>
                    <tr>
                        <td>CS4678</td>
                        <td>R.M.Rathnayke</td>
                        <td>500000</td>
                        <td>120000</td>
                        <td>345677</td>
                        <td>10/10/2021</td>


                        <!-- action column links -->
                        <td><a href="#" id="button" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a  href="delete?paymentId=<c:out value='${pay.paymentId}' />" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                    </tr>
                    <tr>
                        <td>CS4123</td>
                        <td>R.M.Senanayaka</td>
                        <td>100000</td>
                        <td>50000</td>
                        <td>50000</td>
                        <td>12/10/2021</td>
                        <td><a  href="#"id="button" ><i class= "fa fa-pencil" aria-hidden ="true" style="color:darkblue;width:20px"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a  href="delete?>" ><i class="fa fa-trash-o" aria-hidden="true" style="color:Red"></i></a></td>
                    </tr>


                    </tbody>

                </table>



            </div>
        </div>
    </div>
</div>

<script>



    document.getElementById("button").addEventListener("click",
        function(){
            document.querySelector(".modalWindow_container").style.display = "flex";
        });

    document.getElementById("close").addEventListener("click",
        function () {
            document.querySelector(".modalWindow_container").style.display = "none";
        })
</script>
</body>

</html>
