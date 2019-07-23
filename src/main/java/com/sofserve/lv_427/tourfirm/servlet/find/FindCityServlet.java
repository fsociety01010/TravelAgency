package com.sofserve.lv_427.tourfirm.servlet.find;

import com.sofserve.lv_427.tourfirm.service.impl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/find_city")
public class FindCityServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/static/find/find_city.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    String city = req.getParameter("city");

    try {
      session.setAttribute("city", city);
      session.setAttribute("cityId", new CityServiceImpl().getCityIdByName(city));
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    req.getRequestDispatcher("WEB-INF/static/find/find_hotels.jsp").forward(req, resp);
  }
}
