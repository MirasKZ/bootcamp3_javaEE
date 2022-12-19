package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.ShopItem;
import kz.bitlab.model.Tovar;
import kz.bitlab.servlets.Chapter7.DBTovarManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addtocart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }
        HttpSession session=req.getSession();
        ShopItem shopItem= DBUtil.getShopItem(id);

        ArrayList<ShopItem> SHOPITEMS =(ArrayList<ShopItem>) session.getAttribute("shopsiki");
        if(SHOPITEMS==null){
            SHOPITEMS=new ArrayList<>();
        }
        if(shopItem!=null){
            SHOPITEMS.add(shopItem);
            System.out.println("added :"+shopItem.getName());
            System.out.println(SHOPITEMS.size());


        }
        session.setAttribute("shopsiki",SHOPITEMS);
        resp.sendRedirect("/profile");
    }
    }
