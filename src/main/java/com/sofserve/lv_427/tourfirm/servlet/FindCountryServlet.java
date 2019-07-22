package com.sofserve.lv_427.tourfirm.servlet;

import com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl;
import com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/country")
public class FindCountryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/static/find_country.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        String country = req.getParameter("country");
//        String contry = req.getParameter("contry");

        try {
            session.setAttribute("country", country);
            session.setAttribute("countryId", new CountryServiceImpl().getCountryIdByName(country));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("WEB-INF/static/find_city.jsp").forward(req, resp);
    }
}
