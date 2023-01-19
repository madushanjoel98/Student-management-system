<%-- 
    Document   : student-view
    Created on : Nov 28, 2022, 12:25:00 PM
    Author     : madushan
--%>

<%@page import="com.sm.extra.AdminSessions"%>
<%@page import="java.util.List"%>
<%@page import="com.sm.models.Enroll"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sm.dao.EnrollDAO"%>
<%@page import="com.sm.dao.StudentDAO"%>
<%@page import="com.sm.models.StudentM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     AdminSessions.adminSessionValidatinForHome(session, response, request);    
    
    %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/popupform.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>

    <body>
        <nav  aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/student-list">Students</a></li>
                <li class="breadcrumb-item active" aria-current="page">View</li>
            </ol>
        </nav>
        <%

            int SID = 0;
            StudentDAO sda = new StudentDAO();
            EnrollDAO enrollDAO = new EnrollDAO();
            StudentM sm = new StudentM();
            if (request.getParameter("sid") != null) {
                SID = Integer.parseInt(request.getParameter("sid"));

                sm = sda.selectstudent(SID);

            } else {
                response.sendRedirect(request.getContextPath() + "/Home");
            }
        %>
        <div class="container-fluid  ">

            <div class="row conc">
                <div class="col-lg-6 " >
                    <% try {%>
                    <br>
                    <div class="card card-body">

                        <h1 class="card-header"><%= sm.getFirst_name()%>  <%= sm.getLast_name()%></h1>
                        <h5 class="text-info">ID: <%= sm.getSTUDENT_ID()%></h5>
                        <h4><%= sm.getDOB()%></h4>
                        <h4><%= sm.getNIC()%></h4>
                        <h4><%= sm.getEmail()%></h4>
                        <h4><%= sm.getMobile_no()%></h4>
                        <p><b>Address: </b><%= sm.getAddress()%></p>
                        <button class="btn btn-success" onclick="openForm()"> Edit Details</button>
                    </div>

                    <%  if (sm.getImage_location() == null) {
                            out.println("<button class='btn btn-warning'> Upload profile-image</button>");
                        } else {
                            out.println("<button class='btn btn-success'>update profile image</button>");
                        }%>


                    <div  id="edits" hidden>
                        <h1>Edit</h1> <button class="btn btn-danger" onclick="closeForm()">close</button>
                        <form action="<%=request.getContextPath()%>/su?action=1&sid=<%=SID%>" method="post" class="form-container bg-dark text-light">

                            <div class="form-group">
                                <label for="fname">First name</label>
                                <input class="form-control" id="fname"name="fname" placeholder="First name" type="text" value="<%= sm.getFirst_name()%>" required>
                                <label>Last name</label>
                                <input class="form-control" name="lname" placeholder="last name" type="text" value="<%= sm.getLast_name()%>" required>
                                <label>gender</label>
                                <select name="gender" required value="<%= sm.getGender()%>"><option value="m">male</option><option value="f" >female</option></select>

                                <label>Date of birth</label>
                                <input name="dob" placeholder="Date of birth" type="date" required value="<%= sm.getDOB()%>">
                                <br>
                                <label  for="mobi">Mobile no</label>
                                <input  id="mobi" class="form-control" name="mobi" placeholder="student Mobile" type="tel" value="<%= sm.getMobile_no()%>" required>
                                <label  for="mobi">Email</label>
                                <input  id="mobi" class="form-control" name="email" placeholder="student Mobile" type="email"value="<%= sm.getEmail()%>"  required>
                                <label>address</label>
                                <input class="form-control" name="address" placeholder="address" type="text"value="<%= sm.getAddress()%>"  required>
                                <label>NIC</label>
                                <input class="form-control" name="nic" placeholder="NIC" type="text"value="<%= sm.getNIC()%>" required>
                                <br>
                                <!--                 <label>gender</label>
                                                 <select id="course" onchange="load_courses()"></select>-->
                                <button type="submit" class="btn btn-success">Save</button>

                            </div>

                        </form> 
                    </div>
                </div>

                <div class="col-lg-6 bg-dark">
                    <% List<Enroll> courselis = enrollDAO.selecteEnrolledCoursesBYStudent(SID); %>
                    <br>
                    <div>
                        <h1 class="text-success">Enrolled Courses</h1>
                        <!--                        start-->
                        <% for (Enroll crs : courselis) {
                       String coursename=crs.getBatch().getCourses().getCourse_name();
                       int batchid=crs.getBatch_ID();
                        int eid=crs.getEnroll_ID();
                        String branchname=crs.getBatch().getBranch().getBranch_location()+"-"+crs.getBatch().getBranch().getName();
                            %>
                        <div class="card card-body">
                            <div class="card-title card-header">
                            <h4 ><%= coursename%></h4>
                            <a class=" btn btn-danger"style="width: 100px" href="<%=request.getContextPath()%>/erd?action=2&eid=<%=eid%>&sid=<%=SID%>">Delete</a>
                            </div>
                            <p>Batch ID:<%=batchid%></p>
                            <p>Branch: <%=branchname%></p>
                            
                            <a class="btn btn-warning" >View Details</a>
                        </div>
                            </br>
                        <%} %>
                        <!--end-->
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function openForm() {
                    document.getElementById("edits").hidden = false;
                }

                function closeForm() {
                    document.getElementById("edits").hidden = true;
                }

            </script>
            <%} catch (Exception e) {

                    System.out.println("error:" + e.getMessage());
                    response.sendRedirect(request.getContextPath() + "/student-list");

                }%>
    </body>
</html>
