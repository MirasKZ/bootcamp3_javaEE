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
import java.util.ArrayList;

@WebServlet(value = "/cities")
public class CitiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        ArrayList<City> cities = DBUtil.getCities();
        request.setAttribute("goroda",cities);
        request.getRequestDispatcher("/Chapter3/Task1/cities.jsp").forward(request,response);

    }
}
