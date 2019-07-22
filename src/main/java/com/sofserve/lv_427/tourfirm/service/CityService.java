package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.City;

import java.sql.SQLException;
import java.util.List;

public interface CityService {
  List<City> getCityList() throws SQLException;

  List<City> citiesByCountry(int id) throws SQLException;

  List<City> getCityWithAvailableHotels(String startDate, String endDate, int countryId) throws SQLException;

  int getCityIdByName(String name) throws SQLException, ClassNotFoundException;
}