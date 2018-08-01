package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get1", urlPatterns = {"/get1"})
public class Get1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter wr = response.getWriter();
        try {
            int start = Integer.parseInt(request.getParameter("start"));
            int end = Integer.parseInt(request.getParameter("end"));
            for (int i = start; i < end; i++) {
                wr.println("<p>" + i + "</p");
            }

        } catch (Exception e) {
            wr.println("brak danych");
        }


    }
}

// wpisujesz w przegladarke taki ciag znakow zeby dzialalo
// http://localhost:8080/get1?start=20&end=100