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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Sess06", urlPatterns = "/sess06")
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        int sum = Integer.parseInt(request.getParameter("sum"));
        int sub = Integer.parseInt(request.getParameter("substract"));
        int mul = Integer.parseInt(request.getParameter("multiply"));
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        String equation1 = "<br>" + num1 + " + " + num2 + " = " + sum + " | " + checkEquation(num1, num2, sum, "+");
        String equation2 = "<br>" + num1 + " - " + num2 + " = " + sub + " | " + checkEquation(num1, num2, sub, "-");
        String equation3 = "<br>" + num1 + " * " + num2 + " = " + mul + " | " + checkEquation(num1, num2, mul, "*");
        String equation4 = "<br>" + num1 + " / " + num2 + " = " + num1 / num2 + " | " + checkEquation(num1, num2, num1 / num2, "/");

        writer.println(equation1);
        writer.println(equation2);
        writer.println(equation3);
        writer.println(equation4);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Random generator = new Random();

        int num1 = generator.nextInt(981) + 20;
        int num2 = generator.nextInt(981) + 20;
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        writer.append("<h2>Week 04 Sessions Exercise 06: solve equations </h2>\n" +
                "<form action=\"/sess06\" method=\"post\">\n" +
                "  <br>Uzupełnij wynik działania:" + num1 + " + " + num2 + "=" +
                "  <input type=\"text\" name=\"sum\">\n" +
                "  <br>Uzupełnij wynik działania:" + num1 + " - " + num2 + "=" +
                "  <input type=\"text\" name=\"substract\">\n" +
                "  <br>Uzupełnij wynik działania:" + num1 + " * " + num2 + "=" +
                "  <input type=\"text\" name=\"multiply\">\n" +
                "  <br>" +
                "  <br><input type=\"submit\" value=\"Zrobione\">" +
                "</form> ");
    }

    public static String checkEquation(int num1, int num2, int result, String sign) {

        Matcher matcher = Pattern.compile("^[+\\-*]$").matcher(sign);
        if (!matcher.matches()) {
            return "Wrong operation sign";
        } else {
            if (sign.equals("+") && num1 + num2 == result || sign.equals("-") && num1 - num2 == result || sign.equals("*") && num1 * num2 == result) {
                return "Correct";
            } else {
                return "Wrong";
            }
        }
    }
}

/*
Zadanie 6
W projekcie stwórz servlet Sess06. Następnie:
Wylosuj w nim 2 liczby całkowite z przedziału 20-1000.
Wyświetl 3 pola do wpisania wyników działań na wylosowanych liczbach:
dodawania,
odejmowania,
mnożenia.
Po wysłaniu formularza wygeneruj stronę, która sprawdzi wpisane przez nas wyniki i przedstawi je w postaci:
20	+	3	=	23	Correct
20	-	3	=	17	Correct
20	*	3	=	89	Wrong
Hint: w sesji zapamiętaj liczby, a nie wyniki - dzięki temu będziesz trzymać jedną zmienną mniej.
 */