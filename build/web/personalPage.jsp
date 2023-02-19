<%-- 
    Document   : personalPage
    Created on : Oct 25, 2022, 5:27:01 PM
    Author     : tuank
--%>

<%@page import="sample.dao.AccountDAO"%>
<%@page import="sample.dto.Account"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page import="sample.dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head style="margin-bottom: 10px">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
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
                login = true;
            }

            if (login) {
        %>

        <!--phần đầu trang-->
        <header>
            <%@include file="header_loginedUser.jsp" %>
        </header>

        <!--Chào mừng trở lại-->
        <section>
            <h3>Welcome <%= name%> come back</h3>
            <h3><a href="mainController?action=logout">Logout</a></h3>
        </section>

        <section><!--hiển thị mặt hàng người dùng đã order tại đây-->
            <%
                ArrayList<Order> list = OrderDAO.getOrders(email);
                String[] status = {"", "processing", "completed", "canceled"};
                out.print("Order list:" + email + "");
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {
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
                </tr>
            </table>            
            <%
                }
            } else {
            %>
            <p>You don't have any order</p>
            <%
                }
            %>
        </section>              

        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>

        <%
            }
        %>       
    </body>
</html>
