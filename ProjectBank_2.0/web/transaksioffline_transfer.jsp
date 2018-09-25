<%-- 
    Document   : transaksioffline_transfer
    Created on : Apr 16, 2018, 5:36:15 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Offline</title>
    </head>
    <body>
        <%@page import="model.*"%>
        <%  
            Long rekTujuan  = Long.parseLong(request.getParameter("rekTujuan"));
            Long nominal    = Long.parseLong(request.getParameter("nominal"));
            TransaksiOffline system = 
                    (TransaksiOffline) session.getAttribute("System");
            
            if (system.transfer(nominal, rekTujuan)) {
                response.sendRedirect("ceksaldoOff.jsp");
            } else {
                response.sendRedirect("transferOff.jsp");
            }
        %>
    </body>
</html>
