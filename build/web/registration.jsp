<%-- 
    Document   : registration
    Created on : Oct 25, 2022, 3:45:13 PM
    Author     : tuank
--%>

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
            <div class="regis" style="border-width: 0">
                <h1 style="text-align: center">Register</h1>
                <form action="mainController" method="post" class="form">         
                <table style="border-width: 0">
                    <tr><td style="border-width: 0">Email</td></tr>
                    <tr>            
                        <td style="border-width: 0"><input type="text" name="txtemail" required="" 
                                   pattern="^(\\w)+@(a-zA-Z]+([.](\\w)+){1,2}"
                                   value="<%= (request.getAttribute("txtemail") == null) ? "" : request.getAttribute("txtemail")%>"></td>
                    </tr>                  
                    <tr><td style="border-width: 0">Fullname</td></tr>
                    <tr>                   
                        <td style="border-width: 0"><input type="text" name="txtfullname" required=""
                                   value="<%= (request.getAttribute("txtfullname") == null) ? "" : request.getAttribute("txtfullname")%>"></td>
                    </tr>
                    
                    <tr><td style="border-width: 0">Password</td></tr>
                    <tr>                      
                        <td style="border-width: 0"><input type="text" name="txtpassword" required=""></td>
                    </tr>
                    
                    <tr><td style="border-width: 0">Phone</td></tr>
                    <tr>    
                        <td style="border-width: 0"><input type="tel" name="txtphone" pattern="[0-9]{1,10}"
                                   value="<%= (request.getAttribute("txtphone") == null) ? "" : request.getAttribute("txtphone")%>">
                        </td>                    
                    </tr>  
                    <tr><td style="color: red; border-width: 0; width: 200px;"><%= (request.getAttribute("ERROR") == null) ? "" : request.getAttribute("ERROR")%></td></tr>
                    <tr>
                        <td style="border-width: 0"><input type="submit" name="action" value="register"></td>
                    </tr>
                </table>
            </form>
            </div>
        </section>

        <!--phần cuối trang-->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
