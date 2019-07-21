package com.sofserve.lv_427.tourfirm.service.impl;

import com.sofserve.lv_427.tourfirm.dao.VisaDao;
import com.sofserve.lv_427.tourfirm.service.VisaService;

import java.sql.SQLException;

public class VisaServiceImpl implements VisaService {
    VisaDao dao;

    public VisaServiceImpl() {
        dao = new VisaDao();
    }

    @Override
    public int getVisaIdByName(String name) throws SQLException, ClassNotFoundException {
        return dao.getId(name);
    }

    /**
     * @param countryId - id number of the country in a table
     * @return Count of visa for country
     * @throws SQLException
     */
    @Override
    public int getCountVisaForCountry(int countryId) throws SQLException {
        return dao.CountVisaForCountry(countryId);
    }
}
