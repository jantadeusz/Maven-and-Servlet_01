package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@WebServlet(name = "Post4", urlPatterns = {"/post4"})
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        List<Double> result = new ArrayList<>();
        Writer wr = response.getWriter();

        String[] tmp = request.getParameterValues("numbers");
//        Arrays.sort(tmp); //simple approach
        for (String s : tmp) {
            try {
                Double d = Double.parseDouble(s);
                result.add(d);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

//        Collections.sort(result);// uz lepiej ale wciaz tylko dla prostych typow dzialac bedzie
        // najlepsza metoda dzialajaca na obiektach zlozonych tylko musisz zrzutowac do int
        // ponizsza konstrukcja to lambda

        result.sort((p1, p2) -> {
                    if (p2 - p1 > 0) {
                        return -1;
                    } else if (p2 - p1 == 0) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
        );
        wr.append(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();
        Random gen = new Random();

        wr.append("<form action='' method='post'>");
        for (int i = 0; i < gen.nextInt(5) + 5; i++) {
            wr.append("<input name='numbers' placeholder='numbers'/><br>");
        }
        wr.append("<input type='submit'/>");

    }

}
