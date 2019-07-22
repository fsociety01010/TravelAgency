package com.sofserve.lv_427.tourfirm.service;

import java.sql.SQLException;
import java.sql.SQLException;
import java.util.List;

import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.model.Visa;

public interface VisaService {

  int getVisaIdByName(String name) throws SQLException, ClassNotFoundException;

  int getCountVisaForCountry(int id) throws SQLException;

  int getVisasCountForTheClient(int clientId) throws SQLException;

  List<Visa> getVisasForTheClient(int clientId) throws SQLException;
}
