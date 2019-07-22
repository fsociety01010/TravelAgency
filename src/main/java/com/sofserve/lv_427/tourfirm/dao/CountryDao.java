package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

  /**
   * Method that find and return id of country.
   *
   * @param name - country name
   * @return id of country
   * @exception SQLException - error in sql query.
   */
  public int getId(String name) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select id from country where " + COUNTRY_NAME + " = ?");
    preparedStatement.setString(1, name);
    ResultSet resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with name " + name);
    }
  }
  /**
   * Method that find and return all Visited Countries by Client from DB.
   *
   * @param clientId - Client ID
   * @return list of countries.
   * @exception SQLException - error in sql query.
   */
  public List<Country> getVisitedCountriesByClient(int clientId) throws SQLException {
    List<Country> countries = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    String date = dateFormat.format(cal.getTime());

    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT * FROM COUNTRY WHERE id IN "
                + "(SELECT country_id FROM city WHERE id IN "
                + "(SELECT city_id FROM hotel WHERE id IN "
                + "(SELECT hotel_id FROM room where id IN "
                + "(SELECT room_id from room_book where "
                + "(client_id = ? and order_end < ?)))))");
    preparedStatement.setInt(1, clientId);
    preparedStatement.setString(2, date);
    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
      countries.add(new Country(resultSet.getInt(ID), resultSet.getString(COUNTRY_NAME)));
    }
    return countries;
  }
}
