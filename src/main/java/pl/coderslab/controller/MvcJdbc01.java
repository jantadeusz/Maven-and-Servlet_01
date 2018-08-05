package pl.coderslab.controller;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MvcJdbc01", urlPatterns = "/mvcJdbc01")
public class MvcJdbc01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Book newBook = new Book();
            newBook.setTitle(request.getParameter("title"));
            newBook.setAuthor(request.getParameter("author"));
            newBook.setIsbn(request.getParameter("isbn"));

            BookDao.save(newBook);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// po odpaleniu moze wywalac blad:
        //The server time zone value 'CEST' is unrecognized or represents more than one time zone. You must configure
        // either the server or JDBC driver (via the serverTimezone configuration property) to use a
        // more specifc time zone value if you want to utilize time zone support.
        // rozwiązanie to:

        String query = "CREATE TABLE IF NOT EXISTS books (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    title VARCHAR(255),\n" +
                "    author VARCHAR(255),\n" +
                "    isbn VARCHAR(50)\n" +
                ");";
        try {
            DbService.executeQuery(query, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        getServletContext().getRequestDispatcher("/META-INF/views/books/form.jsp").forward(request, response);

    }
}
