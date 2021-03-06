package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelService {
  List<Hotel> getAvailableHotelsInCity(int cityId, String startDate, String endDate)
      throws SQLException;

  List<Hotel> getAvailableHotelsOnDate(String startDate, String endDate) throws SQLException;

  List<Hotel> getHotelsByCity(int cityId) throws SQLException;

  int getHotelIdByName(String name) throws SQLException, ClassNotFoundException;

  int getAverageBookTime(int hotel_id, String dateStart, String dateEnd) throws SQLException;

  int getClientCountForPeriod(int hotel_id, String dateStart, String dateEnd) throws SQLException;

  List<Hotel> getAllHotels() throws SQLException;
}
