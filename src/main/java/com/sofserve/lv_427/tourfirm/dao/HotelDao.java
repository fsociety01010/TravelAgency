package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

  /**
   * Method that count hotel clients for period from DB.
   *
   * @param hotel_id - hotel ID
   * @param dateStart - first day of period
   * @param dateEnd - last day of period
   * @return number of clients for period.
   * @exception SQLException - error in sql query.
   */
  public int getClientCountForPeriod(int hotel_id, String dateStart, String dateEnd)
      throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT COUNT(client_id) FROM room_book_archive WHERE "
                + "(order_start >= ? AND order_end <= ? AND room_id IN "
                + "(SELECT id FROM room where hotel_id = ?))");
    preparedStatement.setString(1, dateStart);
    preparedStatement.setString(2, dateEnd);
    preparedStatement.setInt(3, hotel_id);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    return resultSet.getInt(1);
  }

  /**
   * Method that count average book time for hotel for period from DB.
   *
   * @param hotel_id - hotel ID
   * @param dateStart - first day of period
   * @param dateEnd - last day of period
   * @return average book time
   * @exception SQLException - error in sql query.
   */
  public int getAverageBookTime(int hotel_id, String dateStart, String dateEnd)
      throws SQLException {
    List<Integer> bookDays = new ArrayList<>();
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT order_start, order_end FROM room_book_archive WHERE "
                + "(order_start >= ? AND order_end <= ? AND room_id IN "
                + "(SELECT id FROM room where hotel_id = ?))");
    preparedStatement.setString(1, dateStart);
    preparedStatement.setString(2, dateEnd);
    preparedStatement.setInt(3, hotel_id);
    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
      bookDays.add(getDaysFromPeriod(resultSet.getString(1), resultSet.getString(2)));
    }

    return bookDays.size() > 0
        ? bookDays.stream().mapToInt(Integer::intValue).sum() / bookDays.size()
        : 0;
  }

  /**
   * Method that count days in period.
   *
   * @param dateStart - first day of period
   * @param dateEnd - last day of period
   * @return number of days
   * @exception SQLException - error in sql query.
   */
  private int getDaysFromPeriod(String dateStart, String dateEnd) {
    int[] firstDay = get3Int(dateStart);
    int[] lastDay = get3Int(dateEnd);
    LocalDate start = LocalDate.of(firstDay[0], firstDay[1], firstDay[2]);
    LocalDate end = LocalDate.of(lastDay[0], lastDay[1], lastDay[2]);
    return (int) ChronoUnit.DAYS.between(start, end);
  }

  /**
   * Method that get 3 numbers from string
   *
   * @param s - string
   * @return 3 numbers
   */
  private int[] get3Int(String s) {
    String[] s1 = s.split("-");
    int[] n = new int[3];
    for (int i = 0; i < 3; i++) {
      n[i] = Integer.parseInt(s1[i]);
    }
    return n;
  }
}
