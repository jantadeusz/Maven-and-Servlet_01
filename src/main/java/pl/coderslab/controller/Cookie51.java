package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie51", urlPatterns = "/cookie51")
public class Cookie51 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        try {
            CookieService.cookieAdd(response, "Cookie51Visited", "yes", 3600);

        } catch (Exception e) {
            e.printStackTrace();
        }


        String link = "<a href='/cookie52'> click here to enter Cookie52 servlet </a>";
        wr.append(link);

    }
}
