package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

@WebServlet(name = "Sess03_All", urlPatterns = "/showAllSession")
public class Sess03_All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Enumeration keys = session.getAttributeNames();
        // stream jest w java 8 "odpowuednikiem" - moze go zastepowac enumeration
        Writer wr = response.getWriter();

        wr.append("Content of session: ");
        while (keys.hasMoreElements()) {
            String actualKey = (String) keys.nextElement();
            String valueKey = (String) session.getAttribute(actualKey);

            wr.append("<br>Key: " + actualKey + " , value: " + valueKey);
        }
        wr.append("<br>--------------------------------------------");
        wr.append("<br><a href='http://localhost:8080/addToSession'> Add next element </a>");


        // sortowanie metoda lambda


    }
}
