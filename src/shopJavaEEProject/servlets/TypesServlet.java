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
import java.util.ArrayList;

@WebServlet(value = "/types")
public class TypesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Type> types  = DBUtil.getTypes();
        request.setAttribute("tipy",types);
        request.getRequestDispatcher("/shop/types.jsp").forward(request,response);

    }
}
