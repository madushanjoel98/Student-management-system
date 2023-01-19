<%-- 
    Document   : enrolls
    Created on : Nov 24, 2022, 7:31:11 PM
    Author     : madushan
--%>
<%@page import="com.sm.extra.AdminSessions"%>
<%
     AdminSessions.adminSessionValidatinForHome(session, response, request);    
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="assets/css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>

        <title>Student Enrollment</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="<%=request.getContextPath()%>/Home">Student Management</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"> <a class="nav-link text-success" href="#">Enroll to Course <span class="sr-only">(current)</span></a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/student-reg">Student Register</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/student-list">Student-List <span class="sr-only">(current)</span></a> </li>
                </ul>
            </div>
        </nav>
                
        <h1>Hello World!</h1>
        <% if (request.getSession().getAttribute("error") != null) {
               
                out.print(" <div class='alert alert-danger' role='alert'> " + request.getSession().getAttribute("error") + "</div>");
                request.getSession().removeAttribute("error");
            } else//su
            if (request.getSession().getAttribute("su") != null) {
                out.print("<p class='text-success text-xl-left'>" + request.getSession().getAttribute("su") + "</p>");
                request.getSession().removeAttribute("su");
            }
        %>
        <div class="form-group">
            <form action="<%=request.getContextPath()%>/EC?action=1" method="post" >


                <label>Student id</label>
                <input class="form-control" id="sid" name="sid" placeholder="Student id" type="number" onchange="" oninput="load_name()">
                <p id="name" class="text-success text-uppercase"></p>

                <div class="alert alert-danger" role="alert" id="wr" hidden> Student not Available</div>
                <label>Course</label>
                <select class="form-text" id="course" name="course" ><option selected disabled>Select Course </option></select>
                <label>Branch</label>
                <select class="form-text dropdown" id="branch" name="branch" onchange="batching()"></select>
                <label>Batch</label>
                <select class="form-text dropdown" id="batch" name="batch" onclick="batching()">
                    <option selected>Select batches</option>
                </select>
                <br>
                <button id="btn" class="btn btn-info btn-outline-dark" type="submit" disabled>Enroll</button>
            </form>
        </div>

        <script type="text/javascript">
//        let vars=document.getElementById("s").value;
            function branch() {
                $("#branch").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=1', function (data) {
                    var select = document.getElementById("branch");

                    for (var i = 0; i < data.length; i++) {

                        var option = document.createElement("option");

                        option.text = data[i].name;
                        option.value = data[i].branch_id;
                        select.add(option);
                    }

                });
            }
            function courses() {
                $("#course").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=2', function (data) {
                    var select = document.getElementById("course");

                    for (var i = 0; i < data.length; i++) {

                        var option = document.createElement("option");

                        option.text = data[i].course_name;
                        option.value = data[i].Course_ID;
                        select.add(option);
                    }

                });
            }

            function load_name() {
                var sid = document.getElementById("sid").value;
                $("#name").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=3&sid=' + sid, function (data) {
                    //  let name = document.getElementById("name");
                    if (data === null) {
                        document.getElementById("wr").hidden = false;
                        document.getElementById("btn").disabled = true;
                    } else {
                        document.getElementById("wr").hidden = true;
                        document.getElementById("btn").disabled = false;
                        var names = data.first_name + " " + data.last_name;
                        //alert(names)

                        document.getElementById("name").innerHTML = names;
                    }
                });
            }

            function batching() {
                var cr = document.getElementById("course").value;
                var br = document.getElementById("branch").value;
                $("#batch").empty();

                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=4&br=' + br + '&cr=' + cr, function (data) {
                    var select = document.getElementById("batch");

                    for (var i = 0; i < data.length; i++) {
                        console.log(data);
                        var option = document.createElement("option");

                        option.text = data[i].batch_name;
                        option.value = data[i].Batch_NO;
                        select.add(option);
                    }

                });
            }

            function form_validation() {

                var cr = document.getElementById("course").value;
                var br = document.getElementById("branch").value;
                var sid = document.getElementById("sid").value;
                console.log("hello");
                if (sid === null) {
                    document.getElementById("btn").disabled = true;

                } else {

                    document.getElementById("btn").disabled = false;
                }

            }
            courses();
            branch();
            form_validation();
        </script>

        <script src="assets/js/bootstrap-4.3.1.js" type="text/javascript"></script>
        <script src="assets/js/popper.min.js" type="text/javascript"></script>
    </body>
</html>
