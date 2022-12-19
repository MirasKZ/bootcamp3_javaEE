package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.ShopItem;
import kz.bitlab.model.Student;
import kz.bitlab.model.Type;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/editshopitem")
public class EditShopItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");
        int id=0;
        try{
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }
        ShopItem shopItem=DBUtil.getShopItem(id);
        req.setAttribute("shopik",shopItem);

        ArrayList<Type> types= DBUtil.getTypes();
        req.setAttribute("tipki",types);
        req.getRequestDispatcher("/shop/editshopitem.jsp").forward(req,resp);
    }
}
