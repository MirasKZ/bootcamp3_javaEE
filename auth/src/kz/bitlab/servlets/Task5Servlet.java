package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task5")
public class Task5Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userFullName = request.getParameter("user_fullname");
        String userAge = request.getParameter("user_age");
        String userGender = request.getParameter("user_gender");

        if(userFullName!=null && userAge!=null && userGender!=null) {

            int age = Integer.parseInt(userAge);

            String genderPrefix = "Mister";
            String agePrefix = "Dude";

            if (userGender.equals("female")) {
                genderPrefix = "Miss";
            }

            if (age >= 18) {
                agePrefix = "Dear";
            }

            out.print("<h1>Hello " + agePrefix + " " + genderPrefix + " " + userFullName + "</h1>");

        }else{
            out.print("<form action = '/task5' method = 'get'>");
            out.print("<input type = 'text' name = 'user_fullname' placeholder = 'Full Name'> <br><br>");
            out.print("<input type = 'number' name = 'user_age' placeholder = 'Age' value = '18' max = '121' min = '0'> <br><br>");
            out.print("<input type = 'radio' name = 'user_gender' value = 'male' checked> MALE <br><br>");
            out.print("<input type = 'radio' name = 'user_gender' value = 'female'> FEMALE<br><br>");
            out.print("<button>SEND</button>");
            out.print("</form>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}