package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class CountryDao {
  private Connection connection;

  private static final String ID = "id";
  private static final String COUNTRY_NAME = "country_name";

  public CountryDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find and return all countries from DB.
   *
   * @return list of Country.
   * @exception SQLException - error in sql query.
   */
  public List<Country> findAll() throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT * FROM travel_agency.country");

    ResultSet resultSet = preparedStatement.executeQuery();

    ArrayList<Country> countries = new ArrayList<>();
    while (resultSet.next()) {
      countries.add(new Country(resultSet.getInt(ID), resultSet.getString(COUNTRY_NAME)));
    }
    return countries;
  }

  /**
   * Method that find country by id.
   *
   * @param id - country ID
   * @return list of Country.
   * @exception SQLException - error in sql query.
   */
  public Country findById(int id) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select * from country where " + ID + " = ?");
    preparedStatement.setInt(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return new Country(resultSet.getInt(ID), resultSet.getString(COUNTRY_NAME));
    } else {
      throw new ClassNotFoundException("In DB no row with id " + id);
    }
  }
}
