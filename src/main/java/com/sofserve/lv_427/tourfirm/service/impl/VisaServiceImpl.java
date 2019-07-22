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

}
