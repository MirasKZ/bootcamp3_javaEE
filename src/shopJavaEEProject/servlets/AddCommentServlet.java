package shopJavaEEProject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.db.DBUtil;
import kz.bitlab.model.Comments;
import kz.bitlab.model.ShopItem;
import kz.bitlab.model.Type;
import kz.bitlab.model.User;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item_id=req.getParameter("item_id");
        User user=(User) req.getSession().getAttribute("currentUser");
        ShopItem shopItem=DBUtil.getShopItem(Integer.parseInt(item_id));
        Comments comment=new Comments();
        comment.setComment(req.getParameter("comment_text"));
        comment.setUser(user);
        comment.setShopItem(shopItem);

        DBUtil.addComment(comment);
        resp.sendRedirect("/shopdetails?id="+item_id);
    }
}
