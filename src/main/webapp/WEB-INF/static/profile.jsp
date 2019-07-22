<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 20.07.2019
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Профіль</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Мій профіль</h2>
    <select id="client">
        <option>Nazar Vladyka</option>
        <option>Agarkov</option>
        <option>Zakhar</option>
    </select>
    <h3>default_name default_surname</h3>
    <h3>default_phone_number</h3>
    <br>
    <h3>Відкриті візи default_list_of_client_visas</h3>
    <h3>Подорожував у default_list_of_visited_countries</h3>
</div>
</body>
</html>
