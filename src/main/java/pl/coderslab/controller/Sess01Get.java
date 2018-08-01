package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Sess01Get", urlPatterns = "/sess01get")
public class Sess01Get extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession sess = request.getSession();
        Writer wr = response.getWriter();
        Integer counter = (Integer) sess.getAttribute("counter");
        if (counter == null) {
            wr.append("Conter not exists");
        } else {
            wr.append("Counter: ").append(String.valueOf(counter));
            sess.setAttribute("counter", ++counter);
        }

    }
}
