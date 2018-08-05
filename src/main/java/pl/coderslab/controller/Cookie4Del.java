package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie4Del", urlPatterns = "/cookie4Del")
public class Cookie4Del extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();
        String nameFromRequest = request.getParameter("name");
        wr
                .append("Cookie to be deleted: ")
                .append(nameFromRequest);

        CookieService.deleteCookie(response, nameFromRequest);
        response.getWriter().append("<br>cookie successfully deleted");

    }
}

