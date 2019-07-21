package com.sofserve.lv_427.tourfirm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisaDao {
    private Connection connection;

    private static final String ID = "id";
    private static final String VISA_NAME = "visa_name";
    private static final String COUNTRY_ID = "country_id";
    private static final String CLIENT_ID = "client_id";

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
}
