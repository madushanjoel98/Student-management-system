<%-- 
    Document   : StudentReg
    Created on : Nov 19, 2022, 12:07:54 PM
    Author     : madushan
--%>

<%@page import="com.sm.extra.AdminSessions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     AdminSessions.adminSessionValidatinForHome(session, response, request);    
    
    %>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>
       
        <title>JSP Page</title>
    </head>
    <body>
      
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="#">Student Management</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
	  <div class="collapse navbar-collapse" id="navbarSupportedContent1">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active"> <a class="nav-link text-success" href="#">Student Register <span class="sr-only">(current)</span></a> </li>
		  <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/EC">Enroll to Course</a> </li>
         <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/EC">Student-List <span class="sr-only">(current)</span></a> </li>
            </ul>
  </div>
</nav>
      
      
          <h1> Student Register</h1>
            <% if(request.getSession().getAttribute("error")!=null){
             out.print("<p class='text-danger text-xl-left'>"+request.getSession().getAttribute("error")+"</p>");
             
            request.getSession().removeAttribute("error");
            }else//su
            if(request.getSession().getAttribute("su")!=null){
              out.print("<p class='text-success text-xl-left'>"+request.getSession().getAttribute("su")+"</p>");
               out.print("<a href='' class='text-info text-xl-left'>Enroll this Student?</a>");
            request.getSession().removeAttribute("su");
            }
        %>
          <div i="">
            
            
              <form class="needs-validation" action="<%=request.getContextPath()%>/student-reg" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="validationCustom01">First name</label>
                <input class="form-control validationCustom01 " name="fname" placeholder="First name" type="text" required>
                 <div class="valid-feedback">
      Looks good!
    </div>
           <label>Last name</label>
             <input class="form-control" name="lname" placeholder="last name" type="text" required>
                <label>gender</label>
                <select name="gender"><option value="m">male</option><option value="f">female</option></select>
                
              <label>Date of birth</label>
            <input name="dob" placeholder="Date of birth" type="date" required>
            <br>
            <label  for="mobi">Mobile no</label>
            <input  id="mobi" class="form-control" name="mobi" placeholder="student Mobile" type="tel" required>
               <label  for="mobi">Email</label>
               <input  id="mobi" class="form-control" name="email" placeholder="student Mobile" type="email" required>
              <label>address</label>
                <input class="form-control" name="address" placeholder="address" type="text" required>
             <label>NIC</label>
                <input class="form-control" name="nic" placeholder="NIC" type="text" required>
                <br>
                <!--                 <label>gender</label>
                                 <select id="course" onchange="load_courses()"></select>-->
                <button type="submit" class="btn btn-success">Register</button>
               
            </div>
        </form>
            
        </div>
         
          <script>
              
var loadFile = function(event) {
	var image = document.getElementById('img');
	image.src = URL.createObjectURL(event.target.files[0]);
};
</script>
 <script>
         function  select(){
           
             
           $.ajax({
                        url: "<%=request.getContextPath()%>/cours.jsp",
                        method: "GET",
                        data:"action=1",
                        cache: false,
                      success: function (response) {
                        alert(response);
                    }
                        
                   
                });
                }
 </script>
        <script src="assets/js/bootstrap-4.3.1.js" type="text/javascript"></script>
        <script src="assets/js/popper.min.js" type="text/javascript"></script>
    </body>
</html>
