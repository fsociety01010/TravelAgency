package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.RoomDao;
import com.sofserve.lv_427.tourfirm.model.Room;
import com.sofserve.lv_427.tourfirm.service.RoomService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {
  RoomDao dao;

  public RoomServiceImpl() throws SQLException, ClassNotFoundException {
    dao = new RoomDao(JdbcConnector.getConnection());
  }

  /**
   * Method that find all rooms available on dates in hotel.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @return list of hotels.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<Room> getAvailableRoomsByHotel(String startDate, String endDate, int roomId)
      throws SQLException {
    return dao.getAvailableRoomsOnDatesInHotel(startDate, endDate, roomId);
  }

  @Override
  public int getRoomIdByNumber(int number) throws SQLException, ClassNotFoundException {
    return dao.getId(number);
  }

  /**
   * Method that find a loading of room.
   *
   * @param startDate - start of period
   * @param endDate - end of period
   * @param roomId - room ID
   * @return loading[0] - return number of booked day for certain period.
   * @return loading[1] - return a number of days of search range.
   * @exception SQLException - error in sql query.
   */
  @Override
  public int[] LoadingRoomsPeriod(String startDate, String endDate, int roomId)
      throws SQLException {
    int[] loading = new int[2];
     loading[0] = dao.getLoadingRoomsPeriod(startDate, endDate, roomId);
     loading[1] = dao.getLoadingPeriod(startDate,endDate);
     return loading;
  }
}
