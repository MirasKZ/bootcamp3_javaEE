package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.User;

import java.io.IOException;

@WebServlet(value = "/shopchangepassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/shop/password.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User) req.getSession().getAttribute("currentUser");
        String oldPassword=req.getParameter("old_password");
        String newPassword=req.getParameter("new_password");
        String reNewPassword=req.getParameter("re_new_password");
        String redirect="/";
        if(user!=null){
            redirect="/shopchangepassword?oldpassworderror";
            if(user.getPassword().equals(oldPassword)){
                redirect="/shopchangepassword?passworderror";
               if(newPassword.equals(reNewPassword)){
                   user.setPassword(newPassword);
                   DBUtil.updatePassword(user);
                   redirect="/shopchangepassword?passwordsuccess";
               }
            }
        }
        resp.sendRedirect(redirect);

    }
}
