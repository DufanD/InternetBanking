<%-- 
    Document   : logout
    Created on : Apr 16, 2018, 8:39:04 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%@page import="model.*"%>
        <%  
            session.removeAttribute("System");
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
