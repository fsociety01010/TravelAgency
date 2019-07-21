package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.HotelDao;
import com.sofserve.lv_427.tourfirm.model.Hotel;
import com.sofserve.lv_427.tourfirm.service.HotelService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl implements HotelService {
  HotelDao dao;

  public HotelServiceImpl() throws SQLException, ClassNotFoundException {
    dao = new HotelDao(JdbcConnector.getConnection());
  }

  /**
   * Method that find all hotels available in City on dates.
   *
   * @param cityId - city ID
   * @param startDate - start booking
   * @param endDate - end booking
   * @return list of hotels.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Hotel> getAvailableHotelsInCity(int cityId, String startDate, String endDate)
      throws SQLException {
    List<Hotel> availableHotels = getAvailableHotelsOnDate(startDate, endDate);
    List<Hotel> availableHotelsInCity = new ArrayList<>();

    for (Hotel hotel : availableHotels) {
      if (hotel.getCityId() == cityId) {
        availableHotelsInCity.add(hotel);
      }
    }

    return availableHotelsInCity;
  }

  /**
   * Method that find all hotels available on dates.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @return list of hotels.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Hotel> getAvailableHotelsOnDate(String startDate, String endDate)
      throws SQLException {
    return dao.getAvailableHotelsOnDates(startDate, endDate);
  }

  @Override
  public int getHotelIdByName(String name) throws SQLException, ClassNotFoundException {
    return dao.getId(name);
  }
}
