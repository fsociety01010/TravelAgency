package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.ClientDao;
import com.sofserve.lv_427.tourfirm.model.Client;
import com.sofserve.lv_427.tourfirm.service.ClientService;
import com.sofserve.lv_427.tourfirm.service.CountryService;
import com.sofserve.lv_427.tourfirm.service.VisaService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
  private ClientDao dao;
  private VisaService visaService;
  private CountryService countryService;


  public ClientServiceImpl() throws SQLException, ClassNotFoundException {
    dao = new ClientDao(JdbcConnector.getConnection());
    visaService = new VisaServiceImpl();
    countryService = new CountryServiceImpl();
  }

  /**
   * Method that find all clients.
   *
   * @return list of clients.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Client> getClientList() throws SQLException {
    return dao.findAll();
  }

  /**
   * Method that find all countries in which client has visa.
   *
   * @return list of countries.
   * @exception SQLException - error in sql query.
   */
//  public List<Country> getAvailableCountries(int clientId)
// throws SQLException, ClassNotFoundException {
//    List<Country> countries = new ArrayList<>();
//    List<Visa> visas = visaService.getVisas(clientId);
//
//    for(Visa visa : visas) {
//      countries.add(countryService.findById(visa.getCountryId()));
//    }
//
//    return countries;
//  }
}
