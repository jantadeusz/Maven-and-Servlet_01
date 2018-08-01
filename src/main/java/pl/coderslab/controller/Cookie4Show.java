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

@WebServlet(name = "Cookie4Show", urlPatterns = "/cookie4Show")
public class Cookie4Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            String link = "<a href='/cookie4Del?name=" + c.getName() + "'>" + " here " + "</a>";
            wr
                    .append("Cookie name: ")
                    .append(c.getName())
                    .append(" , cookie value: ")
                    .append(c.getValue())
                    .append(" | to detele this cookie click link -> ")
                    .append(link)
                    .append("<br>");

//            String cookieName = c.getName();
//            wr.append()
//                    .append(cookieName)
//                    .append("'> delete cookie with name: ")
//                    .append(cookieName)
//                    .append(" - value: ")
//                    .append(c.getValue())
//                    .append("</a><br>");
        }
    }
}

// try to understand this in home

