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

@WebServlet(value="/savetype")
public class SaveTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeId=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(typeId);
        }
        catch (Exception e){

        }
        String name=req.getParameter("type_name");
        Type type=DBUtil.getTypeById(id);

        if(type!=null){
            type.setName(name);
            DBUtil.updateType(type);
            resp.sendRedirect("/typedetails?id="+id);
        }
        else{
            resp.sendRedirect("/types");
        }


    }
}
