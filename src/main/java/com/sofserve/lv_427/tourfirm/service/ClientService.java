package com.sofserve.lv_427.tourfirm.service;

import com.sofserve.lv_427.tourfirm.model.Client;
import java.sql.SQLException;
import java.util.List;

public interface ClientService {
	List<Client> getClientList() throws SQLException;
}
