package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "Cookie7", urlPatterns = "/rememberMe")
public class Cookie7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String firstname = request.getParameter("firstname");
        String remember = request.getParameter("remember");
        if (remember == null) {
            writer.append("Hi " + firstname + " ,nice to meet you :)");
        } else {
            Cookie cookie = new Cookie("UserName", firstname);
            response.addCookie(cookie);
            writer.append("Your name: " + firstname + " was saved to cookie.");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        Cookie[] cookies = request.getCookies();

        boolean flag = false;

        for (Cookie c : cookies) {
            if (c.getName().equals("UserName")) {
                String firstname = c.getValue();
                writer.append("Hi " + firstname + " . Your name was obtained from cookie.");
                flag = true;
            }
        }

        if (!flag) {
            writer.append("<h2>Week 04 Cookies Exercise 07</h2>\n" +
                    "\n" +
                    "<form action=\"/rememberMe\" method=\"post\">\n" +
                    "  First name:<br>\n" +
                    "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">\n" +
                    "  <br>\n" +
                    "    <label> remember me - create cookie </label>\n" +
                    "  <input type=\"checkbox\" name=\"remember\" value=\"1\"/>\n" +
                    "<br>\n" +
                    "  <input type=\"submit\" value=\"Submit\">\n" +
                    "</form> ");
        }
    }
}
