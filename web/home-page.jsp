<%-- 
    Document   : home-page
    Created on : Nov 24, 2022, 7:39:13 PM
    Author     : madushan
--%>

<%@page import="com.sm.extra.AdminSessions"%>
<%@page import="com.sm.models.StudentM"%>
<%@page import="java.util.List"%>
<%@page import="com.sm.dao.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%
        AdminSessions.adminSessionValidatinForHome(session, response, request);

    %>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <title>Student Management System  </title>
        <style>
            body{
    background:yellow;

            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="<%=request.getContextPath()%>/Home">Student Management</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/student-reg">Student Register</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/EC">Enroll to Course <span class="sr-only">(current)</span></a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/EC">Student-List <span class="sr-only">(current)</span></a> </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" method="Post" action="<%=request.getContextPath()%>/Admin-si?action=2">
                    <input type="submit" value="Log Off" class="btn btn-dark">

                </form>
            </div>

        </nav>

        <h1><img  src="https://cdn-icons-png.flaticon.com/512/1256/1256639.png?w=360&t=st=1670445620~exp=1670446220~hmac=63bb922ae1ad41e440e6da06bdbe5ef25b3facff9ef3a73abc279bfa4a3871d7"
                                     width="10%"><a class="text-dark"  href="<%=request.getContextPath()%>/student-reg">Student Register</a></h1>

        <h3 ><img  src="https://cdn-icons-png.flaticon.com/512/1046/1046027.png?w=360&t=st=1670444603~exp=1670445203~hmac=9e2eee2d20f148da2cd52a632d1842ead412ff70cfe57a6056579ebe83bfa8b8"
                                  width="5%"><a class="text-dark"  href="<%=request.getContextPath()%>/EC">Enroll Student to Course</a></h3>
        <h3 ><img  src="https://cdn-icons-png.flaticon.com/512/1246/1246262.png?w=360&t=st=1670444944~exp=1670445544~hmac=5e64c7f0e066ead8705962235655c34beed335923d1ec73fecb95fe50d630dc8"
                                  width="5%"><a class="text-dark"  href="<%=request.getContextPath()%>/student-list">Student List</a></h3>

        <script src="assets/js/popper.min.js" type="text/javascript"></script>
        <script src="assets/js/bootstrap-4.3.1.js" type="text/javascript"></script>


    </body>
</html>
