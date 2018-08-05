package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")//, urlPatterns = "/*") potem to odblokuj jak skuasz
public class EncodingFilter implements Filter {
    public void destroy() {


    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("filter is alive");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        HttpServletRequest request = (HttpServletRequest) req; //rzutowanie na HTTPrequest
        System.out.println(request.getHeader("User-Agent"));// przechwytywanie iniformacji


        HttpSession sess = request.getSession();
        if (sess.getAttribute("user") == null) {
            ((HttpServletResponse) resp).sendRedirect("http://google.com");
            return;


        }

        // wszystko przed ponizsza linijka zawierasz
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
// zadanie 4 nuwy filtr musisz stworzyc
// jak nie ma chain to tylko jeden filtr zadziała
