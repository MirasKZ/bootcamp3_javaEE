package kz.bitlab.servlets.Chapter5Part2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Electronics;
import kz.bitlab.model.Student;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home3")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //ArrayList<Electronics> electronics= DBUtil.getElectronics();
        //request.setAttribute("goroda",cities);

        ArrayList<Student> students = DBUtil.getStudents();
        request.setAttribute("studenty",students);
        request.getRequestDispatcher("/Chapter3/Task1/index.jsp").forward(request,response);

    }
}
