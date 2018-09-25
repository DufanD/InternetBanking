<%-- 
    Document   : CreateATMProcess
    Created on : Apr 16, 2018, 9:25:41 PM
    Author     : Diend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create ATM</title>
    </head>
    <body>
        <%@page import="model.*, singleton.AppSingleton"%>
        <%  
            Long rek        = Long.parseLong(request.getParameter("rekening"));
            String type     = request.getParameter("type");
            Tabungan tbg    = AppSingleton.getInstance().getTabunganService()
                              .login(new Tabungan(rek));
            
            tbg.setKartu(new KartuATM(tbg));

            if (type.equals("Gold")) {
                tbg.getKartu().setType(KartuATM.TypeKartu.GOLD);
            } else if (type.equals("Platinum")) {
                tbg.getKartu().setType(KartuATM.TypeKartu.PLATINUM);
            } else if (type.equals("Silver")) {
                tbg.getKartu().setType(KartuATM.TypeKartu.SILVER);
            }
            AppSingleton.getInstance().getTabunganService()
                        .createATM(rek, tbg);
            response.sendRedirect("viewall_nasabah.jsp");
        %>
    </body>
</html>
