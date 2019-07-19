package com.sofserve.lv_427.tourfirm;

import com.sofserve.lv_427.tourfirm.dao.CityDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new CityDao().findAll();
    }
}
