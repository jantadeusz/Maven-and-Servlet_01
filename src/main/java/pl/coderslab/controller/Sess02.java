package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

@WebServlet(name = "Sess02", urlPatterns = "/sess02")
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        Double[] grades = (Double[]) sess.getAttribute("grades");
        if(grades == null)
            grades = new Double[0];

        try {
            double grade = Double.parseDouble(request.getParameter("grade"));
            if(grade<1 || grade>6) throw new Exception("Wrong value");

            grades = Arrays.copyOf(grades,grades.length+1);
            grades[grades.length-1] = grade;

            sess.setAttribute("grades",grades);

        }catch(Exception e){
            response.getWriter().append(e.getMessage());
        }

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();
        HttpSession sess = request.getSession();


        wr.append(" <form method=\"post\" action=\"/sess02\">\n" +
                "        <input type=\"text\" name=\"grade\" placeholder='grade'>\n" +
                "        <input type=\"submit\" value=\"Add\">\n" +
                "    </form>");


        Double[] grades = (Double[]) sess.getAttribute("grades");
        if(grades!=null) {
            double sum = 0;
            wr.append("<h3>Grades</h3>");
            wr.append("<ul>");
            for(Double grade : grades){
                sum += grade;
                wr.append("<li>").append(String.valueOf(grade)).append("</li>");
            }
            wr.append("</ul>");
            wr.append("Avg: ").append(String.valueOf(sum/grades.length));
        }

    }
}
