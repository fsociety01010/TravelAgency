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
	 * @return list of clients.
	 * @exception SQLException - error in sql query.
	 */
	public List<Client> findAll() throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM travel_agency.client");

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Client> clients = new ArrayList<>();
		while (resultSet.next()) {
			clients.add(new Client(resultSet.getInt(ID), resultSet.getString(FIRST_NAME),
					resultSet.getString(LAST_NAME), resultSet.getString(PHONE_NUMBER)));
		}
		return clients;
	}

}
