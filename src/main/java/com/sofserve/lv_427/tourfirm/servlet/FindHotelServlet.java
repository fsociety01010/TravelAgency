package com.sofserve.lv_427.tourfirm.servlet;

import com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hotel")
public class FindHotelServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/static/find_hotel.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    String hotel = req.getParameter("hotel");

    try {
      session.setAttribute("hotel", hotel);
      session.setAttribute("hotelId", new HotelServiceImpl().getHotelIdByName(hotel));
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    req.getRequestDispatcher("WEB-INF/static/hotel.jsp").forward(req, resp);
  }
}
