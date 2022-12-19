package kz.bitlab.servlets.Chapter3.Task1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Item;
import kz.bitlab.model.Student;

import java.io.IOException;

@WebServlet(value="/savestudent")
public class SaveStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studId=req.getParameter("id");
        String name=req.getParameter("st-na");
        String surname=req.getParameter("st-su");
        String birthdate=req.getParameter("st-bi");
        int cityId=Integer.parseInt(req.getParameter("st-ci"));

        int id=0;
        try {
            id=Integer.parseInt(studId);
        }
        catch (Exception e){

        }
        Student student=DBUtil.getStudent(id);
        City city=DBUtil.getCity(cityId);
        if(student!=null){
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);
            student.setId(id);
            DBUtil.updateStudent(student);
            resp.sendRedirect("/studDetails?id="+id);
        }
        else{
            resp.sendRedirect("/");
        }


    }
}
