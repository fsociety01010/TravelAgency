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
}
