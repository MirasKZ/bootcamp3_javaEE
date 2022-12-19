package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;

import java.io.IOException;

@WebServlet(value = "/shopdeleteitem")
public class DeleteItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(itemId);
        }
        catch (Exception e){

        }
        DBUtil.deleteShopItem(id);
        resp.sendRedirect("/profile");
    }
}
