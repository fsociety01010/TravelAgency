package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Visa;

import java.sql.SQLException;
import java.util.List;

public interface VisaService {
  int getCountVisaForCountry(int id) throws SQLException;
}
