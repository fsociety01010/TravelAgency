package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelService {
  List<Hotel> getAvailableHotelsInCity(int cityId, String startDate, String endDate)
      throws SQLException;

  List<Hotel> getAvailableHotelsOnDate(String startDate, String endDate) throws SQLException;
  List<Hotel> getHotelsByCity(int cityId) throws SQLException;
}
