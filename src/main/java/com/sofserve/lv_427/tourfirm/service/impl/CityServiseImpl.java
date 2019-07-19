package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.CityDao;
import com.sofserve.lv_427.tourfirm.model.City;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class CityServiseImpl {
  CityDao cityDao;

  public CityServiseImpl() throws SQLException, ClassNotFoundException {
    this.cityDao = new CityDao(JdbcConnector.getConnection());
  }

  public List<City> getCityList() throws SQLException {
    return cityDao.findAll();
  };

  public List<City> citiesByCountry() throws SQLException {
    return cityDao.findAllByCountryID(12);
  }
}
