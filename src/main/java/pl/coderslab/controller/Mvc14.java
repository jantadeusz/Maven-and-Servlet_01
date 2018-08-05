package pl.coderslab.controller;

import pl.coderslab.Model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Mvc14", urlPatterns = "/Mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String title = request.getParameter("title" + i);
            String author = request.getParameter("author" + i);
            String isbn = request.getParameter("isbn" + i);
            Book book = new Book(title, author, isbn);
            books.add(book);
        }

        request.setAttribute("ksiazki", books);
        getServletContext().getRequestDispatcher("/META-INF/views/mvc14_result.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/META-INF/views/mvc14.jsp")
                .forward(request, response);

    }
}
