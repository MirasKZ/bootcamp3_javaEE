package kz.bitlab.servlets.Chapter7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.db.DBUser;
import kz.bitlab.model.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/usersMain")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/logUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("pwd");
        boolean authenticated=false;
        ArrayList<User> users= DBUser.getUsers();

        for(User u:users){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                HttpSession session=req.getSession();
                authenticated=true;
                session.setAttribute("pol",u);
                req.getRequestDispatcher("/userPage.jsp").forward(req,resp);
            }
        }
        if(!authenticated){
            resp.sendRedirect("/usersMain");
        }
    }
}
