<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 28.11.18
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj wydarzenie nosework</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/main.css" rel="stylesheet"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/main.css" rel="stylesheet"/>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../../css/main.css" rel="stylesheet"/>

</head>
<body>
<form:form method="post" modelAttribute="event">
    <div class="container">
        <h3 class="header">Dodaj wydarzenie:</h3>
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="nameId"> Podaj pełną nazwę zawodów:</label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/><br/>
                    <form:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="cityId"> Podaj miasto:</label>
                    <form:input type="text" path="city" id="cityId" class="form-control"/>
                    <form:errors path="city" element="div" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="cityId"> Podaj adres zawodów:</label>
                    <form:input type="text" path="address" id="addressId" class="form-control"/>
                    <form:errors path="address" element="div" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="dateId"> Wybierz datę:</label>
                    <form:input type="date" path="competitionDate" id="dateId" class="form-control"/>
                    <form:errors path="competitionDate" element="div" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="descriptionId"> Podaj krótki opis zawodów:</label>
                    <form:textarea type="textarea" id="descriptionId" cols="35" rows="15" path="description"
                                   class="form-control"/><br/>
                    <form:errors path="description" cssClass="error"/>
                </div>
                <b>Zaznacz, jakie opcje będą dostępne:</b>
                <p class="form-group">
                    <label for="testId"></label>
                        <form:checkbox path="scentTests" id="testId" class="form-check-label"/>
                        <form:errors path="scentTests" cssClass="error"/>TESTY z cynamonu, pomarańczy, goździka
                <p></p><b>Dostępne kategorie zawodów:</b></p>
                <label for="containerId"></label>
                <form:checkbox path="containers" id="containerId" class="form-check-label"/>
                <form:errors path="containers" cssClass="error"/>POJEMNIKI

                <label for="exteriorId"></label>
                <form:checkbox path="exterior" id="exteriorId" class="form-check-label"/>
                <form:errors path="exterior" cssClass="error"/>TEREN

                <label for="interiorId"></label>
                <form:checkbox path="interior" id="interiorId" class="form-check-label"/>
                <form:errors path="interior" cssClass="error"/>POMIESZCZENIA

                <label for="vehicleId"></label>
                <form:checkbox path="vehicle" id="vehicleId" class="form-check-label"/>
                <form:errors path="vehicle" cssClass="error"/>POJAZDY

                <div class="form-group">
                    <label for="judgeId">Wybierz sędziego:</label>
                    <form:select path="judge" items="${judges}" itemLabel="fullName" itemValue="id" id="judgeId"
                                 class="form-control"/>
                    <form:errors path="judge" cssClass="error"/>
                </div>
            </div>
        </div>
        <input type="submit" class="btn btn-primary" value="Zapisz zawody"><br/>
    </div>
    </div>

</form:form>
</body>
</html>