<%-- 
    Document   : createAppointment
    Created on : 16 ene 2024, 18:14:15
    Author     : Zihao Wang
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <link rel="stylesheet" href="css/createAppointment.css"/>
    </head>
    <body>
        <jsp:directive.include file="fragments/navBar.jsp" />
        <div id="container">
            <form action="SvTurn" method="post" id="createForm">
                <div id="container2">
                    <div id="firstPartForm">
                            <label>Procedure</label>
                            <select name="procedure" id="procedure">
                                <%
                                    try {
                                        ObjectMapper objectManager = new ObjectMapper();
                                        String filePath = getServletContext().getRealPath("/JSON/Procedures.json");
                                        JsonNode jsonNode = objectManager.readTree(new File(filePath));
                                        JsonNode procedures = jsonNode.path("Procedures");
                                        List<String> proceduresList = new ArrayList<>();
                                        Iterator<JsonNode> iterator = procedures.elements();
                                        while (iterator.hasNext()) {
                                            proceduresList.add(iterator.next().asText());
                                        }
                                        for (String data : proceduresList) {
                                %>
                                <option value="<%=data%>"><%=data%></option>
                                <%
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </select>
                    </div>
                    <div id="secondPartForm">
                        <div class="alignCenter">
                            <label>Date</label><input type="date" name="date" min="<%=java.time.LocalDate.now()%>" required/>
                        </div>
                        <div class="alignCenter">
                            <label>Province :</label>
                            <select name="province" id="province" onchange="getProvince()">
                                <%
                                    List<String> listProvincias = new ArrayList<>();
                                    try {
                                        ObjectMapper objectMapper = new ObjectMapper();
                                        File file = new File(getServletContext().getRealPath("/JSON/Provinces.json"));
                                        JsonNode jsonNode = objectMapper.readTree(file);
                                        JsonNode jsonProvinces = jsonNode.path("Spain").path("Provinces");
                                        Iterator<JsonNode> iterator = jsonProvinces.elements();
                                        while (iterator.hasNext()) {
                                            listProvincias.add(iterator.next().asText());
                                        }
                                        for (String data : listProvincias) {
                                %>
                                <option value="<%=data%>"><%=data%></option>
                                <%
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                %>
                            </select>
                        </div>
                            <div class="alignCenter">
                            <label>Office :</label>
                            <select name="office" id="office">
                                <%
                                    try {
                                        ObjectMapper objectMapper = new ObjectMapper();
                                        File file = new File(getServletContext().getRealPath("/JSON/Office.json"));
                                        JsonNode jsonNode = objectMapper.readTree(file);
                                        String provincePath = request.getParameter("provinceValue");
                                        JsonNode jsonOffice = jsonNode.path("Office").path(provincePath);
                                        Iterator<JsonNode> iterator = jsonOffice.elements();
                                        List<String> listOffice = new ArrayList<>();
                                        while (iterator.hasNext()) {
                                            listOffice.add(iterator.next().asText());
                                        }
                                        for (String data : listOffice) {
                                %>
                                <option value="<%=data%>"><%=data%></option>
                                <%
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }%>
                            </select>
                        </div>
                        <div class="alignCenter">
                            <label>Postal Code :</label><input type="text" name="postalCode" maxlength="5" minlength="5" pattern="[0-9]+" required/>
                        </div>
                    </div>
                    <div id="thirdPartForm">
                        <label>Description : </label><textArea name="description" rows="20" cols="100" maxlength="220" required></textarea>
                </div>
                    <button type="submit" id="createTurnSubmit">Submit</button>
                </div>
            </form>
        </div>
        <jsp:directive.include file="fragments/footer.html" />
        <script src="${pageContext.request.contextPath}/javascript/createAppointmentFunctions.js" type="text/javascript"></script>
    </body>
</html>
