package com.sofserve.lv_427.tourfirm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/hotel")
public class HotelServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/static/hotel.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    String start_date_hotel_stat = request.getParameter("start_date_hotel_stat");
    String end_date_hotel_stat = request.getParameter("end_date_hotel_stat");
    String start_date = request.getParameter("start_date");
    String end_date = request.getParameter("end_date");

    session.setAttribute("start_date_hotel_stat", start_date_hotel_stat);
    session.setAttribute("end_date_hotel_stat", end_date_hotel_stat);
    session.setAttribute("start_date", start_date);
    session.setAttribute("end_date", end_date);

    request.getRequestDispatcher("WEB-INF/static/hotel.jsp").forward(request, response);
  }
}
