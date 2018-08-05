package pl.coderslab.controller;

import pl.coderslab.Model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc15List_DL", urlPatterns = "/mvc15/list_dl")
public class Mvc15List_DL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();
        List<Book> books = (List<Book>)sess.getAttribute("books");
        if(books == null) books = new ArrayList<>();

        books.sort( (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()) );

        request.setAttribute("books", books);

        getServletContext().getRequestDispatcher("/META-INF/views/book/list.jsp")
                .forward(request, response);
    }
}