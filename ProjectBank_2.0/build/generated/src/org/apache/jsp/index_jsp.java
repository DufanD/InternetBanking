package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <title>Banking</title>\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/iconfont.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/fonts/stylesheet.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/jquery.fancybox.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/magnific-popup.css\">\r\n");
      out.write("        <!--        <link rel=\"stylesheet\" href=\"assets/css/bootstrap-theme.min.css\">-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--For Plugins external css-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/plugins.css\" />\r\n");
      out.write("\r\n");
      out.write("        <!--Theme custom css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <!--Theme Responsive css-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/responsive.css\" />\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body data-spy=\"scroll\" data-target=\".navbar-collapse\">\r\n");
      out.write("        <!--[if lt IE 8]>\r\n");
      out.write("            <p class=\"browserupgrade\">You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/\">upgrade your browser</a> to improve your experience.</p>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("        <div class='preloader'><div class='loaded'>&nbsp;</div></div>\r\n");
      out.write("        <div class=\"culmn\">\r\n");
      out.write("            <header id=\"main_menu\" class=\"header navbar-fixed-top\">            \r\n");
      out.write("                <div class=\"main_menu_bg\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"nave_menu\">\r\n");
      out.write("                                <nav class=\"navbar navbar-default\">\r\n");
      out.write("                                    <div class=\"container-fluid\">\r\n");
      out.write("                                        <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                                        \r\n");
      out.write("                                        <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\r\n");
      out.write("                                            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                                                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                                                <li><a href=\"admin.jsp\">Admin</a></li>\r\n");
      out.write("                                            </ul>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </nav>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </header> <!--End of header -->\r\n");
      out.write("\r\n");
      out.write("            <section id=\"home\" class=\"home\">\r\n");
      out.write("                <div class=\"overlay\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-sm-12 \">\r\n");
      out.write("                                <div class=\"main_home_slider text-center\">\r\n");
      out.write("                                    <div class=\"single_home_slider\">\r\n");
      out.write("                                        <div class=\"main_home wow fadeInUp\" data-wow-duration=\"700ms\">\r\n");
      out.write("                                            <h1>ONLINE</h1>\r\n");
      out.write("                                            <div class=\"home_btn\">\r\n");
      out.write("                                                <a href=\"online.jsp\" class=\"btn btn-primary\">LOGIN</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"single_home_slider\">\r\n");
      out.write("                                        <div class=\"main_home wow fadeInUp\" data-wow-duration=\"700ms\">\r\n");
      out.write("                                            <h1>ATM</h1>\r\n");
      out.write("                                            <div class=\"home_btn\">\r\n");
      out.write("                                                <a href=\"atm.jsp\" class=\"btn btn-primary\">LOGIN</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"single_home_slider\">\r\n");
      out.write("                                        <div class=\"main_home wow fadeInUp\" data-wow-duration=\"700ms\">\r\n");
      out.write("                                            <h1>TELLER</h1>\r\n");
      out.write("                                            <div class=\"home_btn\">\r\n");
      out.write("                                                <a href=\"teller.jsp\" class=\"btn btn-primary\">LOGIN</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("        <!-- START SCROLL TO TOP  -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"scrollup\">\r\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-chevron-up\"></i></a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/vendor/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/jquery.magnific-popup.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.mixitup.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.easing.1.3.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.masonry.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.fancybox.pack.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?v=3.exp\"></script>\r\n");
      out.write("        <script src=\"http://maps.google.com/maps/api/js\"></script>\r\n");
      out.write("        <script src=\"assets/js/gmaps.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("                                            function showmap() {\r\n");
      out.write("                                                var mapOptions = {\r\n");
      out.write("                                                    zoom: 8,\r\n");
      out.write("                                                    scrollwheel: false,\r\n");
      out.write("                                                    center: new google.maps.LatLng(-34.397, 150.644),\r\n");
      out.write("                                                    mapTypeId: google.maps.MapTypeId.ROADMAP\r\n");
      out.write("                                                };\r\n");
      out.write("                                                var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);\r\n");
      out.write("                                            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"assets/js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
