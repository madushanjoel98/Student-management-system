<%-- 
    Document   : index
    Created on : Nov 19, 2022, 12:06:32 PM
    Author     : madushan
--%>

<%@page import="com.sm.extra.AdminSessions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <% 

    AdminSessions.adminSessionValidatin(session, response, request);
      %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
