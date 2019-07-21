package com.sofserve.lv_427.tourfirm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisaDao {
  private Connection connection;

  private static final String ID = "id";
  private static final String VISA_NAME = "visa_name";
  private static final String COUNTRY_ID = "country_id";
  private static final String CLIENT_ID = "client_id";

  public VisaDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find a count of visas for the country
   * @param countryId - id number of the country in a table
   * @return Count of visa for country
   * @throws SQLException
   */
  public int CountVisaForCountry(int countryId) throws SQLException {
    int count = 0;
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT COUNT(id) FROM visa AS COUNT " + " WHERE " + COUNTRY_ID + " = ?");
    preparedStatement.setInt(1, countryId);

    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      count = resultSet.getInt("COUNT(id)");
    }
    return count;
  }
}
