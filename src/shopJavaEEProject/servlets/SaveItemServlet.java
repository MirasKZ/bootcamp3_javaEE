package shopJavaEEProject.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.Country;
import kz.bitlab.model.Item;
import kz.bitlab.model.ShopItem;
import kz.bitlab.model.Type;

import java.io.IOException;

@WebServlet(value="/shopsaveitem")
public class SaveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(itemId);
        }
        catch (Exception e){
        }

        String name=req.getParameter("item_name");
        String description=req.getParameter("item_description");
        int type_id=Integer.parseInt(req.getParameter("item_type"));
        Double newprice=Double.parseDouble(req.getParameter("item_new_price"));
        Double oldprice=Double.parseDouble(req.getParameter("item_old_price"));
        Boolean onSale=Boolean.parseBoolean(req.getParameter("item_on_sale"));
        Boolean popular=Boolean.parseBoolean(req.getParameter("item_popular"));
        String url=req.getParameter("item_url");
        int amount=Integer.parseInt(req.getParameter("item_amount"));


        ShopItem item=DBUtil.getShopItem(id);
        Type type=DBUtil.getTypeById(type_id);
        if(item!=null){
            item.setName(name);
            item.setDescription(description);
            item.setType(type);
            item.setNewprice(newprice);
            item.setOldprice(oldprice);
            item.setPopular(popular);
            item.setOnSale(onSale);
            item.setUrl(url);
            item.setAmount(amount);

            DBUtil.updateShopItem(item);
            resp.sendRedirect("/shopdetails?id="+id);
        }
        else{
            resp.sendRedirect("/profile");
        }


    }
}
