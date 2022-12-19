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

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Country> countries = DBMyUtil.getCountries();
        request.setAttribute("strany", countries);
        request.getRequestDispatcher("/additem.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("item_name");
        int countryId = Integer.parseInt(request.getParameter("item_country"));
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        Country country = DBMyUtil.getCountry(countryId);

        Item item = new Item();
        item.setName(name);
        item.setPrice(Double.parseDouble(price));
        item.setAmount(Integer.parseInt(amount));
        item.setCountry(country);

        DBMyUtil.addItem(item);

        response.sendRedirect("/additem?success");

    }
}
