package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.CountryDao;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.service.CountryService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class CountryServiceImpl implements CountryService {
  private CountryDao countryDao;

  public CountryServiceImpl() throws SQLException, ClassNotFoundException {
    countryDao = new CountryDao(JdbcConnector.getConnection());
  }

  /**
   * Method that find all countries.
   *
   * @return list of countries.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Country> getCountryList() throws SQLException {
    return countryDao.findAll();
  }

  /**
   * Method that find country by id.
   *
   * @return Country.
   * @exception SQLException - error in sql query.
   */
  @Override
  public Country findById(int id) throws SQLException, ClassNotFoundException {
    return countryDao.findById(id);
  }
}
