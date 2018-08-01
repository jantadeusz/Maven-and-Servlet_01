package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get3", urlPatterns = {"/get3"})
public class Get3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();
        int width;
        int height;

        try {

            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));

        } catch (NumberFormatException e) {

            width = 5;
            height = 10;
        }

        wr.print("    ");
        for (int k = 1; k <= width; k++) {
            wr.print(" " + k);
        }
        wr.println("<br>");
        for (int i = 1; i <= height; i++) {
            wr.println("row " + i + ": ");
            for (int j = 1; j <= width; j++) {
                wr.println(" " + i * j);
            }
            wr.println("<br>");
        }


    }
}
