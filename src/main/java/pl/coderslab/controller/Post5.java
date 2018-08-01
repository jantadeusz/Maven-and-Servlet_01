package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post5", urlPatterns = {"/post5"})
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        try {
            Double degrees = Double.parseDouble(request.getParameter("degrees"));
            String convType = request.getParameter("convertionType");
            if (convType.equals("CelcToFahr")) {
                double result = degrees * 1.8 + 32;
                wr.append("Conversion from Celcius to Fahrenheit degree: : " + degrees.toString() + "*C = " + Double.toString(result) + "*F");
            } else if (convType.equals("FahrToCelc")) {
                double result = (degrees - 32) / 1.8;
                wr.append("Conversion from Fahrenheit to Celcius degree: " + degrees.toString() + "*F = " + Double.toString(result) + "*C");
            }
        } catch (NumberFormatException e) {
            wr.append("Nie podano wlasciwej liczby.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
