package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.dto.ClientFormDto;

import java.io.IOException;

@WebServlet(value = "/step-three")
public class StepThreeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/stepthree.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientFormDto client = (ClientFormDto) request.getSession().getAttribute("CURRENT_SAVE_USER");

        String university = request.getParameter("user_university");
        String faculty = request.getParameter("user_faculty");
        String group = request.getParameter("user_group");

        client.setUniversity(university);
        client.setFaculty(faculty);
        client.setGroup(group);

        HttpSession session = request.getSession();
        session.setAttribute("CURRENT_SAVE_USER", client);
        response.sendRedirect("/finish");
    }
}