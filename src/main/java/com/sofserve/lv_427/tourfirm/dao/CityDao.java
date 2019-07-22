package com.sofserve.lv_427.tourfirm.dao;

import com.sofserve.lv_427.tourfirm.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CityDao {
	private Connection connection;

	public CityDao(Connection connection) {
		this.connection = connection;
	}

	private static final String ID = "id";
	private static final String CITY_NAME = "city_name";
	private static final String COUNTRY_ID = "country_id";

	/**
	 * Method that find and return all Cities from DB.
	 *
	 * @return list of cities.
	 * @exception SQLException - error in sql query.
	 */
	public List<City> findAll() throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM travel_agency.city");

		ResultSet resultSet = preparedStatement.executeQuery();

		List<City> cities = new ArrayList<>();
		while (resultSet.next()) {
			cities.add(new City(resultSet.getInt(ID), resultSet.getString(CITY_NAME), resultSet.getInt(COUNTRY_ID)));
		}
		return cities;
	}

	/**
	 * Method that find and return all Cities from DB by countryId.
	 *
	 * @param countryId - country ID
	 * @return list of cities.
	 * @exception SQLException - error in sql query.
	 */
	public List<City> findAllByCountryID(int countryId) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM travel_agency.city WHERE " + ID + " = ?");
		preparedStatement.setInt(1, countryId);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<City> citiesByCountry = new ArrayList<>();
		while (resultSet.next()) {
			citiesByCountry
					.add(new City(resultSet.getInt(ID), resultSet.getString(CITY_NAME), resultSet.getInt(COUNTRY_ID)));
		}
		return citiesByCountry;
	}

  /**
   * Method that find and return all Cities where is available hotels.
   *
   * @param listOfCityId - list of cities id
   * @return list of cities.
   * @exception SQLException - error in sql query.
   */
  public List<City> getCityWhereAvailableHotels(Set<Integer> listOfCityId, int countryId) throws SQLException {
    List<City> cities = new ArrayList<>();

    for (int cityId : listOfCityId) {
      PreparedStatement preparedStatement =
          connection.prepareStatement("SELECT City.* FROM City WHERE city.id = ? AND country_id = ?");
      preparedStatement.setInt(1, cityId);
      preparedStatement.setInt(2, countryId);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        cities.add(
            new City(
                resultSet.getInt(ID),
                resultSet.getString(CITY_NAME),
                resultSet.getInt(COUNTRY_ID)));
      }
    }

    return cities;
  }

  /**
   * Method that find and return id of city.
   *
   * @param name - city name
   * @return id of city
   * @exception SQLException - error in sql query.
   */
  public int getId(String name) throws SQLException, ClassNotFoundException {
    PreparedStatement preparedStatement =
        connection.prepareStatement("select id from city where " + CITY_NAME + " = ?");
    preparedStatement.setString(1, name);

    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
      return resultSet.getInt("id");
    } else {
      throw new ClassNotFoundException("In DB no row with name " + name);
    }
  }
}
