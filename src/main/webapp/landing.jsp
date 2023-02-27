<% if(session.getAttribute("name")==null)
response.sendRedirect("login.jsp");
	%>

<html>
<% String uname =(String)session.getAttribute("name");
String path = (String) session.getAttribute("file");


%>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="bower_components/bootstrap-5.1.3-dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="fa/css/all.min.css"/>
 <script src="bower_components/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
 

<link rel="stylesheet" href="css/chat2.css" >

<title>The Chat Room</title>
</head>
<script type="text/javascript" src="new2.js"></script>

<body>


<input id = "u" value=<%=uname %> type="hidden"/>
<nav class="navbar navbar-expand-lg bg-primary  d-flex justify-content-between align-items-center text-light px-3"> 
 
   
      <div > <p class="navbar-brand">Welcome <%= uname %></div>  
   <figure class="nav-item" >
    <div class="dropdown">
        <figure class="dropdown-toggle"  data-bs-toggle="dropdown" aria-expanded="false">
            <img src="image/<%= path%>" alt="User" class="message__img">
           <span style="font-weight: bolder;"><%= uname %></span> 
        </figure>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Profile</a></li>
          <li><a class="dropdown-item" href="#">Privacy</a></li>
          <li><a class="dropdown-item" href="logout.jsp">Log Out</a></li>
        </ul>
      </div>
 


</figure>
 
   </nav>

</div>
<div id="list" >
<div id="content" >
    <div class="flex">
      <!--  <div class="message_container">
            <img src="asset/user-2.jpg" alt="" class="message__img">
            <p class="message__txt mine">this is lorem ipsum message from f1</p>
        </div>
    
        <div class="message_container self">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt mine self__txt">this is lorem ipsum message from f1</p>
        </div>

        <div class="message_container">
            <img src="asset/user-3.jpg" alt="" class="message__img">
            <p class="message__txt mine">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container self">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt mine self__txt">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container self">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt  self__txt">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container ">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ipsam amet, quos placeat vel velit labore molestiae, optio sed error rem sunt, possimus iste minima sequi asperiores cumque ex adipisci sint. lorem ipsum message from f1</p>
        </div>
        <div class="message_container  self ">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt  self__txt">Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia itaque aliquam soluta, non at temporibus deleniti eaque qui incidunt eligendi nulla, accusamus tenetur reprehenderit excepturi commodi possimus corrupti velit ipsum.  this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt ">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container ">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt mine ">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container self">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt mine self__txt">this is lorem ipsum message from f1</p>
        </div>
        <div class="message_container ">
            <img src="asset/User5.jpg" alt="" class="message__img">
            <p class="message__txt mine ">this is lorem ipsum message from f1</p>
        </div>
    </div>
  --> 
  
   

</div>
 <div class="textarea__container">
        <textarea id="h"  draggable="false" ></textarea>
           <button onclick="addText();" class="send"><i class="fas fa-cloud-arrow-up"></i>

</button>
        <button onclick="addText();" class="send"><i class="fas fa-paper-plane">send</i></button>
    </div>


</div>
<div class="copyright">
    <p class="copy__text" style="text-align: center; margin-top: 35px;">developed by Group 4 teams<span>&copy; 2023</span></span></p>
</div>
<!--<textarea id="h" style="width:100%; height:10%;"></textarea>
<input type="button" value="send" onclick="addText();"/>-->
<div><% session.getAttribute("name"); %></div>
</div>
</body>

<script>



</script>


</html>