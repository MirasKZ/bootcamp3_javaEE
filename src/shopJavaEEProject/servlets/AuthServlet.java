package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.User;

import java.io.IOException;

@WebServlet(value = "/shopauth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/shop/auth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String redirect="/shopauth?usererror";
        User user =DBUtil.getUserByEmail(email);
        if(user!=null){
            redirect="/shopauth?passworderror";
            if(user.getPassword().equals(password)){
                redirect="/profile";
                HttpSession session=req.getSession();
                session.setAttribute("currentUser",user);
            }
        }
        resp.sendRedirect(redirect);
    }
}
