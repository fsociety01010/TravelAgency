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
                + "WHERE order_start > ? AND (order_end > ? OR order_end > ?))"
                + "AND room.hotel_id = ?");
    preparedStatement.setString(1, startDate);
    preparedStatement.setString(2, endDate);
    preparedStatement.setString(3, endDate);
    preparedStatement.setInt(4, hotelId);

    ResultSet resultSet = preparedStatement.executeQuery();

    List<Room> rooms = new ArrayList<>();
    while (resultSet.next()) {
      rooms.add(
          new Room(
              resultSet.getInt(ID), resultSet.getInt(ROOM_NUMBER), resultSet.getInt(HOTEL_ID)));
    }
    return rooms;
  }
}
