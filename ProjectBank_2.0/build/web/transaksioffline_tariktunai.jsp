<%-- 
    Document   : transaksioffline_tariktunai
    Created on : Apr 16, 2018, 7:11:41 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarik Tunai Offline</title>
    </head>
    <body>
        <%@page import="model.*"%>
        <%  
            Long nominal     = Long.parseLong(request.getParameter("nominal"));
            TransaksiOffline system = 
                    (TransaksiOffline) session.getAttribute("System");
            
            if (system instanceof ATM) {
                ATM systemATM = (ATM) system;
                if (systemATM.ambil(nominal)) {
                    response.sendRedirect("ceksaldoOff.jsp");
                } else {
                    response.sendRedirect("ambiluang.jsp");
                }
            } else {
                if (system.ambil(nominal)) {
                    response.sendRedirect("ceksaldoOff.jsp");
                } else {
                    response.sendRedirect("ambiluang.jsp");
                }
            } 
        %>
    </body>
</html>
