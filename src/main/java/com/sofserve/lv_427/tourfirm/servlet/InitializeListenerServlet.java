package com.sofserve.lv_427.tourfirm.servlet;

import com.sofserve.lv_427.tourfirm.dao.RoomBookDao;
import com.sofserve.lv_427.tourfirm.utils.JdbcConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class InitializeListenerServlet implements ServletContextListener {
  @Override
  public final void contextInitialized(final ServletContextEvent sce) {
    try {
      new RoomBookDao(JdbcConnector.getConnection()).movePastBookingToArchive();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
