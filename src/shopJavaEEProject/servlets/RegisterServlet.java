package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.User;

import java.io.IOException;

@WebServlet(value = "/shopregister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/shop/register.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String fullname=req.getParameter("fullname");
        String password=req.getParameter("password");
        String rePassword=req.getParameter("re_password");
        String redirect="/shopregister?passworderror";


        if(password.equals(rePassword)){
            redirect="/shopregister?emailerror";
            User user=DBUtil.getUserByEmail(email);
            if(user==null){
                redirect="/shopregister?success";
                User newUser=new User();
                newUser.setLogin(email);
                newUser.setFullname(fullname);
                newUser.setPassword(password);
                DBUtil.addUser(newUser);
            }
        }
        resp.sendRedirect(redirect);
    }
}
