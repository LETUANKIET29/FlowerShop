package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dao.AccountDAO;
import sample.dto.Account;
import sample.dao.OrderDAO;
import sample.dto.Order;
import java.util.ArrayList;

public final class personalPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header_loginedUser.jsp");
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
      out.write("    <head style=\"margin-bottom: 10px\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            
            Cookie[] c = request.getCookies();

            boolean login = false;
            if (name == null) {
                String token = "";
                for (Cookie aCookie : c) {
                    if (aCookie.getName().equals("selector")) {
                        token = aCookie.getValue();
                        Account acc = AccountDAO.getAccountswithToken(token);
                        if (acc != null) {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            } else {
                login=true;
            }

            if (login) {
        
      out.write("\n");
      out.write("\n");
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
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"personalPage.jsp\">All order</a></li>\n");
      out.write("                <li><a href=\"updateAccountWithEmail.jsp\">Change profile</a></li>\n");
      out.write("                <li><a href=\"completeOrder.jsp\">completed orders</a></li>\n");
      out.write("                <li><a href=\"cancelOrder.jsp\">Canceled orders</a></li>\n");
      out.write("                <li><a href=\"processingOrder.jsp\">processing orders</a></li>\n");
      out.write("                <li>from<input  type=\"date\" name=\"from\"> \n");
      out.write("                    to <input type=\"date\" name=\"to\">\n");
      out.write("                    <input type=\"submit\" value=\"search\">   \n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <!--Chào mừng trở lại-->\n");
      out.write("        <section>\n");
      out.write("            <h3>Welcome ");
      out.print( name);
      out.write(" come back</h3>\n");
      out.write("            <h3><a href=\"mainController?action=logout\">Logout</a></h3>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <section><!--hiển thị mặt hàng người dùng đã order tại đây-->\n");
      out.write("            ");

                ArrayList<Order> list = OrderDAO.getOrders(email);
                String[] status = {"", "processing", "completed", "canceled"};
                out.print("Order list:" + email + "");
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {
            
      out.write("\n");
      out.write("            <table class=\"order\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Order ID</td>\n");
      out.write("                    <td>Order Date</td>\n");
      out.write("                    <td>Ship Date</td>\n");
      out.write("                    <td>Order's status</td>\n");
      out.write("                    <td>action</td>\n");
      out.write("                    <td>Change status</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( ord.getOrderID());
      out.write("</td><td>");
      out.print( ord.getOrderDate());
      out.write("</td>                \n");
      out.write("                    <td>");
      out.print( ord.getShipDate());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( status[ord.getStatus()]);
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td><a href=\"OrderDetail.jsp?orderid=");
      out.print( ord.getOrderID());
      out.write("\">detail</a></td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if ( ord.getStatus() == 1 || ord.getStatus() == 3 ) {
      out.write(" \n");
      out.write("                        <a href=\"mainController?action=cancelOrder&orderid=");
      out.print( ord.getOrderID());
      out.write("\">Change status</a> ");
}
      out.write(" \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>            \n");
      out.write("            ");

                }
            } else {
            
      out.write("\n");
      out.write("            <p>You don't have any order</p>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </section>              \n");
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
      out.write("\n");
      out.write("        ");

            }
        
      out.write("       \n");
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
