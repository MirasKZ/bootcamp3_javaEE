package kz.bitlab.servlets.Chapter3.Task1;

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

@WebServlet(value="/addstudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/Chapter3/Task1/additem.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("st_na");
        String surname=req.getParameter("st_su");
        String birthdate=req.getParameter("st_bi");
        int cityId=Integer.parseInt(req.getParameter("st_ci"));
        City city=DBUtil.getCity(cityId);
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setBirthdate(birthdate);

        student.setCity(city);

        DBUtil.addStudent(student);
        resp.sendRedirect("/");

    }
}
