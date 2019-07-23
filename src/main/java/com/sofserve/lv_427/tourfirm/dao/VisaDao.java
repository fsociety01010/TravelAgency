package com.sofserve.lv_427.tourfirm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sofserve.lv_427.tourfirm.model.Visa;

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
   * Method that find and return id of visa.
   *
   * @param name - visa name
   * @return id of visa
   * @exception SQLException - error in sql query.
   */
  public int getId(String name) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select id from visa where " + VISA_NAME + " = ?");
    preparedStatement.setString(1, name);
    ResultSet resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with visa_name " + name);
    }
  }

  /**
   * Method count client visas
   *
   * @param clientId - client ID
   * @return number of clients visas
   * @exception SQLException - error in sql query.
   */
  public int getVisasCountForTheClient(int clientId) throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT COUNT(ID) FROM visa WHERE client_Id = ?");
    preparedStatement.setInt(1, clientId);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    return resultSet.getInt(1);
  }

  /**
   * Method that find and return all client visas in DB.
   *
   * @param clientId - client ID
   * @return list of visas
   * @exception SQLException - error in sql query.
   */
  public List<Visa> getVisasForTheClient(int clientId) throws SQLException {
    List<Visa> visas = new ArrayList<>();
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT * FROM visa WHERE client_Id = ?");
    preparedStatement.setInt(1, clientId);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      visas.add(
          new Visa(
              resultSet.getInt(ID),
              resultSet.getString(VISA_NAME),
              resultSet.getInt(COUNTRY_ID),
              resultSet.getInt(CLIENT_ID)));
    }

    return visas;
  }

  /**
   * Method that find a count of visas for the country
   *
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
