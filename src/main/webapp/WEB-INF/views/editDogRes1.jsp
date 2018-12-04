<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 30.11.18
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new team</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/main.css" rel="stylesheet"/>

    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/main.css" rel="stylesheet"/>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../../css/main.css" rel="stylesheet"/>
    <%--<link href='<c:url value="../css/bootstrap.min.css"/>' rel="stylesheet">--%>
    <%--<link href='<c:url value="../css/main.css"/>' rel="stylesheet">--%>

</head>
<body>
<form:form method="post" modelAttribute="dogResult">
    <div class="container">
        <h3 class="header">Podaj dane:</h3>
        <div class="card border-info mb-3">
            <div class="card-body">

                <%--<div class="form-group">--%>
                    <%--<label for="userNameId"> Imię</label>--%>
                    <%--<form:input type="text" path="dogResult.dog.user.firstName" id="userNameId" class="form-control"/>--%>
                    <%--<form:errors path="dogResult.dog.user.firstName" element="div" cssClass="error"/>--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="lastNameId"> Nazwisko:</label>--%>
                    <%--<form:input type="text" path="dogResult.dog.name" id="lastNameId" class="form-control"/><br/>--%>
                    <%--<form:errors path="dogResult.dog.name" cssClass="error"/>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label for="pointsId"> Email:</label>
                    <form:input type="number" path="dogResult.points" id="pointsId" class="form-control"/><br/>
                    <form:errors path="dogResult.points" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="placeId"> Miasto:</label>
                    <form:input type="number" path="dogResult.place" id="placeId" class="form-control"/><br/>
                    <form:errors path="dogResult.place" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-info" value="Wyślij"><br/>
            </div>
        </div>
    </div>

</form:form>
</body>
</html>
