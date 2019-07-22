<%@ page import="com.sofserve.lv_427.tourfirm.model.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.dao.RoomDao" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.RoomService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.RoomServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.HotelService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        <%=session.getAttribute("hotel")%>
    </title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Hotel "<%=session.getAttribute("hotel")%>"
    </h2>

    <% RoomService roomService = new RoomServiceImpl();
        HotelService hotelService = new HotelServiceImpl();

        List<Room> rooms = roomService.getAvailableRoomsByHotel(
                session.getAttribute("startDate").toString(),
                session.getAttribute("endDate").toString(),
                hotelService.getHotelIdByName(session.getAttribute("hotel").toString())
        );%>

    <p style="font-size: 12px;">
        Доступні кімнати для <b><%=session.getAttribute("client")%>
    </b>
        в <b><%=session.getAttribute("country")%>
    </b>,
        <b><%=session.getAttribute("city")%>
        </b>
        в період <b><%=session.getAttribute("startDate")%>
    </b>
        до <b><%=session.getAttribute("endDate")%>
    </b> :

        <%
            for (Room room : rooms) { %>
        <%=room.getRoomNumber()%>
        <% } %>
    </p>
</div>
</body>
</html>
