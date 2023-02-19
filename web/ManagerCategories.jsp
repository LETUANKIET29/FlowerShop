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
            <table class="order" style="font-size: 16px;">
                <tr>
                    <th>Categories ID</th>
                    <th>Categories Name</th>
                </tr>

                
            <c:forEach var="categories" items="${requestScope.cateList}">
                <tr>
                    <td><c:out value="${categories.getCateID()}"></c:out></td>
                    <td><c:out value="${categories.getCateName()}"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
