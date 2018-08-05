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

@WebServlet(name = "Cookie6", urlPatterns = "/cookie6")
public class Cookie6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        try {

            String capturedBackColor = request.getParameter("backgroundColor");
            String capturedFontColor = request.getParameter("fontColor");

            Cookie backColor = new Cookie("backColor", capturedBackColor);
            Cookie fontColor = new Cookie("fontColor", capturedFontColor);
            response.addCookie(backColor);
            response.addCookie(fontColor);

            if (capturedFontColor.equals("") || capturedBackColor.equals("") || backColor == null || fontColor == null) {

                wr.append("Brak ciasteczek odpowiedzialnych za kolory. Kliknij poniższy link zeby je utworzyć");
                wr.append("<a href='http://localhost:8080/index_cookie6.html'> Create cookies </a>");

            } else {
                String cbc = capturedBackColor;
                String cfc = capturedFontColor;

                wr.append("<body style=\"background-color:" + cbc + ";\">");
                wr.append("<h1 style='color:" + cfc + ";'>" + "Kolor tekstu: " + cfc + " ,kolor tła: " + cbc +
                        " Twoje wybory zostały zapisane w ciasteczkach " + "</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        try {

            Cookie backColor = CookieService.getByName(request.getCookies(), "backColor");
            Cookie fontColor = CookieService.getByName(request.getCookies(), "fontColor");

            if (backColor != null && fontColor != null) {
                wr.append("Zapiany w cookie kolor tekstu to: " + fontColor.getValue() + " oraz tła jako: " + backColor.getValue());
            } else {
                wr.append("Brak ciasteczek odpowiedzialnych za kolory. Kliknij poniższy link zeby je utworzyć");
                wr.append("<a href='http://localhost:8080/index_cookie6.html'> Create cookies </a>");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
