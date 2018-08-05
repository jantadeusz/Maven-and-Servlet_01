package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Sess05", urlPatterns = "/sess05")
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        int sum = Integer.parseInt(request.getParameter("sum"));
        int captcha = (int) session.getAttribute("captcha");

        if (captcha == sum) {
            writer.append("Podano poprawny wynik działania.");
        } else {
            writer.append("Podano niepoprawny wynik działania.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Random generator = new Random();

        int num1 = generator.nextInt(101);
        int num2 = generator.nextInt(101);
        session.setAttribute("captcha", num1 + num2);

        writer.append("<h2>Week 04 Sessions Exercise 05: create captcha </h2>\n" +
                "\n" +
                "<form action=\"/sess05\" method=\"post\">\n" +
                "  Uzupełnij wynik działania:" + num1 + " + " + num2 + "=<br>" +
                "  <input type=\"text\" name=\"sum\">\n" +
                "  <input type=\"submit\" value=\"Zrobione\">" +
                "</form> ");
    }
}
/*
Zadanie 5
W projekcie stwórz servlet Sess05. Następnie:
Dodaj do niego formularz z 3 polami tekstowymi (imię, nazwisko, mail) oraz polem numerycznym, do którego będzie wpisywana captcha: wynik działania matematycznego.
Nad polem numerycznym do wpisania zabezpieczenia widnieje informacja: Wpisz poniżej sumę {liczba1} + {liczba2}. Liczby powinny być losowe z zakresu od 0 do 100. Servlet powinien obliczyć sumę tych liczb i zapisać wynik do sesji pod kluczem captcha
Po przesłaniu formularza aplikacja sprawdzi czy wpisany przez użytkownika wynik zgadza się z tym z sesji i wyświetli odpowiedni komunikat.
 */
