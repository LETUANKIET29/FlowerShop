<%-- 
    Document   : viewCart
    Created on : Oct 29, 2022, 1:00:42 AM
    Author     : tuank
--%>

<%@page import="sample.dto.Plant"%>
<%@page import="sample.dao.PlantDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
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
                String name = ( String) session.getAttribute("name");
                if(name!=null){
            %>
            <h3>Welcome <%= session.getAttribute("name")%> come back </h3>
            <h3><a href="mainController?action=logout">Logout</a></h3>
            <h3><a href="personalPage.jsp">Personal page</a></h3>
            <%
                }
            %>
            <font style="color:red;"> <%= (request.getAttribute("WARNING")==null)?"":(String)request.getAttribute("WARNING") %></font>
            
            <table width="100%" class="shopping">
                <tr>
                    <td>Product id</td>
                    <td>Quantity</td>                 
                    <td>Price</td>
                    <td>Action</td>
                </tr>
                
                <%
                    int totalMoney=0;
                    HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                    if(cart!=null){
                        Set<String> pids = cart.keySet();                     
                        for (String pid : pids) {
                                int quantity = cart.get(pid);
                                
                                Plant plant = PlantDAO.getPlant(Integer.valueOf(pid));
                                int price = plant.getPrice();
                                totalMoney = totalMoney + price*quantity;                             
                %>
                    
                <form action="mainController" method="post">
                    <tr>
                        <td><input type="hidden" value="<%= pid %>" name="pid"><a href="getPlantServlet?pid=<%= pid%>"><%= pid%></a></td>
                        <td><input type="number" value="<%= quantity %>" name="quantity"></td>
                        <td><%=price*quantity%></td>
                        <td><input type="submit" value="update" name="action">
                            <input type="submit" value="delete" name="action"></td>
                    </tr>
                </form>
                    
                <%
                            }
                    }else{ 
                %>
                <tr>
                    <td>Your cart is empty</td>
                </tr>
                <%             
                    }
                %>
                <tr><td>Total money: <%= totalMoney %> </td></tr>
                <tr><td>Order Date:  <%= (new Date(System.currentTimeMillis())).toString() %></td></tr>
                <tr><td>Ship Date: N/A </td></tr>            
            </table>
                <section>
                    <form action="mainController" method="post">
                        <input type="submit" value="saveOrder" name="action" class="submitorder">
                    </form>
                </section>
        </section>
        
        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
