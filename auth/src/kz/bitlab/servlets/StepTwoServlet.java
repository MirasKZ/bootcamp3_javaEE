package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.dto.ClientFormDto;

import java.io.IOException;

@WebServlet(value = "/step-two")
public class StepTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/steptwo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientFormDto client = (ClientFormDto) request.getSession().getAttribute("CURRENT_SAVE_USER");

        String city = request.getParameter("user_city");
        String address = request.getParameter("user_address");
        String phone = request.getParameter("user_phone");

        client.setCity(city);
        client.setAddress(address);
        client.setPhone(phone);

        HttpSession session = request.getSession();
        session.setAttribute("CURRENT_SAVE_USER", client);
        response.sendRedirect("/step-three");
    }
}