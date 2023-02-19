<%-- 
    Document   : OrderDetail
    Created on : Oct 15, 2022, 12:01:36 AM
    Author     : tuank
--%>

<%@page import="sample.dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        
        <section>
            <h3>Welcome <%= session.getAttribute("name") %> come back</h3>
            <h3><a href="MainController?action=logout">Logout</a></h3>
            <a href="personalPage.jsp">view all orders</a>
        </section>
        
        <section>
            <%
                String orderid = request.getParameter("orderid");
                if (orderid != null) {
                    int orderID = Integer.parseInt(orderid.trim());
                    //int orderID = 3;
                    ArrayList<OrderDetail> list = OrderDAO.getOrderDetail(orderID);
                    if (list != null && !list.isEmpty()) {
                        int money = 0;
                        for (OrderDetail detail : list) {
            %>
            <table class="order" style="text-align: center">
                <tr>
                    <td>Order ID</td>
                    <td>Plant ID</td>
                    <td>Plant Name</td>
                    <td>Image</td>
                    <td>Quantity</td>
                </tr>

                <tr>
                    <td><%= detail.getOrderID()%></td>
                    <td><%= detail.getPlantID()%></td>
                    <td><%= detail.getPlantName()%></td>
                    <td><img src="<%= detail.getImgPath()%>" class="planting" style="width: 200px; height: auto"/></td>
                    <td><%= detail.getQuantity()%></td>
                    <% money = money + detail.getPrice() * detail.getQuantity(); %>
                </tr>
            </table>
            <%          }%>
            <h3>Total money: <%= money%></h3>
            <%        
                } else {
            %>
            <p>You don't have any order</p>
            <%
                    }
                }
            %>
        </section>
        
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
