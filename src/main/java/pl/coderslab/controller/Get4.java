package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;

@WebServlet(name = "Get4", urlPatterns = {"/get4"})
public class Get4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        try {
            int value = Integer.parseInt(request.getParameter("page"));
            wr.append("<h2> Dividers for ").append(String.valueOf(value)).append("</h2>");
            for (int i = 1; i < value; i++) {
                if (value % i == 0) {
                    wr.append("<p>").append(String.valueOf(i)).append("<p>");
                }
            }
        } catch (Exception e) {
            wr.append("<h4>brak danych</h4>");
        }
    }
}
