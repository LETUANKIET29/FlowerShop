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
                <input type="text" name="plantId">
                <input type="submit" value="searchPlant" name="action">
                <input type="submit" value="AddPlant" name="action">
                <input type="submit" value="UpdatePlant" name ="action">
            </form>
            
            <h1></h1>
            <table class="order" style="font-size: 16px">
                <tr>
                    <th>Plant ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>description</th>
                    <th>status</th>
                    <th>action</th>
                </tr>
                
            <c:forEach var="plant" items="${requestScope.searchPlantList}">
                <tr>
                    <td><c:out value="${plant.getId()}"></c:out></td>
                    <td><c:out value="${plant.getName()}"></c:out></td>
                    <td><c:out value="${plant.getPrice()}"></c:out></td>
                    <td><c:out value="${plant.getDescription()}"></c:out></td>
                    <td><c:choose>
                            <c:when test="${plant.getStatus() eq 1}"><div style="color: green">Stocking</div></c:when>
                            <c:otherwise><div style="color: red">Out of stock</div></c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:url var="mylink" value="mainController">
                            <c:param name="Pid" value="${plant.getId()}"></c:param>
                            <c:param name="status" value="${plant.getStatus()}"></c:param>
                            <c:param name="action" value="updateStatusPlant"></c:param>
                        </c:url>
                        <a href="${mylink}">Change status</a>              
                    </td>
                </tr>
            </c:forEach>    
                
        </table>
    </body>
</html>
