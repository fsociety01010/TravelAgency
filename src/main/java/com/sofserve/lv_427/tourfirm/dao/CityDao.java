
package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDao {
    private Connection connection;

//    public CityDao(Connection connection) {
//        this.connection = connection;
//    }

    public CityDao() throws SQLException, ClassNotFoundException {
        this.connection = JdbcConnector.getConnection();
    }

    public void findAll() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from travel_agency.city");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getInt("id"));
        System.out.println(resultSet.getString("city_name"));
    }
}

