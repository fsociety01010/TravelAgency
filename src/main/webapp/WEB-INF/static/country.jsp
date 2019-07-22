<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 21.07.2019
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Знайти готель</title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Знайти готель</h2>
    <form action="/country" method="post">
        <p style="font-size: 20px; padding-left: 20px;">Країна </p>
        <%--<select name="country">--%>
            <%--<%--%>
<%--//                List<Country> countries = new ClientServiceImpl().getAvailableCountry(session.getAttribute("clientId"));--%>
<%----%>
                <%--for (Country country : countries) { %>--%>
            <%--<option><%=country.getCountryName()%>--%>
            <%--</option>--%>
            <%--<% } %>--%>
        </select>
        <button type="submit">Знайти</button>
    </form>
</div>
</body>
</html>
