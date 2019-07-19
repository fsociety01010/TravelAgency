package com.sofserve.lv_427.tourfirm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sofserve.lv_427.tourfirm.model.Country;

public class CountryDao {
  private Connection connection;

  private final String ID = "id";
  private final String COUNTRY_NAME = "country_name";

  public CountryDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find and return all Exhibit from DB.
   *
   * @return list of Country.
   * @exception SQLException - error in sql query.
   */
  public List<Country> findAll() throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select * from travel_agency.country");

    ResultSet resultSet = preparedStatement.executeQuery();

    ArrayList<Country> countries = new ArrayList<>();
    while (resultSet.next()) {
      countries.add(new Country(resultSet.getInt(ID), resultSet.getString(COUNTRY_NAME)));
    }
    return countries;
  }
}
