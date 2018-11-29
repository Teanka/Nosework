<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 28.11.18
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: teanka
  Date: 27.11.18
  Time: 13:25
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
    <%--<link href='<c:url value="../css/bootstrap.min.css"/>' rel="stylesheet">--%>
    <%--<link href='<c:url value="../css/main.css"/>' rel="stylesheet">--%>

</head>
<body>
<form:form method="post" modelAttribute="dog">
    <div class="container">
        <h3 class="header">Podaj dane:</h3>
        <div class="card border-info mb-3">
            <div class="card-body">

                <div class="form-group">
                    <label for="userNameId"> Imię</label>
                        <%--<form:hidden path="createdate" value="${book.createdate}"/>--%>
                    <form:input type="text" path="user.firstName" id="userNameId" class="form-control"/>
                    <form:errors path="user.firstName" element="div" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="lastNameId"> Nazwisko:</label>
                    <form:input type="text" path="user.lastName" id="lastNameId" class="form-control"/><br/>
                    <form:errors path="user.lastName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="emailId"> Email:</label>
                    <form:input type="text" path="user.email" id="emailId" class="form-control"/><br/>
                    <form:errors path="user.email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="cityId"> Miasto:</label>
                    <form:input type="text" path="user.city" id="cityId" class="form-control"/><br/>
                    <form:errors path="user.city" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="nameId"> Imię psa:</label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/><br/>
                    <form:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="officialNameId"> Imię rodowodowe (opcjonalnie)</label>
                    <form:input type="text" path="officialName" id="officialNameId" class="form-control"/><br/>
                    <form:errors path="officialName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="breedId"> Rasa</label>
                    <form:input type="text" path="breed" id="breedId" class="form-control"/><br/>
                    <form:errors path="breed" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="idNumberId"> Numer identyfikatora (CHIP/tatuaż)</label>
                    <form:input type="text" path="idNumber" id="idNumberId" class="form-control"/><br/>
                    <form:errors path="idNumber" cssClass="error"/>
                </div>
                <label for="sex"> Płeć: </label>
                Pies: <form:radiobutton path="gender" value="pies" id="sex"/>
                Suka: <form:radiobutton path="gender" value="suka" id="sex"/>
                <div class="form-group">
                    <label for="ageId"> Wiek:</label>
                    <form:input type="number" path="age" id="ageId" class="form-control"/><br/>
                    <form:errors path="age" cssClass="error"/>
                </div>

                <input type="submit" class="btn btn-info" value="Wyślij"><br/>
            </div>
        </div>
    </div>

</form:form>
</body>
</html>
