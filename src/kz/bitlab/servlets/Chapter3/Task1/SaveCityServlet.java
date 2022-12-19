package kz.bitlab.servlets.Chapter3.Task1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.Chapter3.Task1.DBUtil;
import kz.bitlab.model.City;
import kz.bitlab.model.Student;

import java.io.IOException;

@WebServlet(value="/savecity")
public class SaveCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityId=req.getParameter("id");
        String name=req.getParameter("ct-na");
        String code=req.getParameter("ct-co");

        int id=0;
        try {
            id=Integer.parseInt(cityId);
        }
        catch (Exception e){

        }
        City city=DBUtil.getCity(id);
        if(city!=null){
            city.setName(name);
            city.setCode(code);
            DBUtil.updateCity(city);
            resp.sendRedirect("/cityDetails?id="+id);
        }
        else{
            resp.sendRedirect("/");
        }


    }
}
