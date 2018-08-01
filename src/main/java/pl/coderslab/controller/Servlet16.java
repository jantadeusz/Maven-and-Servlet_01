package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "Servlet16", urlPatterns = {"/servlet16"})
public class Servlet16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String header = getClientIpAddress(request);
        String header = request.getRemoteAddr();
        String browser = request.getHeader("User-Agent");

        response.getWriter().append("Ip: " + header + "\n" + browser + "\n" + LocalDateTime.now().toString()); // adresy ip v6 daja local 000000...1

    }

    public static String getClientIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
