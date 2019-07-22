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
   * @param hotelId - hotel ID
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
   * Method that find all rooms available on dates in hotel.
   *
   * @param startDate - start of periode
   * @param endDate - end of periode
   * @param hotelId - hotel ID
   * @return list of hotels.
   * @exception SQLException - error in sql query.
   */
  @Override
  public int LoadingRoomsPeriode(String startDate, String endDate, int hotelId)
      throws SQLException {
    return dao.getLoadingRoomsPeriode(startDate, endDate, hotelId);
  }
}
