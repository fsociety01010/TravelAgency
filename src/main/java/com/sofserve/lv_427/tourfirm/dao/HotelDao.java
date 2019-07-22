package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
  private Connection connection;

  private static final String ID = "id";
  private static final String HOTEL_NAME = "hotel_name";
  private static final String CITY_ID = "city_id";

  public HotelDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find all available hotels in a city.
   *
   * @param cityId - id of the city
   * @return list of hotels in city
   * @exception SQLException - error in sql query.
   */
  public List<Hotel> getHotelsByCity(int cityId) throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("SELECT  hotel.* from hotel WHERE " + CITY_ID + "= ?");
    preparedStatement.setInt(1, cityId);

    ResultSet resultSet = preparedStatement.executeQuery();

    List<Hotel> hotels = new ArrayList<>();
    while (resultSet.next()) {
      hotels.add(
          new Hotel(
              resultSet.getInt(ID), resultSet.getString(HOTEL_NAME), resultSet.getInt(CITY_ID)));
    }
    return hotels;
  }

  /**
   * Method that find all available hotels in DB on dates.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @return list of Country.
   * @exception SQLException - error in sql query.
   */
  public List<Hotel> getAvailableHotelsOnDates(String startDate, String endDate)
      throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT DISTINCT hotel.* from hotel "
                + "WHERE hotel.id IN "
                + "(SELECT room.hotel_id FROM room WHERE room.id NOT IN "
                + "(SELECT room_book.room_id FROM room_book "
                + "WHERE ((order_start > ? AND order_start < ?) OR (order_start < ? AND order_end > ?) OR (order_end > ? AND order_end < ?))))");
    preparedStatement.setString(1, startDate);
    preparedStatement.setString(2, endDate);
    preparedStatement.setString(3, startDate);
    preparedStatement.setString(4, endDate);
    preparedStatement.setString(5, startDate);
    preparedStatement.setString(6, endDate);

    ResultSet resultSet = preparedStatement.executeQuery();

    List<Hotel> hotels = new ArrayList<>();
    while (resultSet.next()) {
      hotels.add(
          new Hotel(
              resultSet.getInt(ID), resultSet.getString(HOTEL_NAME), resultSet.getInt(CITY_ID)));
    }
    return hotels;
  }

  /**
   * Method that find and return id of hotel.
   *
   * @param name - hotel name
   * @return id of hotel
   * @exception SQLException - error in sql query.
   */
  public int getId(String name) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select id from hotel where " + HOTEL_NAME + " = ?");
    preparedStatement.setString(1, name);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with name " + name);
    }
  }
}
