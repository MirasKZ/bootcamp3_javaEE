package kz.bitlab.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.Country;
import kz.bitlab.model.Item;
import kz.bitlab.model.Type;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/additem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Country> countries=DBUtil.getCountries();
        req.setAttribute("strany",countries);

        req.getRequestDispatcher("/additem.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("it_na");
        int countryId=Integer.parseInt(req.getParameter("it_co"));
        String price=req.getParameter("it_pr");
        String amount=req.getParameter("it_am");

        Country country=DBUtil.getCountry(countryId);
        Item item = new Item();
        item.setName(name);

        item.setPrice(Double.parseDouble(price));
        item.setAmount(Integer.parseInt(amount));
        item.setCountry(country);


        DBUtil.addItem(item);
        resp.sendRedirect("/additem?success=1");

    }
}
