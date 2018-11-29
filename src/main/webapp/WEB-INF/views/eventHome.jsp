<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 28.11.18
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/main.css" rel="stylesheet"/>

    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/main.css" rel="stylesheet"/>
</head>
<body>
<form:form method="post" modelAttribute="dogResult">
    <div class="container">
        <h3 class="header">Podaj dane:</h3>
        <div class="card border-info mb-3">
            <div class="card-body">
                <p> Jesteś w trakcie zapisywania się na zawody ${event.name}.</p>
                <p> ${event.description}.</p>
                <p> Pamiętaj, że w ciągu tygodnia należy uiścić opłatę startową 30 zł.</p>
                <div class="form-group">
                    <label for="emailId"> Email- koniecznie ten użyty przy rejestracji do bazy</label>
                    <form:input type="text" path="dog.user.email" id="emailId" class="form-control"/><br/>
                    <form:errors path="dog.user.email" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="nameId"> Imię psa:</label>
                    <form:input type="text" path="dog.name" id="nameId" class="form-control"/><br/>
                    <form:errors path="dog.name" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-info" value="Wyślij"><br/>
            </div>
        </div>
    </div>

</form:form>
</body>
</html>

