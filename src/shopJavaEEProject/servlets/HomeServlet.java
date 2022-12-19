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

@WebServlet(value = "/profile")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type_id=req.getParameter("category");
        ArrayList<ShopItem> shopitems=new ArrayList<>();
        if(type_id!=null){
            shopitems=DBUtil.getShopItemsByCategory(type_id);
        }
        else{
            shopitems= DBUtil.getShopItems();
        }
        req.setAttribute("tipy",DBUtil.getTypes());
        req.setAttribute("shopitemy",shopitems);
        req.getRequestDispatcher("/shop/profile2.jsp").forward(req,resp);
    }

}
