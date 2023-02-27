<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <title>ChatX | Socialize</title>
 <!-- Tell the browser to be responsive to screen width -->

 <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 <!-- Bootstrap 3.3.7 -->
 <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
 <!-- Font Awesome -->
 <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
 <!-- Ionicons -->
 <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
 <!-- Theme style -->
 <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
 <!-- iCheck -->
 <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  <link rel="sty;esheet" href="dist/sweet-alert/sweetalert2.css">
 <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
 <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
 <!--[if lt IE 9]>
 <script src="external/html5shiv/html5shiv.min.js" ></script>
 <script src="external/respond/respond.min.js"></script>
 <![endif]-->
 <!-- Google Font -->
 <link rel="stylesheet" href="external/googleapisfonts/fonts.css">



<meta name="google-signin-client_id" content="1010071565133-jcl9rglke1q6c13vuoem7h1i3a5rd8vc.apps.googleusercontent.com">
  <script src="https://apis.google.com/js/platform.js" async defer></script>


</head>
<body class="hold-transition login-page">
<input type="hidden" id = "status" value="<%= request.getAttribute("status") %>" />
<div class="login-box">
 <div class="login-logo">
 <b>Chat</b>X
 </div>
 <!-- /.login-logo -->
 <div class="login-box-body">
 <p class="login-box-msg">Enter OTP code from your email </p>
<form action="verify" method="post" autocomplete="off">

 <div id="usernameGroup" class="form-group has-feedback">
 <input id='otp'  class="form-control" placeholder="7-Digit number" name="otp" required>
 <span class="glyphicon glyphicon-user form-control-feedback"></span>
 </div>

 <!-- /.col -->

 <input type="submit" value="veryfiy" class="btn btn-primary btn-block btn-flat" />

</form>
 <!-- /.col -->
 
 <!-- /.login-box-body -->
</div>
<!-- /.login-box -->


 
<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script src="dist/sweet-alert/sweetalert2.all.min.js"></script>
<script type="text/javascript">
let status = document.getElementById("status").value;

if(status=="wrong"){
	sweetAlert("Oops...", "Wrong OTP code", "error");
}



</script>
<script src='js/tmchat-service.js'></script>
<script src='js/tmchat.js'></script>
</body>
</html>