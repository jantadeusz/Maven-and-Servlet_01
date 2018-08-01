package pl.coderslab.controller;

import pl.coderslab.service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3", urlPatterns = "/addCookieWithAge")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieName = request.getParameter("key");
        String cookieValue = request.getParameter("value");
        String cookieAge = request.getParameter("selected");

        try {
            CookieService.cookieAdd(response, cookieName, cookieValue, Integer.parseInt(cookieAge) * 3600, "/");
            response.getWriter().append("Cookie added");
        } catch (Exception e) {
            response.getWriter().append("Error: " + e.getMessage());

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
