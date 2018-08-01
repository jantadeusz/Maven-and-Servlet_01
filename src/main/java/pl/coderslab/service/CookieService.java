package pl.coderslab.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

public class CookieService {

    /**
     * Get cookie object by name or null if not found
     *
     * @param cookies    array
     * @param cookieName
     * @return Cookie or Null if not found
     */
    public static Cookie getByName(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName)) {
                    return c;
                }
            }
        }
        return null;
    }

    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue) throws Exception {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        response.addCookie(cookie);
    }

    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue, int age) throws Exception {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(age);
        response.addCookie(cookie);
    }

    public static void cookieAdd(HttpServletResponse response, String cookieName, String cookieValue, int age, String path) throws Exception {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(age);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

//    public static Cookie[] getCookies(HttpServletRequest request) {
//
//        Cookie[] cookies = request.getCookies();
//        for (Cookie c : cookies) {
//            c.getName();
//
//        }
//
//
//    }

}