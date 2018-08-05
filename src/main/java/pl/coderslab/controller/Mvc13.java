package pl.coderslab.controller;

import pl.coderslab.Model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Mvc13", urlPatterns = "/Mvc13")
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Writer wr = response.getWriter();

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book ksiazka = new Book(title, author, isbn);

//        wr.append(title);

        request.setAttribute("ksiazka", ksiazka);
//        request.setAttribute("author", author);
//        request.setAttribute("isbn", isbn);

        getServletContext().getRequestDispatcher("/META-INF/views/mvc13_result.jsp")
                .forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/META-INF/views/mvc13.jsp")
                .forward(request, response);

    }
}
