<%-- 
    Document   : transaksiofflineatm
    Created on : Apr 15, 2018, 4:14:59 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM Login Process</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long rek        = Long.parseLong(request.getParameter("rekening"));
            String pass     = request.getParameter("pass");
            String alamat   = request.getParameter("alamat");
            Tabungan tbg    = new Tabungan(pass, rek);
            Tabungan tbg2   = AppSingleton.getInstance().getTabunganService()
                              .login(tbg);
            
            if (tbg2.getKartu().getType() == KartuATM.TypeKartu.NONE 
                    || tbg2 == null) {
                response.sendRedirect("atm.jsp");
            } else {
                ATM system = new ATM(tbg2, alamat);  
                session.setAttribute("System", system);
                response.sendRedirect("ceksaldoOff.jsp");
            }
        %>
    </body>
</html>
