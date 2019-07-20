package com.sofserve.lv_427.tourfirm.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class Welcome extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    PrintWriter pw = response.getWriter();
    pw.println("<html>");
    pw.println("<h1>Welcome to web-site of our travel agency</h1>");
    pw.println("</html>");
  }
}
