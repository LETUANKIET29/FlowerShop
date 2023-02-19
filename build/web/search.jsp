<%-- 
    Document   : search
    Created on : Oct 25, 2022, 7:59:23 PM
    Author     : tuank
--%>

<%@page import="sample.dao.PlantDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dto.Plant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--phần đầu trang-->
        <header>
            <%@include file="header.jsp" %>
        </header>

        <section>
            <%
                String keyword = request.getParameter("txtsearch");
                String searchby = request.getParameter("searchby");
                ArrayList<Plant> list = PlantDAO.getPlants(keyword, searchby);

                ServletContext context = getServletContext();
                String tmp = context.getInitParameter("countryName");
                out.print("<p>The website is deploying in " + tmp + "</p>");

                ServletConfig servletconfig = getServletConfig();
                String tmp2 = servletconfig.getInitParameter("language");
                out.print("<p>Language is used only in this page: " + tmp2 + "</p>");
            %>

            <%

            %>

            <table class="producttable">
                <thead style="align-items: center">
                    <tr>
                        <th style="width: 20%">product id</th>
                        <th style="width: 20%">name</th>
                        <th style="width: 20%">price</th>
                        <th>images</th>
                        <th style="width: 20%">detail</th>
                        <th style="width: 20%">action</th>
                    </tr>

                    <%  
                        for (Plant plant : list) {
                    %>
                 
                        <%
                            out.print("<tr style=\"text-align: center\">\n"
                                    + "                        <td>" + plant.getId() + "</td>\n"
                                    + "                        <td>" + plant.getName() + "</td>\n"
                                    + "                        <td>" + plant.getPrice() + "</td>\n"
                                    + "                        <td><img src=\"" + plant.getImgpath() + "\" style=\"width: 200px; height: auto\" alt=\"\"/></td>     \n"
                                    + "                        <td><a href='#'>view detail</a></td>\n"
                                    + "                        <td><a href='#'>add to your cart</a></td>                   \n"
                                    + "                    </tr>");
                        } 
                        %>

                </thead>
            </table>

        </section>

        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
