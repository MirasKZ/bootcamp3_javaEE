package kz.bitlab.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.Country;
import kz.bitlab.model.Item;

import java.io.IOException;

@WebServlet(value="/saveitem")
public class SaveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("it_na");
        int countryId=Integer.parseInt(req.getParameter("it_co"));
        String price=req.getParameter("it_pr");
        String amount=req.getParameter("it_am");
        String itemId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(itemId);
        }
        catch (Exception e){

        }
        Item item=DBUtil.getItem(id);
        Country country=DBUtil.getCountry(countryId);
        if(item!=null){
            item.setName(name);
            item.setCountry(country);
            item.setPrice(Double.parseDouble(price));
            item.setAmount(Integer.parseInt(amount));
            item.setId(id);
            DBUtil.updateItem(item);
            resp.sendRedirect("/details?id="+id);
        }
        else{
            resp.sendRedirect("/");
        }


    }
}
