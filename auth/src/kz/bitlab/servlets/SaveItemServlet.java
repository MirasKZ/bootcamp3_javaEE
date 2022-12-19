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

@WebServlet(value = "/saveitem")
public class SaveItemServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("item_name");
        int countryId = Integer.parseInt(request.getParameter("item_country"));
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        String itemId = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(itemId);
        } catch (Exception e) {
        }

        Item item = DBMyUtil.getItem(id);

        Country country = DBMyUtil.getCountry(countryId);

        if (item != null) {

            item.setName(name);
            item.setCountry(country);
            item.setPrice(Double.parseDouble(price));
            item.setAmount(Integer.parseInt(amount));
            DBMyUtil.updateItem(item);

            response.sendRedirect("/details?id="+id);

        }else{
            response.sendRedirect("/");
        }
    }
}
