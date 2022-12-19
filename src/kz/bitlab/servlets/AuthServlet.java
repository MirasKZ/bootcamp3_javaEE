package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.User;

import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/auth?usererror";
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User check = DBUtil.getUserByEmail(login);
       if(check!=null){
            redirect = "/auth?passworderror";
           if(check.getPassword().equals(password)){
                HttpSession session = request.getSession();
               session.setAttribute("currentUser", check);
                redirect = "/profile";
            }
        }
       response.sendRedirect(redirect);
    }
}