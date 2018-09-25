<%-- 
    Document   : HapusNasabah
    Created on : Apr 16, 2018, 10:11:41 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hapus Nasabah</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long id = Long.parseLong(request.getParameter("id"));
            AppSingleton.getInstance().getNasabahService().delete(id);
            response.sendRedirect("viewall_nasabah.jsp");
        %>
    </body>
</html>
