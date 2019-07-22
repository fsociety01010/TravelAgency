<%@ page import="com.sofserve.lv_427.tourfirm.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.ClientService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CountryService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.VisaService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.VisaServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Visa" %><%--
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
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Мій профіль</h2>

    <%
        ClientService clientService = new ClientServiceImpl();
        VisaService visaService = new VisaServiceImpl();
        CountryService countryService = new CountryServiceImpl();
        List<Client> clients = clientService.getClientList();
    %>

    <%
        if (session.getAttribute("profileId") == null) {
    %>
    <form action="/profile" method="post">
        <select name="client">
            <%
                for (Client client : clients) { %>
            <option><%=client.getFirstName() + " " + client.getLastName()%>
            </option>
            <% } %>
        </select>

        <button type="submit">Загрузити</button>
    </form>
    <% } else {
        Client client = clientService.getClient(Integer.parseInt(session.getAttribute("profileId").toString()));

    %> <h3><%=client.getFirstName() + " " + client.getLastName()%>
</h3>
    number: <%=client.getPhoneNumber()%>
    <p>Відвідав:
        <%
            List<Country> visitedCountries = countryService.getVisitedCountriesByClient(Integer.parseInt(session.getAttribute("profileId").toString()));
            for (Country country : visitedCountries) {
        %>
        <%=country.getCountryName()%>
        <%}%>
    </p>
    <p>Візи:
        <%
            List<Visa> visas = visaService.getVisasForTheClient(Integer.parseInt(session.getAttribute("profileId").toString()));
            session.setAttribute("profileId", null);
            for (Visa visa : visas) {
        %>
        <%=visa.getVisaName()%>
        <%}%>

    </p>

    <%
        }%>
</div>
</body>
</html>
