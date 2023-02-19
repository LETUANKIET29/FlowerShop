<%-- 
    Document   : login
    Created on : Oct 25, 2022, 3:35:01 PM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css">
    </head>
    <body>
        <!--phần đầu trang-->
        <header>
            <%@include file="header.jsp" %>
        </header>

        <section>    
            <div class="login">
                <h1 style="text-align: center">Login</h1>
                <form action="mainController" method="post">
                    <table style="border-width: 0">
                        <tr><td style="border-width: 0">Email</td></tr>
                        <tr><td style="border-width: 0"><input type="text" name="txtemail"></td></tr>

                        <tr><td style="border-width: 0">Password</td></tr>      
                        <tr><td style="border-width: 0"><input type="password" name="txtpassword"></td></tr>

                        <tr>
                            <td style="border-width: 0"><input type="submit" value="login" name="action" style="font-size: 1em"></td>                                
                        </tr>    
                        <tr>
                            <td style="border-width: 0">Stayed singed in<input type="checkbox" value="savelogin" name="action"></td>
                        </tr>         
                    </table>
                    <font style="color: red; border-width: 0;"><%= (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING")%></font>
                </form>
            </div>
        </section>

        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
