package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = {"/Get62"})
public class Get62 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        String year = request.getParameter("year");
        Random gen = new Random();
        int counter = 0;
        try {
            while (counter < 5) {
                String mix = String.valueOf(gen.nextInt(20) - 10);
                wr.append("<a href='/Get63?year=" + year + "&mix=" + mix + "'> Rok = " + year + ", mix= " + mix + " </a>");
                wr.append("<br>");
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
