<%-- 
    Document   : index
    Created on : Oct 25, 2022, 3:32:52 PM
    Author     : tuank
--%>

<%@page import="sample.dao.PlantDAO"%>
<%@page import="sample.dto.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <section style="margin-left: 7%">
            <%
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
            %>
            <table class="product" style="width: 15%; text-align: center;">
                <tr>
                <tr><td><img src="<%= p.getImgpath()%>" class="planting" style="height: 150px; width: auto"/></td></tr>
                <tr><td>Product ID: <%= p.getId()%> </td></tr>
                <tr><td>Product Name: <%= p.getName()%></td></tr>
                <tr><td>Price: <%= p.getPrice()%></td></tr>   
                <tr><td>
                        Status: <%= p.getStatus()==1?"stock":"sold out" %>
                    </td>
                </tr>   
                <tr><td>Category: <%= p.getCatename()%></td></tr>   
                <tr><td style="background: #ff3333; border-radius: 10px;"><a href="mainController?action=addtocart&pid=<%= p.getId()%>"><p style="color: white">add to cart</p></a></td></tr>               
                </tr>                 
            </table>
            <%
                    }
                }
            %>
        </section>

        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
