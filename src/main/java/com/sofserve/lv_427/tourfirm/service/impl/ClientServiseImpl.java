package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.ClientDao;
import com.sofserve.lv_427.tourfirm.model.Client;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class ClientServiseImpl {

  ClientDao clientDao;

  public ClientServiseImpl(ClientDao clientDao) throws Exception {
    this.clientDao = new ClientDao(JdbcConnector.getConnection());
  }

  public List<Client> getClientList() throws SQLException {
    return clientDao.findAll();
  }
}
