package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
  private Connection connection;

  private static final String ID = "id";
  private static final String ROOM_NUMBER = "room_number";
  private static final String HOTEL_ID = "hotel_id";

  public RoomDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Method that find all available rooms on dates in hotel.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @param hotelId - hotel id
   * @return list of rooms.
   * @exception SQLException - error in sql query.
   */
  public List<Room> getAvailableRoomsOnDatesInHotel(String startDate, String endDate, int hotelId)
      throws SQLException {
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "SELECT room.* "
                + "FROM room "
                + "WHERE room.id NOT IN (SELECT room_book.room_id FROM room_book "
                + "WHERE ((order_start > ? AND order_start < ?) OR (order_start < ? AND order_end > ?) OR (order_end > ? AND order_end < ?)))"
                + "AND room.hotel_id = ?");
    preparedStatement.setString(1, startDate);
    preparedStatement.setString(2, endDate);
    preparedStatement.setString(3, startDate);
    preparedStatement.setString(4, endDate);
    preparedStatement.setString(5, startDate);
    preparedStatement.setString(6, endDate);
    preparedStatement.setInt(7, hotelId);

    ResultSet resultSet = preparedStatement.executeQuery();

    List<Room> rooms = new ArrayList<>();
    while (resultSet.next()) {
      rooms.add(
          new Room(
              resultSet.getInt(ID), resultSet.getInt(ROOM_NUMBER), resultSet.getInt(HOTEL_ID)));
    }
    return rooms;
  }

  /**
   * Method that find and return id of room.
   *
   * @param number - room name
   * @return id of room
   * @exception SQLException - error in sql query.
   */
  public int getId(int number) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select id from room where " + ROOM_NUMBER + " = ?");
    preparedStatement.setInt(1, number);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with number " + number);
    }
  }

  /**
   * Method that shows a loading of rooms in days for certain hotel.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @param roomId - room id
   * @return loading of rooms
   * @exception SQLException - error in sql query.
   */
  public int getLoadingRoomsPeriod(String startDate, String endDate, int roomId)
      throws SQLException {
    int loading = 0;
    int count = 0;
    PreparedStatement preparedStatement =
        connection.prepareStatement(
            "select datediff(order_end, order_start) from room_book_archive"
                + " WHERE (order_start between ? AND ?)"
                + "AND (order_end between ? AND ?) AND room_id = ?");
    preparedStatement.setString(1, startDate);
    preparedStatement.setString(2, endDate);
    preparedStatement.setString(3, startDate);
    preparedStatement.setString(4, endDate);
    preparedStatement.setInt(5, roomId);

    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
      loading += resultSet.getInt("datediff(order_end, order_start)");
      count++;
    }

    return loading/count;
  }

  /**
   * Method that shows a period of room`s loading in certain period.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @return  return a number of days of search range.
   * @exception SQLException - error in sql query.
   */
  public int getLoadingPeriod(String startDate, String endDate)
          throws SQLException {
    int periode = 0;
    PreparedStatement preparedStatement =
            connection.prepareStatement(
                    "select timestampdiff(day, ?, ?) AS periode");
    preparedStatement.setString(1, startDate);
    preparedStatement.setString(2, endDate);



    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      periode = resultSet.getInt("periode");
    }
    return periode;
  }
}

