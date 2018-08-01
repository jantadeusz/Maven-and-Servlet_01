package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get2", urlPatterns = {"/get2"})

public class Get2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");// browser recognise strings as html code
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();
        Map<String, String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();

        wr.append("<ul>");
        for(String key : keys){
            wr.append("<li>")
                    .append(key)
                    .append(" - values:")
                    .append(Arrays.toString(params.get(key)))
                    .append("</li>");
        }
        wr.append("</ul>");


    }
}

// in example type
//http://localhost:8080/get2?start=20&start=30&black=3&white=5
//http://localhost:8080/get2?start=20&end=30&black=3&white=5&green=8
