package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.ShopItem;
import kz.bitlab.model.Type;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/shopadditem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Type> types= DBUtil.getTypes();
        req.setAttribute("tipy",types);

        req.getRequestDispatcher("/shop/additem.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //gets data of shopitem
        String typeId=req.getParameter("item_type");
        System.out.println(typeId);
        Type type=DBUtil.getTypeById(Integer.parseInt(typeId));

        String name=req.getParameter("item_name");
        String description=req.getParameter("item_description");
        String onsale=req.getParameter("item_onsale");
        String newprice=req.getParameter("item_newprice");

        String oldprice=req.getParameter("item_oldprice");

        String amount=req.getParameter("item_amount");
        String popular=req.getParameter("item_popular");
        String url=req.getParameter("item_url");

        ShopItem shopItem=new ShopItem();
        shopItem.setName(name);
        shopItem.setDescription(description);
        shopItem.setOnSale(Boolean.parseBoolean(onsale));
        shopItem.setPopular(Boolean.parseBoolean(popular));
        shopItem.setNewprice(Double.parseDouble(newprice));
        if(Boolean.parseBoolean(onsale)){
        shopItem.setOldprice(Double.parseDouble(oldprice));}
        shopItem.setAmount(Integer.parseInt(amount));
        shopItem.setUrl(url);
        shopItem.setType(type);

        DBUtil.addShopItem(shopItem);
        resp.sendRedirect("/profile");
    }
}
