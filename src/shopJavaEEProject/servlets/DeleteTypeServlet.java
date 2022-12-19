package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;

import java.io.IOException;

@WebServlet(value = "/deletetype")
public class DeleteTypeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(cityId);
        }
        catch (Exception e){

        }
        DBUtil.deleteType(id);
        resp.sendRedirect("/types");
    }
}
