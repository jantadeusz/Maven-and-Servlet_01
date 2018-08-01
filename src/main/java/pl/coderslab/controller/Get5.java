package pl.coderslab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get5", urlPatterns = {"/get5"})
public class Get5 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Map<String, String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();
        Writer wr = response.getWriter();

        wr.append("<ul style='list-style-type:none'>");
        for (String key : keys) {
            wr.append("<li>" + key + "</li>");
            wr.append("<ul style='list-style-type:disc'>");
            for (int i = 0; i < params.get(key).length; i++) {
                wr.append("<li>" + params.get(key)[i] + "</li>");
            }
            wr.append("</ul>");
        }
        wr.append("</ul>");


    }
}
