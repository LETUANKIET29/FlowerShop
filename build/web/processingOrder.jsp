<%-- 
    Document   : processingOrder
    Created on : Nov 6, 2022, 5:07:07 PM
    Author     : tuank
--%>

<%@page import="sample.dto.Order"%>
<%@page import="sample.dto.Order"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing order Page</title>
    </head>
    <body>
        <header style="margin-bottom: 10px">
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <%
            int count = 0;
            String email = (String) session.getAttribute("email");
            ArrayList<Order> list = OrderDAO.getOrders(email);
            String[] status = {"", "processing", "completed", "canceled"};
            if (list != null && !list.isEmpty()) {
                for (Order ord : list) {
        %>
        <%
            if (ord.getStatus() == 1) {
                count++;
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
                <td><%= ord.getShipDate()==null?"":ord.getShipDate() %></td>
                <td>
                    <%= status[ord.getStatus()]%>
                </td>
                <td><a href="OrderDetail.jsp?orderid=<%= ord.getOrderID()%>">detail</a></td>
                <td>
                    <% if (ord.getStatus() == 1) {%> 
                    <a href="mainController?action=cancelOrder&orderID=<%= ord.getOrderID()%>">Change status</a> 
                    <%} else if (ord.getStatus() == 3) {%>
                    <a href="mainController?action=orderAgian&orderID=<%= ord.getOrderID()%>">Change status</a>
                    <%}%> 
                </td>
                <%
                    }
                %>

        </table>
        <%
            }
            if (count == 0) {
        %>
        <h3>you don't have any processing order</h3>
        <%
                }
            }
        %>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>

    </body>
</html>
