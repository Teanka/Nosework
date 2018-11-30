<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 29.11.18
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/main.css" rel="stylesheet"/>

    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/main.css" rel="stylesheet"/>
    <%--<link href='<c:url value="../css/bootstrap.min.css"/>' rel="stylesheet">--%>
    <%--<link href='<c:url value="../css/main.css"/>' rel="stylesheet">--%>

</head>
<body>
<form:form method="post" modelAttribute="judge">
    <div class="container">
        <h3 class="header">Dodaj sędziego do bazy:</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="nameId"> Imię</label>
                        <%--<form:hidden path="createdate" value="${book.createdate}"/>--%>
                    <form:input type="text" path="firstName" id="nameId" class="form-control"/>
                    <form:errors path="firstName" element="div" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="lastNameId"> Nazwisko:</label>
                    <form:input type="text" path="lastName" id="lastNameId" class="form-control"/><br/>
                    <form:errors path="lastName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="emailId"> Email:</label>
                    <form:input type="text" path="email" id="emailId" class="form-control"/><br/>
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="phoneId"> Telefon:</label>
                    <form:input type="text" path="phone" id="phoneId" class="form-control"/><br/>
                    <form:errors path="phone" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-info" value="Wyślij"><br/>
            </div>
        </div>
    </div>

</form:form>
</body>
</html>
