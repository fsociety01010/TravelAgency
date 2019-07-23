package com.sofserve.lv_427.tourfirm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sofserve.lv_427.tourfirm.dao.VisaDao;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.model.Visa;
import com.sofserve.lv_427.tourfirm.service.VisaService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

public class VisaServiceImpl implements VisaService {
  VisaDao dao;

  public VisaServiceImpl() throws SQLException, ClassNotFoundException {
    this.dao = new VisaDao(JdbcConnector.getConnection());
  }

  /**
   * Method count client visas
   *
   * @param clientId - client ID
   * @return number of clients visas
   * @exception SQLException - error in sql query.
   */
  @Override
  public int getVisasCountForTheClient(int clientId) throws SQLException {
    return dao.getVisasCountForTheClient(clientId);
  }

  /**
   * Method that find and return all client visas in DB.
   *
   * @param clientId - client ID
   * @return list of visas
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Visa> getVisasForTheClient(int clientId) throws SQLException {
    return dao.getVisasForTheClient(clientId);
  }

  /**
   * Method that find visa id by his name.
   *
   * @param name - visa name
   * @return id of visa.
   * @exception SQLException - error in sql query.
   * @exception ClassNotFoundException - error if visa wasn't find.
   */
  @Override
  public int getVisaIdByName(String name) throws SQLException, ClassNotFoundException {
    return dao.getId(name);
  }

  /**
   * @param countryId - id number of the country in a table
   * @return Count of visa for country
   * @throws SQLException
   */
  @Override
  public int getCountVisaForCountry(int countryId) throws SQLException {
    return dao.CountVisaForCountry(countryId);
  }
}
