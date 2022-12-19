package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBMyUtil;
import kz.bitlab.model.Item;

import java.io.IOException;

@WebServlet(value = "/deleteitem")
public class DeleteItemServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String itemId = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(itemId);
        } catch (Exception e) {
        }

        DBMyUtil.deleteItem(id);
        response.sendRedirect("/");

    }
}
