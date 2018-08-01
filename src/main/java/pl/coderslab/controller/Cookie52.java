package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie52", urlPatterns = "/cookie52")
public class Cookie52 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Writer wr = response.getWriter();

        Cookie[] cookies = request.getCookies();

        Cookie searchedCookie = CookieService.getByName(cookies, "Cookie51Visited");

        if (searchedCookie == null) {
            String link = "<a href='/cookie51'> click here to enter Cookie51 servlet </a>";
            wr.append("cookie 'Cookie51Visited' not found. <br>You didn,t visit below page: <br>")
                    .append(link);
        } else {
            wr
                    .append("cookie 'Cookie51Visited' found <br>")
                    .append("but now it is going to be deleted <br>");
            CookieService.deleteCookie(response, "Cookie51Visited");
            wr.append("it's done. <br>Welcome on Cookie52 page.");

        }

    }
}
