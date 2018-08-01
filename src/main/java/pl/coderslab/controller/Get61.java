package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get61", urlPatterns = {"/Get61"})
public class Get61 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        try {
            for (int i = 1980; i < 2011; i++) {
                String linki = String.valueOf(i);
                wr.append("<a href='/Get62?year=1980'> Go to servlet Get62 webpage with year -> " + linki + " </a>");
                wr.append("<br>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
