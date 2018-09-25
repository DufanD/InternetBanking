<%-- 
    Document   : transaksioffline_setortunai
    Created on : Apr 16, 2018, 7:26:23 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="model.*"%>
        <%  
            Long nominal     = Long.parseLong(request.getParameter("nominal"));
            TransaksiOffline system = 
                    (TransaksiOffline) session.getAttribute("System");
            
            if (system.simpan(nominal)) {
                response.sendRedirect("ceksaldoOff.jsp");
            } else {
                response.sendRedirect("simpanuang.jsp");
            }
        %>
    </body>
</html>
