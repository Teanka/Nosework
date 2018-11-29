<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <%--<p> Jesteś w trakcie zapisywania się na zawody ${event.name}.</p>--%>
                    <%--<p> ${event.description}.</p>--%>
                <p> Jesteś w trakcie zapisywania się na zawody ${dogResult.event.name}.</p>
                <p> ${dogResult.event.description}.</p>
                <p class="font-weight-bold"> Pamiętaj, że w ciągu tygodnia należy uiścić opłatę startową 30zł, nr konta
                    otrzymasz w emailu potwierdzającym.</p>
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
                <b>Zaznacz, na co chcesz się zapisać, wybierz 1 z dostępnych opcji:</b>
                <div class="form-group">

                    <label for="competitionTypeId"></label>
                        <c:if test="${dogResult.event.scentTests}">
                        <form:radiobutton path="competitionType" value="scentTests" id="competitionTypeId"/>Testy
                    zapachowe (cynamon, pomarańcza, goździk)
                        </c:if>
                    <c:if test="${dogResult.event.containers}">
                        <form:radiobutton path="competitionType" value="containers" id="competitionTypeId"/>Zawody
                    kategoria POJEMNIKI
                    </c:if>
                    <c:if test="${dogResult.event.exterior}">
                        <form:radiobutton path="competitionType" value="exterior" id="competitionTypeId"/>Zawody
                    kategoria TEREN
                    </c:if>
                    <c:if test="${dogResult.event.interior}">
                        <form:radiobutton path="competitionType" value="interior" id="competitionTypeId"/>Zawody
                    kategoria POMIESZCZENIA
                    </c:if>
                    <c:if test="${dogResult.event.vehicle}">
                        <form:radiobutton path="competitionType" value="vehicle" id="competitionTypeId"/>Zawody
                    kategoria POJAZDY
                    </c:if>
                </div>
            </div>
        </div>
        <input type="submit" class="btn btn-info" value="Zapisz się"><br/>
    </div>

</form:form>
</body>
</html>

