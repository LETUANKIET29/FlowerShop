<%-- 
    Document   : header_loginedAdmin
    Created on : Nov 5, 2022, 2:13:31 AM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="mycss.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <header>
            <ul>
                <li><a href="AdminIndex.jsp">Admin Page</a></li>
                <li><a href="mainController?action=manageAccounts">Manager Account</a></li>
                <li><a href="mainController?action=manageOrders">Manager Order</a></li>
                <li><a href="mainController?action=managePlants">Manager Plants</a></li>
                <li><a href="mainController?action=managerCategories">Manager Categories</a></li>
                <li>Welcome ${sessionScope.name} | <a href="mainController?action=logout">logout</a></li>
            </ul>
        </header>           
    </body>
</html>
