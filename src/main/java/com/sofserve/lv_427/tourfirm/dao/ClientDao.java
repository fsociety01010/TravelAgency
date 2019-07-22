package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
  private Connection connection;

  private static final String ID = "id";
  private static final String FIRST_NAME = "first_name";
  private static final String LAST_NAME = "last_name";
  private static final String PHONE_NUMBER = "phone_number";

  public ClientDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find and return all Clients from DB.
   *
   * @return list of cities.
   * @exception SQLException - error in sql query.
   */
  public List<Client> findAll() throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT * FROM travel_agency.client");

    ResultSet resultSet = preparedStatement.executeQuery();

    ArrayList<Client> clients = new ArrayList<>();
    while (resultSet.next()) {
      clients.add(
          new Client(
              resultSet.getInt(ID),
              resultSet.getString(FIRST_NAME),
              resultSet.getString(LAST_NAME),
              resultSet.getString(PHONE_NUMBER)));
    }
    return clients;
  }

  /**
   * Method that find and return client id by his firstName and lastName.
   *
   * @param firstName - client first name
   * @param lastName - client last name
   * @return list of cities.
   * @exception SQLException - error in sql query.
   */
  public int getClientId(String firstName, String lastName) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
            connection.prepareStatement("SELECT client.id FROM client WHERE first_name = ? AND last_name = ?");
    preparedStatement.setString(1, firstName);
    preparedStatement.setString(2, lastName);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with firstName " + firstName + "and lastName " + lastName);
    }
  }

  public Client getClient(int id) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
            connection.prepareStatement("SELECT client.* FROM client WHERE id = ?");
    preparedStatement.setInt(1, id);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return new Client(
              resultSet.getInt(ID),
              resultSet.getString(FIRST_NAME),
              resultSet.getString(LAST_NAME),
              resultSet.getString(PHONE_NUMBER));
    } else {
      throw new ClassNotFoundException("In DB no row with id " + id);
    }
  }
}
