package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.dao.CityDao;
import com.sofserve.lv_427.tourfirm.dao.CountryDao;
import com.sofserve.lv_427.tourfirm.model.Country;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         CountryDao countryDao =new CountryDao(JdbcConnector.getConnection());

        List<Country> countryList = countryDao.findAll();
        for ( Country el : countryList ) {
            System.out.println(el.getCountryName());
        }
    }
}
