<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 30.11.18
  Time: 06:18
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
    <link rel="stylesheet" type="text/css" href="../..css/bootstrap.min.css">
    <%--<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">--%>
    <%--<link href='<c:url value="/css/main.css"/>' rel="stylesheet">--%>
</head>
<body>


<div class="container-fluid">

    <h3 class="header">Witaj na stronie ligi nosework!</h3>

    <div class="card border-danger mb-3" >
        <div class="card-body">
            <%@ include file="header.jspx"%>
            <p class="card-text">
            <h4>Lista aktualnych wydarzeń:</h4>
            <table class="table table-hover">
                <thead class="bg-danger">
                <tr>
                    <th>NAZWA</th>
                    <th>TESTY</th>
                    <th>ZAWODY</th>
                    <th>DATA</th>
                    <th>OPIS</th>
                    <th>MIEJSCE</th>
                    <th>SĘDZIUJE</th>
                    <th>LISTA STARTOWA/ WYNIKI</th>
                    <th>EDYTUJ</th>
                    <th>USUŃ</th>

                </tr></thead>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td>${event.name}</td>
                        <td><c:if test="${event.scentTests}">TAK: cynamon, pomarańcza, goździk</a>
                        </c:if>
                            <c:if test="${!event.scentTests}">BRAK</a>
                            </c:if></td>
                        <td>
                            <c:if test="${event.exams}">TAK</a>
                            </c:if>
                            <c:if test="${!event.exams}">BRAK</a>
                            </c:if>
                        </td>
                        <td>${event.competitionDate}</td>
                        <td>${event.description}</td>
                        <td>
                                ${event.city}
                        </td>
                        <td>${event.judge.fullName}</td>

                        <td><a href="admin/events/${event.id}/edit" class="btn btn-success">Edytuj wydarzenie</a></td>
                            <%--</c:if>--%>
                            <%--<c:if test="${!event.pastEvent}">--%>
                            <%--W przyszłości--%>
                            <%--</c:if>--%>
                        <td><a href="admin/events/${event.id}/result" class="btn btn-success">Wyniki</a></td>
                        <td><a href="admin/events/${event.id}/delete" class="btn btn-danger">Usuń wydarzenie</a></td>
                    </tr>
                </c:forEach>
            </table>

            <%@ include file="footer.jspx"%>
        </div>
    </div>
</div>


</body>
</html>
