
   <%@page  errorPage="Error.jsp" %>

<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <title>ChatX | Socialize</title>

 <link rel="stylesheet" href="css/login.css">
 <link rel="sty;esheet" href="dist/sweet-alert/sweetalert2.css">
 <script src="dist/sweet-alert/sweetalert2.all.min.js"></script>
</head>
<body >
<input type="hidden" id = "status" value="<%= request.getAttribute("status") %>" />
<input type="hidden" id = "value" value="<%= request.getAttribute("value")%>" />

 <div class="login__container">
        <h2 class="heading">Login To Start Your Session</h2>
   <form method="post" action="login" class="form__group">
    <input type="text" placeholder="User Name" class="form__input" name="uname" required>
    <input type="password" placeholder="password" class="form__input" name="pwd" required>
    <input type="submit" class="btn" value="Login">
    <a href="forgot.jsp" class="link">Forgot Password</a>
    <a href="Register.jsp" class="link">Create New Account</a>
   </form>

    </div>


<script type="text/javascript">


let value = document.getElementById("value").value;

if(value=="incorrect"){
	sweetAlert("Oops...", "Incorrect Username or Password", "error");
}








let status = document.getElementById("status").value;

if(status=="No input"){
	sweetAlert("Oops...", "Something went wrong!", "error");
}
if(status=="invalid pwd"){
	sweetAlert("Oops...", "Enter password!", "error");
}
if(status=="invalid email"){
	sweetAlert("Oops...","Enter username", "error");
}


//876918864716-g9kbm4h126ptrf8hntgtnrki6utnu2r5.apps.googleusercontent.com
//client secret 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
</script>

</body>
