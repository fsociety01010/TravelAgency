package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.VisaDao;
import com.sofserve.lv_427.tourfirm.model.Visa;
import com.sofserve.lv_427.tourfirm.service.VisaService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class VisaServiceImpl implements VisaService {
  private VisaDao visaDao;

  public VisaServiceImpl() throws SQLException, ClassNotFoundException {
    visaDao = new VisaDao(JdbcConnector.getConnection());
  }

  /**
   * @param countryId - id number of the country in a table
   * @return Count of visa for country
   * @throws SQLException
   */
  @Override
  public int getCountVisaForCountry(int countryId) throws SQLException {
    return visaDao.CountVisaForCountry(countryId);
  }
}
