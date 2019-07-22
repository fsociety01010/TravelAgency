<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.VisaServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CountryService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.VisaService" %><%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 20.07.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Про нас</title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Про нас</h2>
    <p>На ринку уже понад <b>10</b> років.</p>
    <p><b>16</b> задоволених клієнтів</p>
    <br>

    <% CountryService countryService = new CountryServiceImpl();
        VisaService visaService = new VisaServiceImpl();

        List<Country> countries = countryService.getCountryList();
        for (Country country : countries) {
    %>
    <p>
        <%=visaService.getCountVisaForCountry(countryService.getCountryIdByName(country.getCountryName()))
        %>
        візи видано в
        <%=country.getCountryName()%>
    </p>
    <%
        }
    %>

</div>
</body>
</html>
