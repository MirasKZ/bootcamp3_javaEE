package kz.bitlab.servlets.Chapter3.Task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Student;

import java.io.IOException;

@WebServlet(value="/addcity")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/Chapter3/Task1/additem.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("ct_na");
        String code=req.getParameter("ct_co");
        City city=new City();
        city.setName(name);
        city.setCode(code);
        DBUtil.addCity(city);
        resp.sendRedirect("/cities");

    }
}
