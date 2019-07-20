package com.sofserve.lv_427.tourfirm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/about")
public class About extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
      request.getRequestDispatcher("WEB-INF/static/about.jsp").forward(request, response);
  }
}
