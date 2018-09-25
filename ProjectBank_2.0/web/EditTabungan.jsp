<%-- 
    Document   : EditTabungan
    Created on : Apr 16, 2018, 10:14:46 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Tabungan</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            String user     = request.getParameter("user");
            String pass     = request.getParameter("pass");
            Long rek        = Long.parseLong(request.getParameter("rek"));
            Tabungan tbg    = new Tabungan(rek);
            Tabungan tbg2   = AppSingleton.getInstance().getTabunganService()
                              .login(tbg);
            
            AppSingleton.getInstance().getTabunganService()
                        .settingTabungan(rek, tbg2, pass, user);
            response.sendRedirect("viewall_nasabah.jsp");
        %>
    </body>
</html>
