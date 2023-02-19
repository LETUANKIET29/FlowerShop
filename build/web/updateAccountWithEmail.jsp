<%-- 
    Document   : updateAccountWithEmail
    Created on : Nov 6, 2022, 5:06:31 PM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css.css" type="text/css"/>
    </head>
    <body>
        <header>
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <form action="mainController" method="post">
            <table>
                <tr>
                    <td>input to change your name</td>
                    <td><input type="text" name="txtname" required=""></td>
                </tr>
                <tr>
                    <td>input to change your phone</td>
                    <td><input type="text" name="txtphone" required=""></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="updateProfile" name="action"></td>
                </tr>
                <tr style="font-size: 15px; color: red">
                    <td>${Mess}</td>
                </tr>
            </table>
        </form>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>      
    </body>
</html>
