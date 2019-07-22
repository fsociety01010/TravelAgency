package com.sofserve.lv_427.tourfirm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RoomBookDao {
	private static final String ID = "id";
	private static final String ORDER_START = "order_start";
	private static final String ORDER_END = "order_end";
	private static final String ROOM_ID = "room_id";
	private static final String CLIENT_ID = "client_id";
	private Connection connection;

	public RoomBookDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Method which move past booking to special table room_book_archive.
	 *
	 * @exception SQLException - error in sql query.
	 */
	public void movePastBookingToArchive() throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		PreparedStatement preparedStatement1 = connection
				.prepareStatement("INSERT INTO room_book_archive " + "(order_start, order_end, room_id, client_id)"
						+ "SELECT order_start, order_end, room_id, client_id" + " FROM room_book WHERE order_end < ?;");
		preparedStatement1.setString(1, date);

		PreparedStatement preparedStatement2 = connection
				.prepareStatement("DELETE FROM room_book WHERE order_end < ?;");
		preparedStatement2.setString(1, date);

		preparedStatement1.executeUpdate();
		preparedStatement2.executeUpdate();
	}

}
