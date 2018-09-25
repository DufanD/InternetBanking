<%-- 
    Document   : transaksionline_login
    Created on : Apr 16, 2018, 8:35:06 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Online</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            String user     = request.getParameter("user");
            String pass     = request.getParameter("pass");
            Tabungan tbg    = new Tabungan(user, pass);
            Tabungan tbg2   = AppSingleton.getInstance().getTabunganService()
                              .login(tbg);
                        
            if ( tbg2 == null) {
                response.sendRedirect("online.jsp"); 
            } else {
                TransaksiOnline system = new TransaksiOnline(tbg2);  
                session.setAttribute("System", system);
                response.sendRedirect("ceksaldoOn.jsp");
            }
        %>
    </body>
</html>
