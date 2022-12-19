package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBMyUtil;
import kz.bitlab.model.Country;
import kz.bitlab.model.Item;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idString = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idString);
        } catch (Exception e) {
        }

        Item item = DBMyUtil.getItem(id);
        request.setAttribute("item", item);

        ArrayList<Country> countries = DBMyUtil.getCountries();
        request.setAttribute("strany", countries);

        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}