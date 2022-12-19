package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/shopdetails")
public class DetailsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString=request.getParameter("id");
        int id=0;
        try{
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }

        ShopItem shopItem=DBUtil.getShopItem(id);
        request.setAttribute("details",shopItem);
        ArrayList<Comments> comments=DBUtil.getComments(id);
        request.setAttribute("komiki",comments);
        request.getRequestDispatcher("/shop/details.jsp").forward(request,response);


    }
}
