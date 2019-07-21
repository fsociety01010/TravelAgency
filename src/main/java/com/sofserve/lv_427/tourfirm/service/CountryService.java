package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
  List<Country> getCountryList() throws SQLException;

  Country findById(int id) throws SQLException, ClassNotFoundException;

  int getCountryIdByName(String name) throws SQLException, ClassNotFoundException;
}
