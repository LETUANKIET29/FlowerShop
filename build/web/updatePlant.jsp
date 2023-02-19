<%-- 
    Document   : updatePlant
    Created on : Nov 10, 2022, 7:50:53 AM
    Author     : tuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <c:import url="header_loginedAdmin.jsp"></c:import>
        </header>
        
        <form>
            <table>
                <tr><td>Plant ID</td><td><input type="text" name="PID"></td></tr>
                <tr><td>Name Plant</td><td><input type="text" name="PName"></td></tr>
                <tr><td>Price </td><td><input type="text" name="Price"></td></tr>
                <tr><td>img Path</td><td><input type="text" name="imgPath"></td></tr>
                <tr><td>Description</td><td><input type="text" name="Description"></td></tr>
                <tr><td>Status</td>
                    <td>
                            <input type="radio" id="html" name="Status" value="1">
                            <label for="1">Stock</label>
                            <input type="radio" id="css" name="Status" value="2">
                            <label for="2">Out of Stock</label>
                    </td>
                </tr> 
                <tr><td>Categories ID</td>
                    <td><input type="text" name="CateID" placeholder="ID from 1 to 8"></td>
                </tr>
                <tr><td><input type="submit" name="action" value="SaveUpdatePlant"</td></tr>
            </table>
        </form>
        
        <footer>
            <c:import url="footer.jsp"></c:import>
        </footer>
    </body>
</html>
