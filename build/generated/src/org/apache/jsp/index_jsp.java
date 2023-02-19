package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dao.PlantDAO;
import sample.dto.Plant;
import java.util.ArrayList;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--phần đầu trang-->\n");
      out.write("        <header>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name =\"viewport\" content=\"width-device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\"><img src=\"images/logo.jpg\" id=\"logo\" style=\"width: 80px; height: auto \"</a></li>\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"registration.jsp\">Register</a></li>\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("                    <li><a href=\"mainController?action=viewcart\">View cart</a></li>\n");
      out.write("                    <li>                       \n");
      out.write("                        <form action=\"mainController\" method=\"post\" class=\"formsearch\">\n");
      out.write("                            <input type=\"text\" name=\"txtsearch\"\n");
      out.write("                                   value=\"");
      out.print( (request.getParameter("txtsearch")==null)?"": request.getParameter("txtsearch"));
      out.write("\">\n");
      out.write("                            <select name =\"searchby\">\n");
      out.write("                                <option value=\"byname\">by name</option>\n");
      out.write("                                <option value=\"bycate\">by category</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" value=\"search\" name=\"action\">\n");
      out.write("                        </form> \n");
      out.write("\n");
      out.write("                        <!--\n");
      out.write("                        <form action=\"mainController\" method=\"post\" class=\"formsearch\">\n");
      out.write("                        <input type=\"text\" name=\"txtsearch\" value=\"");
      out.print( (request.getParameter("txtsearch") == null) ? "" : request.getParameter("txtsearch"));
      out.write("\">\n");
      out.write("                        <select name =\"searchby\">\n");
      out.write("                            <option value=\"byname\">by name</option>\n");
      out.write("                            <option value=\"bycate\">by category</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input type=\"submit\" value=\"search\" name=\"action\">\n");
      out.write("                        </form>\n");
      out.write("                        -->\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section style=\"margin-left: 7%\">\n");
      out.write("            ");

                String keyword = request.getParameter("txtsearch");
                String searchby = request.getParameter("searchby");
                ArrayList<Plant> list;
                String[] tmp = {"out of stock", "available"};

                if (keyword == null && searchby == null) {
                    list = PlantDAO.getPlants("", "byname");
                } else {
                    list = PlantDAO.getPlants(keyword, searchby);
                }
                if (list != null && !list.isEmpty()) {
                    for (Plant p : list) {
            
      out.write("\n");
      out.write("            <table class=\"product\" style=\"width: 15%; text-align: center;\">\n");
      out.write("                <tr>\n");
      out.write("                <tr><td><img src=\"");
      out.print( p.getImgpath());
      out.write("\" class=\"planting\" style=\"height: 150px; width: auto\"/></td></tr>\n");
      out.write("                <tr><td>Product ID: ");
      out.print( p.getId());
      out.write(" </td></tr>\n");
      out.write("                <tr><td>Product Name: ");
      out.print( p.getName());
      out.write("</td></tr>\n");
      out.write("                <tr><td>Price: ");
      out.print( p.getPrice());
      out.write("</td></tr>   \n");
      out.write("                <tr><td>\n");
      out.write("                        Status: ");
      out.print( p.getStatus()==1?"stock":"sold out" );
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>   \n");
      out.write("                <tr><td>Category: ");
      out.print( p.getCatename());
      out.write("</td></tr>   \n");
      out.write("                <tr><td style=\"background: #ff3333; border-radius: 10px;\"><a href=\"mainController?action=addtocart&pid=");
      out.print( p.getId());
      out.write("\"><p style=\"color: white\">add to cart</p></a></td></tr>               \n");
      out.write("                </tr>                 \n");
      out.write("            </table>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <!--phần cuối trang-->\n");
      out.write("        <footer>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>footer Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <p style=\"color: black; text-align: center;\"> Copyright &copy; 2022</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
