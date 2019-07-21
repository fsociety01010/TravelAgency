package com.sofserve.lv_427.tourfirm.service;

import java.sql.SQLException;

public interface VisaService {

  int getVisaIdByName(String name) throws SQLException, ClassNotFoundException;
}
