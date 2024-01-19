<%-- 
    Document   : index
    Created on : 16 ene 2024, 15:50:15
    Author     : Zihao Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Manager</title>
        <link rel="stylesheet" href="css/indexStyle.css"/>
    </head>
    <body>
        <jsp:directive.include file="fragments/navBar.jsp" />
        <div class="container">
            <h1>Enter User</h1>
            <div class="container2">
        <form action="SvUser" method="post">
            <div id="formIndex" class="formIndex">
             <div>
                <label for="id">ID :</label>
                <input type="text" class="form-control" id="id" name="id" maxlength="9" minlength="9" required/>
            </div>
            <br>
            <div>
                <label for="name">Name :</label>
                <input type="text" class="form-control" id="name" name="name" maxlength="60" pattern="[A-Za-z]+" required/>
            </div>
            <br>
            <div>
                <label for="lastName">Surname :</label>
                <input type="text" class="form-control" id="surname" name="surname" maxlength="60" pattern="[A-Za-z]+" required/>
            </div>
            <br>
            <div>
                <label for="phoneNumber">Phone number :</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" maxlength="9" minlength="9" pattern="[0-9]+" required/>
            </div>
            <br>
            <div>
                <label for="gmail">Gmail :</label>
                <input type="text" class="form-control" id="gmail" name="gmail" maxlength="60" required/>
            </div>
            <br>
            <button type="submit" class="button">Enter</button>
            </div>
        </form>
        </div>
        </div>
        <jsp:directive.include file="fragments/footer.html" />
    </body>
</html>
