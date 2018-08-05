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

@WebServlet(name = "Mvc15_DL", urlPatterns = "/mvc15_dl")
public class Mvc15_DL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = new Book();
        book.setTitle( request.getParameter("title") );
        book.setAuthor( request.getParameter("author") );
        book.setIsbn( request.getParameter("isbn") );

        HttpSession sess = request.getSession();
        List<Book> books = (List<Book>) sess.getAttribute("books");
        //If attribute not in session than initiate List
        if(books == null) books = new ArrayList<>();

        books.add(book);
        sess.setAttribute("books", books);

        response.sendRedirect("/mvc15/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/book/form.jsp").forward(request, response);
    }
}