<%-- 
    Document   : cancelOrder
    Created on : Nov 6, 2022, 5:06:55 PM
    Author     : tuank
--%>

<%@page import="sample.dto.Order"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header style="margin-bottom: 10px">
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <%
            int count = 0;
            String dateOrder = request.getParameter("from");
            String shipOrder = request.getParameter("to");
            String email = (String) session.getAttribute("email");
            ArrayList<Order> list = OrderDAO.searchOrdersWithDate(dateOrder, shipOrder, email);
            String[] status = {"", "processing", "completed", "canceled"};
            if (list != null && !list.isEmpty()) {
                for (Order ord : list) {
        %>
        <%

        %>
        <table class="order">
            <tr>
                <td>Order ID</td>
                <td>Order Date</td>
                <td>Ship Date</td>
                <td>Order's status</td>
                <td>action</td>
                <td>Change status</td>
            </tr>
            <tr>
                <td><%= ord.getOrderID()%></td><td><%= ord.getOrderDate()%></td>                
                <td><%= ord.getShipDate() == null ? "" : ord.getShipDate()%></td>

                <% if (ord.getStatus() == 1) {%>                   
                <td style="color: orange"><%= status[ord.getStatus()]%></td>

                <% } else if (ord.getStatus() == 2) {%>
                <td style="color: green"><%= status[ord.getStatus()]%></td>

                <% } else {%>
                <td style="color: red"><%= status[ord.getStatus()]%></td> 
                <%}%> 

                <td><a href="OrderDetail.jsp?orderid=<%= ord.getOrderID()%>">detail</a></td>
                <td>
                    <% if (ord.getStatus() == 1) {%> 
                    <a href="mainController?action=cancelOrder&orderID=<%= ord.getOrderID()%>">Change status</a> 
                    <%} else if (ord.getStatus() == 3) {%>
                    <a href="mainController?action=orderAgian&orderID=<%= ord.getOrderID()%>">Change status</a>
                    <%}%> 
                </td>
                <%

                %>

        </table>
        <%      }
            } else {

            }
        %>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>

    </body>
</html>
