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

@WebServlet(name = "Mvc15",urlPatterns = "/Mvc15")
public class Mvc15 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();// tworzy ciasteczko jsessionid jezeli ej nie bylo

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        Book book = new Book(title, author, isbn);

//        session
        List<Book> books = (List<Book>) session.getAttribute("books");
        //create if not exist in session
        if (books == null)
            books = new ArrayList<>();

        books.add(book);
        session.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/META-INF/views/mvc15_result.jsp")
                .forward(request, response);
//        Double[] grades = (Double[]) sess.getAttribute("grades");


//        for (int i = 0; i < 5; i++) {
//            String title = request.getParameter("title" + i);
//            String author = request.getParameter("author" + i);
//            String isbn = request.getParameter("isbn" + i);
//            Book book = new Book(title, author, isbn);
//            books.add(book);
//        }
// jak sortujesz liste siedzaca w sesji to sortujesz ja tylko na potrzeby widoku a
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/META-INF/views/mvc15.jsp")
                .forward(request, response);

    }
}
