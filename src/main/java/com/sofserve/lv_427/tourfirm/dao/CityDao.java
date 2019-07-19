package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.City;
import com.sofserve.lv_427.tourfirm.model.Client;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
  private Connection connection;

  //    public CityDao(Connection connection) {
  //        this.connection = connection;
  //    }

  public CityDao(Connection connection) throws SQLException, ClassNotFoundException {
    this.connection = connection;
  }

  private final String ID = "id";
  private final String CITY_NAME = "city_name";
  private final String COUNTRY_ID = "country_id";

  /**
   * Method that find and return all Exhibit from DB.
   *
   * @return list of clients.
   * @exception SQLException - error in sql query.
   */
  public List<City> findAll() throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select * from travel_agency.city");

    ResultSet resultSet = preparedStatement.executeQuery();

    ArrayList<City> cities = new ArrayList<>();
    while (resultSet.next()) {
      cities.add(
          new City(
              resultSet.getInt(ID), resultSet.getString(CITY_NAME), resultSet.getInt(COUNTRY_ID)));
    }
    return cities;
  }
}
