/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.dao.PlantDAO;
import sample.dto.Plant;

/**
 *
 * @author tuank
 */
public class searchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            
            request.setAttribute("txtsearch", keyword);
            ArrayList<Plant> list = PlantDAO.getPlants(keyword, searchby);

            if (list != null) {
                out.print("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <meta charset=\"UTF-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "        <title>Servlet searchServlet</title>"
                        + "        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n"
                        + "    </head>\n"
                        + "<header>\n"
                        + "     <nav>\n"
                        + "                <ul>\n"
                        + "                    <li><a href=\"index.jsp\"><img src=\"images/logo.jpg\" id=\"1000\" style=\"width: 80px; height: auto \"</a></li>\n"
                        + "                    <li><a href=\"index.jsp\">Home</a></li>\n"
                        + "                    <li><a href=\"registration.jsp\">Register</a></li>\n"
                        + "                    <li><a href=\"login.jsp\">Login</a></li>\n"
                        + "                    <li><a href=\"mainController?action=viewcart\">View cart</a></li>\n"
                        + "                    <li>                       \n"
                        + "                        <form action=\"mainController\" method=\"post\" class=\"formsearch\">\n"
                        + "                            <input type=\"text\" name=\"txtsearch\" value=\""+keyword+"\">\n"
                        + "                            <select name =\"searchby\">\n"
                        + "                                <option value=\"byname\">by name</option>\n"
                        + "                                <option value=\"bycate\">by category</option>\n"
                        + "                            </select>\n"
                        + "                            <input type=\"submit\" value=\"search\" name=\"action\">\n"
                        + "                        </form>                      \n"
                        + "                    </li>\n"
                        + "                </ul>\n"
                        + "            </nav>"
                        + "</header>"
                        + "    <body>\n"
                        + "        <section>\n");

                ServletContext context = getServletContext();
                String tmp = context.getInitParameter("countryName");
                out.print("<p>The website is deploying in " + tmp + "</p>");

                ServletConfig servletconfig = getServletConfig();
                String tmp2 = servletconfig.getInitParameter("language");

                out.print("<p>Language is used only in this page: " + tmp2 + "</p>");
                out.print("            "
                        + "            <table style=\"border: 2px solid #cccccc;\" class=\"table\">\n"
                        + "                <thead style=\"align-items: center\";>\n"
                        + "                    <tr>\n"
                        + "                        <th style=\"width: 20%\">product id</th>\n"
                        + "                        <th style=\"width: 20%\">name</th>\n"
                        + "                        <th style=\"width: 20%\">price</th>\n"
                        + "                        <th>images</th>\n"
                        + "                        <th style=\"width: 20%\">detail</th>\n"
                        + "                        <th style=\"width: 20%\">action</th>\n"
                        + "                    </tr>");
                for (Plant plant : list) {
                    out.print("<tr style=\"text-align: center\">\n"
                            + "                        <td><p>" + plant.getId() + "</p></td>\n"
                            + "                        <td><p>" + plant.getName() + "</p></td>\n"
                            + "                        <td><p>" + plant.getPrice() + "</p></td>\n"
                            + "                        <td><img src=\"" + plant.getImgpath() + "\" style=\"width: 200px; height: auto\" alt=\"\"/></td>     \n"
                            + "                        <td><a href='getPlantServlet?pid="+plant.getId()+"'>view detail</a></td>\n"
                            + "                        <td><a href='mainController?action=addtocart&pid="+plant.getId()+"'>add to your cart</a></td>                   \n"
                            + "                    </tr>");
                }
                out.print("</thead>\n"
                        + "            </table>\n"
                        + "        </section>\n"
                        + "    </body>\n"
                        + "<footer>"
                        + "<p></p>"
                        + "</footer>"
                        + "</html>");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
