<%-- 
    Document   : HapusTabungan
    Created on : Apr 16, 2018, 10:13:28 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hapus Tabungan</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long rek = Long.parseLong(request.getParameter("rek"));
            AppSingleton.getInstance().getTabunganService().delete(rek);
            response.sendRedirect("viewall_nasabah.jsp");
        %>
    </body>
</html>
