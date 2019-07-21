package com.sofserve.lv_427.tourfirm.servlet;

import com.mysql.cj.Session;
import com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/find")
public class FindHotel extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/static/findHotel.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    String client = req.getParameter("client");
    String startDate = req.getParameter("start_date");
    String endDate = req.getParameter("end_date");

    String[] clientSplitToArray = client.split(" ");

    try {
      session.setAttribute(
          "clientId",
          new ClientServiceImpl().getClientId(clientSplitToArray[0], clientSplitToArray[1]));
      session.setAttribute("startDate", startDate);
      session.setAttribute("endDate", endDate);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    req.setAttribute("clientBack", client);
    req.getRequestDispatcher("WEB-INF/static/findHotel.jsp").forward(req, resp);
  }
}
