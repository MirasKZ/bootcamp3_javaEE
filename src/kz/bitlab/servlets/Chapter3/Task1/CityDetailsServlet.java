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

@WebServlet(value = "/cityDetails")
public class CityDetailsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString=request.getParameter("id");
        int id=0;
        try{
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }

        City city =DBUtil.getCity(id);
        request.setAttribute("cityDet",city);
        request.getRequestDispatcher("/Chapter3/Task1/cityDetails.jsp").forward(request,response);


    }
}
