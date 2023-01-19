<%-- 
    Document   : adminLog
    Created on : Nov 19, 2022, 12:07:14 PM
    Author     : madushan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% out.print(session.getAttribute("name"));         %>
    <body>
        <h1>Admin Login</h1>
    </body>
</html>
