package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Type;

import java.io.IOException;

@WebServlet(value = "/typedetails")
public class TypeDetailsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString=request.getParameter("id");
        int id=0;
        try{
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }

        Type type =DBUtil.getTypeById(id);
        request.setAttribute("tipdetal",type);
        request.getRequestDispatcher("/shop/typedetails.jsp").forward(request,response);

    }
}
