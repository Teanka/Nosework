<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 27.11.18
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <script>
        function confirmDelete(id, fullName) {
            if (confirm("Do you really want to delete " + fullName + "\"")) {
                window.location.href = "/user/delete/" + id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 class="header">lista zawodników nosework</h3>

    <div class="card">
        <div class="card-body">
            <table class="table table-hover" border="1px solid black">
                <thead class="bg-warning">
                <tr>
                    <th>Imię i nazwisko</th>
                    <th>email</th>
                    <th>miasto</th>
                    <th>Pies</th>
                    <th>Dodaj psa</th>
                </tr>
                </thead>
                <tbody>



                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>${user.city}</td>
                        <td>
                            <a href="#" onclick="confirmDelete(${user.id}, '${user.fullName}')"class="btn btn-danger">Usuń</a>
                        </td>
                            <%--<td><a href="/book/delete/${book.id}" onclick=""confirmDelete(${book.id} ${book.title}>Delete</a></td>--%>
                        <td><a href="/author/edit/${user.id}" class="btn btn-success">Edytuj</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
