package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Sess03_Add", urlPatterns = "/addToSession")
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String attributeName = request.getParameter("key");
        String attributeValue = request.getParameter("value");
        session.setAttribute(attributeName, attributeValue);
        Writer wr = response.getWriter();
        wr.append("<a href='http://localhost:8080/addToSession'> Add next element </a>");
        wr.append("<br><a href='http://localhost:8080/showAllSession'> Show all elements </a>"); // todo: 3get servlet context
        //todo dodaj do setu

//        if (session.isNew()) {
//            response.getWriter().append("session is new");
//            session.setAttribute("counter", 1);
//        } else {
//            response.getWriter().append("not new");
//            int counter = (int) session.getAttribute("counter") + 1;
//            session.setAttribute("counter", counter);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();


        HttpSession sess = request.getSession();
        
//        String[] keys = (String[]) sess.getAttribute("keys");

        if (sess.isNew()) {
            wr.append("session is new");
//            wr.append("Set created");
        } else {
            wr.append("session is not new");
        }

        wr.append("<form action=\"#\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");


    }
}
