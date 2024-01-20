<%-- 
    Document   : seeAppointment
    Created on : 16 ene 2024, 16:53:53
    Author     : Zihao Wang
--%>

<%@page import="java.util.stream.Collectors"%>
<%@page import="java.time.LocalDate"%>
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
        <br/>
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
            <div class="tableHeadElement">
                Name
            </div>
            <div class="tableHeadElement">
                Surname
            </div>
            <div class="tableHeadElement">
                Phone number
            </div>
            <div class="tableHeadElement">
                Gmail
            </div>
            <div class="tableHeadElement">
                Turn ID
            </div>
            <div class="tableHeadElement">
                Date
            </div>
            <div class="tableHeadElement">
                Procedure
            </div>
            <div class="tableHeadElement">
                Province
            </div>
            <div class="tableHeadElement">
                Office
            </div>
            <div class="tableHeadElement">
                Postal Code
            </div>
            <div class="tableHeadElement">
                Description
            </div>
            <div class="tableHeadElement">
                State
            </div>
            <div class="space"></div>
        </div>
        <hr>
        <%
            List<Turn> listTurn = (List) request.getSession().getAttribute("turnList");
            List<Turn> filterListTurn = (List) request.getSession().getAttribute("filterList");
            if(filterListTurn==null||filterListTurn.isEmpty()){
                listTurn=(List) request.getSession().getAttribute("turnList");
            }else{
                listTurn=filterListTurn;
            }
            for (Turn turn : listTurn) {
        %>
        <div id="tableBody">
            <div id="tableData">
                <form action="SvEditTurn" method="post">
                    <div id="tableBodyElements">
                        <input class="tableBodyElement" value="<%=turn.getUsers().getId()%>" name="userId" maxlength="9" minlength="9" required/>
                        <input class="tableBodyElement" value="<%=turn.getUsers().getName()%>" name="name" maxlength="60" pattern="[A-Za-z]+" required/>
                        <input class="tableBodyElement" value="<%=turn.getUsers().getSurname()%>" name="surname" maxlength="60" pattern="[A-Za-z]+" required/>
                        <input class="tableBodyElement" value="<%=turn.getUsers().getPhoneNumber()%>" name="phoneNumber" maxlength="9" minlength="9" pattern="[0-9]+" required/>
                        <input class="tableBodyElement" value="<%=turn.getUsers().getGmail()%>" name="gmail" maxlength="60" required/>
                        <label class="tableBodyElement"><%=turn.getId()%></label>
                        <input type="date" class="tableBodyElement" value="<%=turn.getTurnDate()%>" name="date" min="<%=java.time.LocalDate.now()%>" required/>
                        <select name="procedure" id="procedure" class="tableBodyElement">
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
                                    proceduresList.removeIf(tempProc -> tempProc.contains(turn.getTurnProcedure()));
                            %>
                            <option value="<%=turn.getTurnProcedure()%>"><%=turn.getTurnProcedure()%></option>
                            <%for (String data : proceduresList) {%>
                            <option value="<%=data%>"><%=data%></option>
                            <%
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            %>
                        </select>
                        <select name="province" id="province" class="tableBodyElement">
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
                                    listProvincias.removeIf(tempProv -> tempProv.contains(turn.getProvince()));
                            %>
                            <option value="<%=turn.getProvince()%>"><%=turn.getProvince()%></option>
                            <%for (String data : listProvincias) {%>
                            <option value="<%=data%>"><%=data%></option>
                            <%
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            %>
                        </select>
                        <label class="tableBodyElement"><%=turn.getOffice()%></label>
                        <input class="tableBodyElement" value="<%=turn.getPostalCode()%>" name="postCode" maxlength="5" minlength="5" pattern="[0-9]+" required/>
                        <textarea class="tableBodyElement" name="description" maxlength="220" required><%=turn.getDescription()%></textarea>
                        <input type="hidden" class="tableBodyElement" value="<%=turn.getId()%>" name="turnId"/>
                        <select class="tableBodyElement" name="state" id="state">
                            <option value="<%=turn.getTurnState()%>"><%=turn.getTurnState()%></option>
                            <option value="<%=turn.getTurnState().equals("on hold") ? "already processed" : "on hold"%>"><%=turn.getTurnState().equals("on hold") ? "already processed" : "on hold"%></option>
                        </select>
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
