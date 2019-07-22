package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.CityDao;
import com.sofserve.lv_427.tourfirm.model.City;
import com.sofserve.lv_427.tourfirm.model.Hotel;
import com.sofserve.lv_427.tourfirm.service.CityService;
import com.sofserve.lv_427.tourfirm.service.HotelService;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CityServiceImpl implements CityService {
	private CityDao dao;
	private HotelService hotelService;

	public CityServiceImpl() throws SQLException, ClassNotFoundException {
		this.dao = new CityDao(JdbcConnector.getConnection());
		hotelService = new HotelServiceImpl();
	}

	/**
	 * Method that find all Cities.
	 *
	 * @return list of Cities.
	 * @exception SQLException - error in sql query.
	 */
	@Override
	public List<City> getCityList() throws SQLException {
		return dao.findAll();
	}

	/**
	 * Method that find all Cities by country ID.
	 *
	 * @return list of Cities.
	 * @exception SQLException - error in sql query.
	 */
	@Override
	public List<City> citiesByCountry(int id) throws SQLException {
		return dao.findAllByCountryID(id);
	}

  /**
   * Method that find all Cities with available hotels.
   *
   * @param startDate - start booking
   * @param endDate - end booking
   * @return list of Cities.
   * @exception SQLException - error in sql query.
   */
  @Override
  public List<City> getCityWithAvailableHotels(String startDate, String endDate, int countryId)
      throws SQLException {
    List<City> availableCities;
    List<Hotel> availableHotels = hotelService.getAvailableHotelsOnDate(startDate, endDate);
    Set<Integer> idOfAvailableCities = new HashSet<>();

    for (Hotel hotel : availableHotels) {
      idOfAvailableCities.add(hotel.getCityId());
    }

    availableCities = dao.getCityWhereAvailableHotels(idOfAvailableCities, countryId);

    return availableCities;
  }

  @Override
  public int getCityIdByName(String name) throws SQLException, ClassNotFoundException {
    return dao.getId(name);
  }
}
