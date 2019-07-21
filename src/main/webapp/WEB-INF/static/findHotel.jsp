<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 20.07.2019
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Знайти готель</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Знайти готель</h2>

<h3>Клієнт</h3>
<select id="client">
    <option>Nazar Vladyka</option>
    <option>Agarkov Oleksandr</option>
    <option>Zakhar</option>
</select>

<h3>Дата заїзду</h3>
<input type="date" id="start_date" name="trip-start"
       value="2019-07-20">

<h3>Дата виїзду</h3>
<input type="date" id="end_date" name="trip-end"
       value="2019-07-28">
<br>
<br>
<button type="submit">Знайти</button>
</body>
</html>
