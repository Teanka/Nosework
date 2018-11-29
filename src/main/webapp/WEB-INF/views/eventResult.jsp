<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 29.11.18
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>homepage</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/main.css">
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">
    <%--<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">--%>
    <%--<link href='<c:url value="/css/main.css"/>' rel="stylesheet">--%>
</head>
<body>

<h3 class="header">WYNIKI:</h3>
<div class="container-fluid">


<div class="card border-info mb-3">
<div class="card-body">
<%@ include file="header.jspx" %>
<%--<p class="card-text"> Wyniki:</p>--%>
<c:if test="${!empty containers}">
    <h3> Kategoria POJEMNIKI: </h3>
    <table class="table table-hover">
    <thead class="bg-light">
    <tr>
    <th>MIEJSCE</th>
    <th>PUNKTY</th>
    <th>IMIĘ</th>
    <th>PIES</th>
    <th>SĘDZIA</th>

    </tr>
    </thead>
    <c:forEach var="result" items="${containers}">
        <tr>
            <td>${result.place}</td>
            <td>${result.points}</td>
            <td>${result.dog.user.firstName}</td>
            <td>${result.dog.name}</td>
            <td>${result.event.judge.fullName}</td>
        </tr>
    </c:forEach>
    </c:if>
<c:if test="${!empty exterior}" >
    </table>
    <%--<p class="card-text"> Wyniki:</p>--%>
    <h3> Kategoria TEREN: </h3>
    <table class="table table-hover">
    <thead class="bg-light">
    <tr>
    <th>MIEJSCE</th>
    <th>PUNKTY</th>
    <th>IMIĘ</th>
    <th>PIES</th>
    <th>SĘDZIA</th>

    </tr>
    </thead>
    <c:forEach var="result" items="${exterior}">
        <tr>
            <td>${result.place}</td>
            <td>${result.points}</td>
            <td>${result.dog.user.firstName}</td>
            <td>${result.dog.name}</td>
            <td>${result.event.judge.fullName}</td>
        </tr>
    </c:forEach>
    </c:if>

    </table>
    <%--<p class="card-text"> Wyniki:</p>--%>
<c:if test="${!empty interior}" >
    <h3> Kategoria POMIESZCZENIA: </h3>
    <table class="table table-hover">
    <thead class="bg-light">
    <tr>
    <th>MIEJSCE</th>
    <th>PUNKTY</th>
    <th>IMIĘ</th>
    <th>PIES</th>
    <th>SĘDZIA</th>

    </tr>
    </thead>
    <c:forEach var="result" items="${interior}">
        <tr>
            <td>${result.place}</td>
            <td>${result.points}</td>
            <td>${result.dog.user.firstName}</td>
            <td>${result.dog.name}</td>
            <td>${result.event.judge.fullName}</td>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${!empty vehicle}">
        </table>
        <%--<p class="card-text"> Wyniki:</p>--%>
        <h3> Kategoria POJAZDY: </h3>
        <table class="table table-hover">
        <thead class="bg-light">
        <tr>
            <th>MIEJSCE</th>
            <th>PUNKTY</th>
            <th>IMIĘ</th>
            <th>PIES</th>
            <th>SĘDZIA</th>

        </tr>
        </thead>
        <c:forEach var="result" items="${vehicle}">
            <tr>
                <td>${result.place}</td>
                <td>${result.points}</td>
                <td>${result.dog.user.firstName}</td>
                <td>${result.dog.name}</td>
                <td>${result.event.judge.fullName}</td>
            </tr>
        </c:forEach>
    </c:if>

    </table>
    </table>
    <%--<p class="card-text"> Wyniki:</p>--%>
    <h3> Kategoria TESTY ZAPACHOWE: </h3>
    <table class="table table-hover">
    <thead class="bg-light">
    <tr>
    <th>ZALICZONE</th>
    <th>IMIĘ</th>
    <th>PIES</th>
    <th>SĘDZIA</th>

    </tr>
    </thead>
<c:if test="${!empty tests}" >
    <c:forEach var="result" items="${tests}">
        <tr>
            <td>
                <c:if test="${result.points eq 1}">
                    TAK
                </c:if>
                <c:if test="${result.points eq 0}">
                    NIE
                </c:if>
            </td>
            <td>${result.dog.user.firstName}</td>
            <td>${result.dog.name}</td>
            <td>${result.event.judge.fullName}</td>
        </tr>
    </c:forEach>
    </c:if>
    </table>
    <img align="center" width="600px" height="400px" src="../../images/Lala.jpg"/>

    <%@ include file="footer.jspx" %>
    </div>
    </div>
    </div>


    </body>
    </html>

