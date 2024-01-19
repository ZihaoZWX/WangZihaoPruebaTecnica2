<%-- 
    Document   : seeAppointment
    Created on : 16 ene 2024, 16:53:53
    Author     : Zihao Wang
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="java.io.File"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.wangzihaopruebatecnica2.logic.Turn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See appointment</title>
        <link rel="stylesheet" href="css/seeAppointment.css"/>
    </head>
    <body>
        <jsp:directive.include file="fragments/navBar.jsp" />
        <br>
        <form method="get" action="SvDateFilter">
            <input type="date" name="date"/>
            <select name="state">
                <option value="on hold">on hold</option>
                <option value="already processed">already processed</option>
            </select>
            <button type="submit" id="searchButton">Search</button>
        </form>
        <br/>
        <hr>
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
            <div class="space"></div>
            <hr>
        </div>
        <hr>
        <%
            List<Turn> listTurn = (List) request.getSession().getAttribute("turnList");
            for (Turn turn : listTurn) {
        %>
        <div id="tableBody">
            <div id="tableData">
                <form action="SvEditTurn" method="post">
                <div id="tableBodyElements">
                <label class="tableBodyElement"><%=turn.getUsers().getId()%></label>
                <hr>
                <input class="tableBodyElement" value="<%=turn.getUsers().getName()%>" name="name" maxlength="60" pattern="[A-Za-z]+" required/>
                <hr>
                <input class="tableBodyElement" value="<%=turn.getUsers().getSurname()%>" name="surname" maxlength="60" pattern="[A-Za-z]+" required/>
                <hr>
                <input class="tableBodyElement" value="<%=turn.getUsers().getPhoneNumber()%>" name="phoneNumber" maxlength="9" minlength="9" pattern="[0-9]+" required/>
                <hr>
                <input class="tableBodyElement" value="<%=turn.getUsers().getGmail()%>" name="gmail" maxlength="60" required/>
                <hr>
                <label class="tableBodyElement"><%=turn.getId()%></label>
                <hr>
                <input type="date" class="tableBodyElement" value="<%=turn.getTurnDate()%>" name="date" min="<%=java.time.LocalDate.now()%>" required/>
                <hr>
                <label class="tableBodyElement"><%=turn.getTurnProcedure()%></label>
                <hr>
                <label class="tableBodyElement"><%=turn.getProvince()%></label>
                <hr>
                <label class="tableBodyElement"><%=turn.getOffice()%></label>
                <hr>
                <input class="tableBodyElement" value="<%=turn.getPostalCode()%>" name="postCode" maxlength="5" minlength="5" pattern="[0-9]+" required/>
                <hr>
                <textarea class="tableBodyElement" name="description" maxlength="220" required><%=turn.getDescription()%></textarea>
                <hr>
                <input type="hidden" class="tableBodyElement" value="<%=turn.getId()%>" name="turnId"/>
                <select class="tableBodyElement" name="state" id="state">
                    <option value="<%=turn.getTurnState()%>"><%=turn.getTurnState()%></option>
                    <option value="<%=turn.getTurnState().equals("on hold") ? "already processed" : "on hold"%>"><%=turn.getTurnState().equals("on hold") ? "already processed" : "on hold"%></option>
                </select>
                <hr>
                <div class="centerButton">
                    <button type="submit" class="button">Edit</button>
                </div>
                </div>
                </form>
                <div id="tableButtons">
                <form action="SvDeleteTurn" method="post">
                        <input type="hidden" value="<%=turn.getId()%>" name="turnId"/>
                        <button type="submit" class="button">Delete</button>
                </form>
                </div>
            </div>
            <hr>
        </div>
        <%}%>
        <jsp:directive.include file="fragments/footer.html" />
        <script src="${pageContext.request.contextPath}/javascript/enableSelect.js" type="text/javascript"></script>
    </body>
</html>
