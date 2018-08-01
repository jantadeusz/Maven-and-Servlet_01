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

@WebServlet(name = "Cookie1Delete",urlPatterns = "/deleteCookie")
public class Cookie1Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Writer wr = response.getWriter();
        Cookie cookie = CookieService.getByName(request.getCookies(), "User");

        if (cookie == null) {
            wr.append("Cookie not exist");
        } else {
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
            CookieService.deleteCookie(response, "User");
            wr.append("Cookie deleted");
        }

    }
}
