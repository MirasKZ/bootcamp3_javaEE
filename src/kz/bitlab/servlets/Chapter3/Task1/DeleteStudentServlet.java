package kz.bitlab.servlets.Chapter3.Task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;

import java.io.IOException;

@WebServlet(value = "/deletestudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(itemId);
        }
        catch (Exception e){

        }
        DBUtil.deleteStudent(id);
        resp.sendRedirect("/");
    }
}
