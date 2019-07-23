package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
  List<Room> getAvailableRoomsByHotel(String startDate, String endDate, int hotelId)
      throws SQLException;

  int[] LoadingRoomsPeriod(String startDate, String endDate, int roomId) throws SQLException;

  int getRoomIdByNumber(int number, int hotelId) throws SQLException, ClassNotFoundException;

  int getRoomCount(int hotelId) throws SQLException;
}
