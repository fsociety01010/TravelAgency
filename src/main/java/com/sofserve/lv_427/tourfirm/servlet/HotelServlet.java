package com.sofserve.lv_427.tourfirm.servlet;

import com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/hotel1")
public class HotelServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/static/hotel1.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    String start_date_hotel_stat = req.getParameter("start_date_hotel_stat");
    String end_date_hotel_stat = req.getParameter("end_date_hotel_stat");

    session.setAttribute("start_date_hotel_stat", start_date_hotel_stat);
    session.setAttribute("end_date_hotel_stat", end_date_hotel_stat);

    req.getRequestDispatcher("WEB-INF/static/hotel.jsp").forward(req, resp);
  }
}
