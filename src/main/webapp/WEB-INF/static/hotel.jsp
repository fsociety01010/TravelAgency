<%@ page import="com.sofserve.lv_427.tourfirm.model.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.dao.RoomDao" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.RoomService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.RoomServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.HotelService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.ClientService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl" %><%--
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
        ClientService clientService = new ClientServiceImpl();

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
    <% if ((session.getAttribute("start_date_hotel_stat") == null) && (session.getAttribute("end_date_hotel_stat") == null)) { %>
    <form action="/hotel1" method="post">
        <p>Отримати статистику за період</p>
        <p>Дата заїзду: <input type="date" name="start_date_hotel_stat"
                               value=
            <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>></p>
        <p>Дата виїзду: <input type="date" name="end_date_hotel_stat"
                               value=
            <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>></p>
        <button type="submit">Знайти</button>
    </form>

    <% } else {%>
    <p>За період <%=session.getAttribute("start_date_hotel_stat")%> до <%=session.getAttribute("end_date_hotel_stat")%>
    </p>
    <p>
        Кількість клієнтів: <%=hotelService.getClientCountForPeriod(
            hotelService.getHotelIdByName(session.getAttribute("hotel").toString()),
            session.getAttribute("start_date_hotel_stat").toString(),
            session.getAttribute("end_date_hotel_stat").toString()
    )%>
    </p>

    <p>
        Середній час
        бронювання: <%=hotelService.getAverageBookTime(hotelService.getHotelIdByName(session.getAttribute("hotel").toString()),
            session.getAttribute("start_date_hotel_stat").toString(),
            session.getAttribute("end_date_hotel_stat").toString())%> днів
    </p>

    <p>
        Завантаженість кімнат:
            <%
            for (int i = 0; i < roomService.getRoomCount(Integer.parseInt(session.getAttribute("hotelId").toString())); i++) {
                int[] roomsLoading = roomService.LoadingRoomsPeriod(
                        session.getAttribute("start_date_hotel_stat").toString(),
                        session.getAttribute("end_date_hotel_stat").toString(),
                        i+1);
        %>
    <p><%=i + 1%> кімната: <%=roomsLoading[0]%> / <%=roomsLoading[1]%></p>
    <%
        }
    %>
    </p>

    <%}%>
</div>
</body>
</html>
