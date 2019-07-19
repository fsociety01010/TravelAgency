package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.CountryDao;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class CountryServiseImpl {

  private CountryDao countryDao;

  public CountryServiseImpl() throws Exception {
    this.countryDao = new CountryDao(JdbcConnector.getConnection());
  }

  public List<Country> getCountryList() throws SQLException {
    return countryDao.findAll();
  }
}
