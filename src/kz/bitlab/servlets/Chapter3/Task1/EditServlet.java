package kz.bitlab.servlets.Chapter3.Task1;

import com.sun.net.httpserver.HttpPrincipal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Country;
import kz.bitlab.model.Student;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");
        int id=0;
        try{
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }
        Student student = DBUtil.getStudent(id);
        req.setAttribute("stud",student);
        ArrayList<City> cities= DBUtil.getCities();
        req.setAttribute("goroda",cities);
        req.getRequestDispatcher("/Chapter3/Task1/editStudent.jsp").forward(req,resp);
    }
}
