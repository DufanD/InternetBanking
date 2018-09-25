<%-- 
    Document   : transaksiofflineteller
    Created on : Apr 15, 2018, 5:41:16 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teller Login Process</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long rek        = Long.parseLong(request.getParameter("rekening"));
            String pass     = request.getParameter("pass");
            String teller   = request.getParameter("namaTeller");
            Tabungan tbg    = new Tabungan(pass, rek);
            Tabungan tbg2   = AppSingleton.getInstance().getTabunganService()
                              .login(tbg);
            
            if (tbg2 == null) {     
                response.sendRedirect("teller.jsp"); 
            } else {
                Teller system = new Teller(tbg2, teller);  
                session.setAttribute("System", system);
                response.sendRedirect("ceksaldoOff.jsp");
            }
        %>
    </body>
</html>
