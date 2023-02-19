<%-- 
    Document   : header
    Created on : Oct 12, 2022, 10:31:51 PM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name ="viewport" content="width-device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="index.jsp"><img src="images/logo.jpg" id="logo" style="width: 80px; height: auto "</a></li>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="registration.jsp">Register</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="mainController?action=viewcart">View cart</a></li>
                    <li>                       
                        <form action="mainController" method="post" class="formsearch">
                            <input type="text" name="txtsearch"
                                   value="<%= (request.getParameter("txtsearch")==null)?"": request.getParameter("txtsearch")%>">
                            <select name ="searchby">
                                <option value="byname">by name</option>
                                <option value="bycate">by category</option>
                            </select>
                            <input type="submit" value="search" name="action">
                        </form> 

                        <!--
                        <form action="mainController" method="post" class="formsearch">
                        <input type="text" name="txtsearch" value="<%= (request.getParameter("txtsearch") == null) ? "" : request.getParameter("txtsearch")%>">
                        <select name ="searchby">
                            <option value="byname">by name</option>
                            <option value="bycate">by category</option>
                        </select>
                        <input type="submit" value="search" name="action">
                        </form>
                        -->
                    </li>
                </ul>
            </nav>
        </header>
    </body>
</html>
