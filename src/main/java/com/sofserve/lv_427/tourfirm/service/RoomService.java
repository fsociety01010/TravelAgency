package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
  List<Room> getAvailableRoomsByHotel(String startDate, String endDate, int hotelId)
      throws SQLException;

  int LoadingRoomsPeriode(String startDate, String endDate, int hotelId) throws SQLException;
}
