<%-- 
    Document   : checking
    Created on : Nov 24, 2022, 1:44:42 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="assets/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <select id="s" onchange="branch()">
            <option value="1">Hell</option>
            <option value="2">Hell0</option>
        </select>
        <select id="mySelect" >
            
        </select>
    </body>
    <script type="text/javascript">
        function branch(){
            let vars=document.getElementById("s").value;
           // alert(vars);
            $("#mySelect").empty();
        $.getJSON('<%=request.getContextPath()%>/cours.jsp?action='+vars, function(data) {
       var select = document.getElementById("mySelect");
         for (var i = 0; i < data.length; i++) {
   
    var option = document.createElement("option");
   
    option.text = data[i].name;
    option.value = data[i].branch_id;
    select.add(option);
}

       });
        }
    </script>
</html>
