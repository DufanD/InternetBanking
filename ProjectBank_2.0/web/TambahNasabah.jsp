<%-- 
    Document   : TambahNasabah
    Created on : Apr 16, 2018, 9:59:29 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Nasabah</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            AppSingleton.getInstance().getNasabahService()
                        .register(new Nasabah());
            response.sendRedirect("viewall_nasabah.jsp");
        %>
    </body>
</html>
