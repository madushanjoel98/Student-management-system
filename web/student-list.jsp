<%-- 
    Document   : home-page
    Created on : Nov 24, 2022, 7:39:13 PM
    Author     : madushan
--%>

<%@page import="com.sm.models.StudentM"%>
<%@page import="java.util.List"%>
<%@page import="com.sm.dao.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=.5">
        <link href="assets/css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css"/>
        <script src="assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <title>Student List </title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="<%=request.getContextPath()%>/Home">Student Management</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent1">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"> <a class="nav-link text-success">Student-List <span class="sr-only">(current)</span></a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/student-reg">Student Register</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/EC">Enroll to Course <span class="sr-only">(current)</span></a> </li>

                </ul>
                <form class="form-inline my-2 my-lg-0" method="get">
                    <input name="search" type="search" class="form-control mr-sm-2" placeholder="Search:name,id,nic,mobile">
                    <button class=" btn btn-outline-info m-2 my-sm-0">Search</button>
                </form>
            </div>
        </nav>


                   
        <br>

        <table  class="table table-hover">
            <tbody>
                <tr >
                    <th class="bg-dark text-light" scope="col">Student id</th>
                    <th scope="col">Student name</th>
                    <th scope="col">Mobile</th>
                    <th scope="col">Email</th>
                    <th scope="col">DOB</th>
                    <th scope="col">NIC</th>
                    <th scope="col">Action</th>
                        <% StudentDAO sdao = new StudentDAO();
                            List<StudentM> listofS = sdao.studentList(); %>
                </tr>
                <% if (request.getParameter("search") != null) {
                        String search = request.getParameter("search");
                        List<StudentM> searchlist = sdao.studentListSearch(search);
                        for (StudentM sl : searchlist) {
                %>
                <tr>
                    <th class="bg-warning" scope="row"><%= sl.getSTUDENT_ID()%></th>
                    <td> <%= sl.getFirst_name() + " " + sl.getLast_name()%></td>
                    <td><%= sl.getMobile_no()%></td>
                    <td><%= sl.getEmail()%></td>
                    <td><%= sl.getDOB()%></td>
                    <td><%=sl.getNIC()%></td>
                    <td>
                       
                        <a class="btn btn-success" href="<%=request.getContextPath()%>/student-view?sid=<%=sl.getSTUDENT_ID()%>"> view</a>

                    </td>

                </tr>



                <% }
                } else
                    for (StudentM st : listofS) {%>
                <tr>
                    <th class="bg-warning" scope="row"><%= st.getSTUDENT_ID()%></th>
                    <td> <%= st.getFirst_name() + " " + st.getLast_name()%></td>
                    <td><%= st.getMobile_no()%></td>
                    <td><%= st.getEmail()%></td>
                    <td><%= st.getDOB()%></td>
                    <td><%=st.getNIC()%></td>
                    <td>
                      
                        <a class="btn btn-success" href="<%=request.getContextPath()%>/student-view?sid=<%=st.getSTUDENT_ID()%>"> view</a>

                      
                    </td>

                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
    <script src="assets/js/bootstrap-4.3.1.js" type="text/javascript"></script>
    <script src="assets/js/popper.min.js" type="text/javascript"></script>
</body>
</html>
