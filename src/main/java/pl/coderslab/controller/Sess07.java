package pl.coderslab.controller;

import pl.coderslab.Model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Sess07", urlPatterns = "/sess07")
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        String answer = request.getParameter("answer");
        Country[] neighbours = (Country[]) session.getAttribute("neighbours");
        String[] answers = (String[]) session.getAttribute("answers");
        Integer points = (Integer) session.getAttribute("points");

        // najlepiej w metody to wrzucic zeby skrocic np obiekt Quiz ktory bedzie trzynal info o answer i points--------
        int indexOfQuestion = answers.length;
        if (neighbours[indexOfQuestion].getCapital().equals(answer)) points++; // check if correct answer and give point
        answers = Arrays.copyOf(answers, answers.length + 1); // assign answer to table
        answers[indexOfQuestion] = answer;
        // koniec metod ----------------------------------------------------

        session.setAttribute("answers", answers);
        session.setAttribute("points", points);

        if (answers.length == neighbours.length) {
            writer.println("<br>Udzielono " + points + " poprawnych odpowiedzi.");
            writer.println("Koniec sesji.");
            session.invalidate();

        } else {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        String[] countries = {"Niemcy", "Czechy", "Słowacja", "Ukraina", "Białoruś", "Litwa", "Rosja"};
        String[] capitals = {"Berlin", "Praga", "Bratyslawa", "Kijow", "Minsk", "Wilno", "Moskwa"};

        Country[] neighbours = (Country[]) session.getAttribute("neighbours");

        try {
            if (neighbours == null) neighbours = createNeighbours(countries, capitals);
            session.setAttribute("neighbours", neighbours);
//            for (int i = 0; i < neighbours.length; i++) {
//                writer.println("<br> Kraj: " + neighbours[i].getName() + ", stolica: " + neighbours[i].getCapital()); // pomocniczo dla sprawdzenia
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] answers = (String[]) session.getAttribute("answers");
        if (answers == null) answers = new String[0];

        Integer points = (Integer) session.getAttribute("points");
        if (points == null) points = 0;

        writer.append("<h2>Week 04 Sessions Exercise 07 - quiz </h2>\n" +
                "\n" +
                "<form action=\"/sess07\" method=\"post\">\n" +
                "  Wpisz nazwę stolicy kraju: " + neighbours[answers.length].getName() + " (nie używaj polskich znaków)" +
                "  <br>\n" +
                "  <input type=\"text\" name=\"answer\">\n" +
                "  <input type=\"submit\" value=\"Dalej\">\n" +
                "</form> ");

        session.setAttribute("answers", answers);
        session.setAttribute("points", points);
    }

    public static Country[] createNeighbours(String[] countries, String[] capitals) throws Exception {

        Country[] result = new Country[0];
        if (countries.length != capitals.length) {
            throw new Exception("Wrong number of countries or capitals");
        } else {
            for (int i = 0; i < countries.length; i++) {
                Country tmp = new Country(countries[i], capitals[i]);
                result = Arrays.copyOf(result, result.length + 1);
                result[i] = tmp;
            }
            return result;
        }
    }
}

/*
Zadanie 7
W projekcie stwórz servlet Sess07. Następnie:
Przygotuj sobie tablicę z nazwami krajów sąsiadujących z Polską i ich stolicami.
Po uruchomieniu servletu na serwerze, wyświetl formularz z zapytaniem o stolicę sąsiadującego z Polską państwa.
W postaci: Podaj stolicę dla państwa: Niemcy
Po przesłaniu odpowiedzi, system zweryfikuje poprawność odpowiedzi i wyświetli odpowiedni komunikat oraz ponownie
wyświetli pytanie o kolejne państwo.
Po wyświetleniu wszystkich pytań wyświetli się wynik naszego quizu z informacją o liczbie poprawnych odpowiedzi:
Poprawnych odpowiedzi: 4.
Hint: To zadanie będzie miało podobny algorytm działania co zadanie 6 - wzoruj się na nim.
 */
