<%-- 
    Document   : ManageAccounts
    Created on : Nov 5, 2022, 2:35:25 AM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="mycss.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <c:import url="header_loginedAdmin.jsp"></c:import>
        
            <form action="mainController" method="post">
                <input type="text" name="orderId">
                <input type="submit" value="searchOrder" name="action">
            </form>
        
            <h1></h1>
            <table class="order" style="font-size: 16px">
                <tr>
                    <th>Order ID</th>
                    <th>Order date</th>
                    <th>Ship date</th>
                    <th>status</th>
                    <th>AccID</th>
                    <th>Action</th>
                </tr>
            <% 
                if(request.getParameter("orderId")==null){
                    %>
            <!-- hiện danh sách -->         
                    
            <c:forEach var="order" items="${requestScope.orderList}">
                <tr>
                    <td><c:out value="${order.getOrderID()}"></c:out></td>
                    <td><c:out value="${order.getOrderDate()}"></c:out></td>
                    <td><c:out value="${order.getShipDate()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${order.getStatus() eq 1}"><div style="color: orange">Process</div></c:when>
                            <c:when test="${order.getStatus() eq 3}"><div style="color: red">Cancel</div></c:when>
                            <c:otherwise><div style="color: green">Completed</div></c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${order.getAccID()}"></c:out></td>     

                        <td>
                            <c:url var="mylink" value="mainController">
                                <c:param name="orderid" value="${order.getOrderID()}"></c:param>
                                <c:param name="status" value="${order.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusOrder"></c:param>
                            </c:url>
                            <a href="${mylink}"> Change Status </a>
                        </td>                                     
                    </tr>
            </c:forEach>        
                    
            <c:forEach var="order" items="${requestScope.manageOrders}">
                <tr>
                    <td><c:out value="${order.getOrderID()}"></c:out></td>
                    <td><c:out value="${order.getOrderDate()}"></c:out></td>
                    <td><c:out value="${order.getShipDate()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${order.getStatus() eq 1}"><div style="color: orange">Process</div></c:when>
                            <c:when test="${order.getStatus() eq 3}"><div style="color: red">Cancel</div></c:when>
                            <c:otherwise><div style="color: green">Completed</div></c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${order.getAccID()}"></c:out></td>     

                        <td>
                            <c:url var="mylink" value="mainController">
                                <c:param name="orderid" value="${order.getOrderID()}"></c:param>
                                <c:param name="status" value="${order.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusOrder"></c:param>
                            </c:url>
                            <a href="${mylink}"> Change Status </a>
                        </td>                                     
                    </tr>
            </c:forEach>
                    <%
                }
            %>

            <!--dùng cho hàm search khi hàm search có dữ liệu trong thanh tìm kiếm-->
            <c:forEach var="order" items="${requestScope.searchOrderList}">
                <tr>
                    <td><c:out value="${order.getOrderID()}"></c:out></td>
                    <td><c:out value="${order.getOrderDate()}"></c:out></td>
                    <td><c:out value="${order.getShipDate()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${order.getStatus() eq 1}"><div style="color: orange">Process</div></c:when>
                            <c:when test="${order.getStatus() eq 3}"><div style="color: red">Cancel</div></c:when>
                            <c:otherwise><div style="color: green">Completed</div></c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${order.getAccID()}"></c:out></td>     

                        <td>
                            <c:url var="mylink" value="mainController">
                                <c:param name="orderid" value="${order.getOrderID()}"></c:param>
                                <c:param name="status" value="${order.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusOrder"></c:param>
                            </c:url>
                            <a href="${mylink}"> Change Status </a>
                        </td>                                     
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
