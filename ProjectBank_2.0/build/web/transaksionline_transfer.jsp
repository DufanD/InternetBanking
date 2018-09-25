<%-- 
    Document   : transaksionline_transfer
    Created on : Apr 16, 2018, 5:36:15 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Online</title>
    </head>
    <body>
        <%@page import="model.*"%>
        <%  
            Long rekTujuan  = Long.parseLong(request.getParameter("rekTujuan"));
            Long nominal    = Long.parseLong(request.getParameter("nominal"));
            String pass     = request.getParameter("pass");
            TransaksiOnline system = 
                    (TransaksiOnline) session.getAttribute("System");
            
            if (system.transfer(nominal, rekTujuan, pass)) {
                response.sendRedirect("ceksaldoOn.jsp");
            } else {
                response.sendRedirect("transferOn.jsp");
            }
        %>
    </body>
</html>
