package kz.bitlab.servlets.Chapter7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.model.Tovar;

import java.io.IOException;

import java.util.ArrayList;

@WebServlet(value = "/mainTov")
public class TovarySessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Tovar> tovary=DBTovarManager.getTovary();
        req.setAttribute("tov2",tovary);
        req.getRequestDispatcher("/tovary.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");
        int id=0;
        try {
            id=Integer.parseInt(idString);
        }
        catch (Exception e){

        }
        HttpSession session=req.getSession();
        Tovar tovar=DBTovarManager.getTovarById(id);

        ArrayList<Tovar> tovary =(ArrayList<Tovar>) session.getAttribute("tov");
        if(tovary==null){
            tovary=new ArrayList<>();
        }
        if(tovar!=null){
            tovary.add(tovar);
            System.out.println("added :"+tovar.getName());
            System.out.println(tovary.size());


        }
        session.setAttribute("tov",tovary);
        resp.sendRedirect("/mainTov");
    }
}
