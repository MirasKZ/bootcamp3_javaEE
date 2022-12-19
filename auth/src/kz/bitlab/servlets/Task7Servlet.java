package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.FootballerManager;
import kz.bitlab.model.Footballer;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task7")
public class Task7Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("futbolisty", FootballerManager.getFootballers());
        request.getRequestDispatcher("/task7.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String club = request.getParameter("club");
        long salary = Long.parseLong(request.getParameter("salary"));
        long price = Long.parseLong(request.getParameter("price"));

        Footballer footballer = new Footballer();
        footballer.setName(name);
        footballer.setSurname(surname);
        footballer.setClub(club);
        footballer.setSalary(salary);
        footballer.setPrice(price);

        FootballerManager.addFootballer(footballer);
        response.sendRedirect("/task7");

    }
}