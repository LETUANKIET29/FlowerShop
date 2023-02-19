<%-- 
    Document   : header_loginedUser
    Created on : Oct 13, 2022, 12:02:50 AM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="personalPage.jsp">All order</a></li>
                <li><a href="updateAccountWithEmail.jsp">Change profile</a></li>
                <li><a href="completeOrder.jsp">completed orders</a></li>
                <li><a href="cancelOrder.jsp">Canceled orders</a></li>
                <li><a href="processingOrder.jsp">processing orders</a></li>
                <li>
                    <form action="mainController" method="get">
                        from<input  type="date" name="from" value="<%= (request.getParameter("from")==null)?"": request.getParameter("from")%>"> 
                        to <input type="date" name="to" value="<%= (request.getParameter("to")==null)?"": request.getParameter("to")%>">
                        <input type="submit" value="searchWithDate" name="action">   
                    </form>                
                </li>
            </ul>
        </nav>
    </body>
</html>
