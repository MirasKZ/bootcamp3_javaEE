package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.dto.ClientFormDto;

import java.io.IOException;

@WebServlet(value = "/step-one")
public class StepOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/stepone.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientFormDto client = new ClientFormDto();

        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String age = request.getParameter("user_age");

        client.setName(name);
        client.setSurname(surname);
        client.setAge(age);

//        request.getSession().setAttribute("CURRENT_SAVE_USER", client);
        HttpSession session = request.getSession();
        session.setAttribute("CURRENT_SAVE_USER", client);
        response.sendRedirect("/step-two");
    }
}