<%-- 
    Document   : navBar
    Created on : 18 ene 2024, 2:02:50
    Author     : Zihao Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navBar.css"/>
    </head>
    <body>
        <div id="contentBar">
            <div id="navDirections">
                <a href="index.jsp">
                    <button type="button" id="navBarButton">Home</button>
                </a>
                <form action="SvTurn" method="get">
                    <button id="navBarButton">See appointments</button>
                </form>
            </div>
            <div>

            </div>
        </div>
    </body>
</html>
