<%-- 
    Document   : seeYourAppointment
    Created on : 18 ene 2024, 12:34:25
    Author     : Zihao Wang
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.wangzihaopruebatecnica2.logic.Turn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/appointmentFilter.css"/>
    </head>
    <body>
        <jsp:directive.include file="fragments/navBar.jsp" />

        <div id="tableHead">
            <div class="tableHeadElement">
                ID
            </div>
            <hr>
            <div class="tableHeadElement">
                Name
            </div>
            <hr>
            <div class="tableHeadElement">
                Surname
            </div>
            <hr>
            <div class="tableHeadElement">
                Phone number
            </div>
            <hr>
            <div class="tableHeadElement">
                Gmail
            </div>
            <hr>
            <div class="tableHeadElement">
                Turn ID
            </div>
            <hr>
            <div class="tableHeadElement">
                Date
            </div>
            <hr>
            <div class="tableHeadElement">
                Procedure
            </div>
            <hr>
            <div class="tableHeadElement">
                Province
            </div>
            <hr>
            <div class="tableHeadElement">
                Office
            </div>
            <hr>
            <div class="tableHeadElement">
                Postal Code
            </div>
            <hr>
            <div class="tableHeadElement">
                Description
            </div>
            <hr>
            <div class="tableHeadElement">
                State
            </div>
        </div>
        <hr>
        <%
            List<Turn> listTurn = (List) request.getSession().getAttribute("filterList");
            for (Turn turn : listTurn) {
        %>
        <div id="tableBody">
            <div id="tableData">
                <div class="tableBodyElement"><%=turn.getUsers().getId()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getUsers().getName()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getUsers().getSurname()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getUsers().getPhoneNumber()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getUsers().getGmail()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getId()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getTurnDate()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getTurnProcedure()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getProvince()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getOffice()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getPostalCode()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getDescription()%></div>
                <hr>
                <div class="tableBodyElement"><%=turn.getTurnState()%></div>
            </div>
            <hr>
        </div>
        <%}%>
        <jsp:directive.include file="fragments/footer.html" />
    </body>
</html>
