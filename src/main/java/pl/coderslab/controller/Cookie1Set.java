package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Set", urlPatterns = {"/setCookie"})
public class Cookie1Set extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("User", "CodersLab");
        cookie.setMaxAge(24 * 3600);
        cookie.setPath("/");// bedziesz mial dostep z ponizszych poziomow, podobne do dziedziczenia w klasach
        response.addCookie(cookie);

        response.getWriter().append("Cookie set");


    }
}
