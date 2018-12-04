<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 29.11.18
  Time: 22:30
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
<body><div class="card border-danger mb-3">
    <div class="card-body">

        <div class="text-left">
            <p><a href="../admin/events" class="btn btn-warning" role="button"> Lista zawodów</a></p>
            <p><a href="../admin/addEvent" class="btn btn-warning" role="button"> Dodaj wydarzenie </a></p>
            <p><a href="../admin/addJudge" class="btn btn-warning" role="button"> Dodaj sędziego </a></p>
            <p><a href="../admin/addUser" class="btn btn-warning" role="button"> Dodaj użytkownika i psa </a></p>
            <p><a href="../events/add" class="btn btn-warning" role="button"> Lista sędziów</a></p>
            <p><a href="../events/add" class="btn btn-warning" role="button"> Lista użytkowników</a></p>
        </div>
    </div>
</div>
<%@ include file="footerAdmin.jspx"%>
</body>
</html>
