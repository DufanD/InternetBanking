<%-- 
    Document   : TambahTabungan
    Created on : Apr 16, 2018, 10:09:47 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Tabungan</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long rek        = Long.parseLong(request.getParameter("rekening"));
            String pass     = request.getParameter("pass");
            String user     = request.getParameter("user");
            Long saldo      = Long.parseLong(request.getParameter("saldo"));
            Long id_nasabah = Long.parseLong(request.getParameter("idNasabah"));
            
            if(AppSingleton.getInstance().getTabunganService()
                    .login(new Tabungan(rek)) == null) {
                AppSingleton.getInstance().getTabunganService()
                            .register(new Tabungan(new Tabungan(rek, user, pass, 
                                                   saldo), id_nasabah));
                response.sendRedirect("viewall_nasabah.jsp");
            } else {
                response.sendRedirect("register_tabungan.jsp");
            }         
        %>
    </body>
</html>
