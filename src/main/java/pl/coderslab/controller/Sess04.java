package pl.coderslab.controller;

import pl.coderslab.Model.Product;
import pl.coderslab.Model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sess04", urlPatterns = "/sess04")
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // todo obczaj czym jest sesja czy to mapa/ciag btow, comment: para klucz wartość, z tym że wartość jest obiektem - a to ardzo szerokie pojecie i tym samym duze mozliwosci
        // todo add validation, final comment: class Shopping Cart from previous module validates evrything inside through methods
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        Product newProduct = new Product(name, "no description", price, quantity);

        // w pierwotnej wersji zadania byla operacja na tablicy produktow ale ja zmodyfikowalem tak zeby
        // wykorzystac klasy z modulu programowanie obiektowe
//        session.setAttribute("productname1", product);
//        Product[] products = (Product[]) session.getAttribute("products");

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }

        shoppingCart.addProductToCart(newProduct);
        session.setAttribute("shoppingCart", shoppingCart);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

//        stream zastepuje if null i else rob foreach dla wszystkich wyciagnietych
//        Arrays.stream(products).forEach(el -> writer.append("name: " + el.getName() + " | " + el.getQuantity() + " | " + el.getPrice()));

        if (shoppingCart == null) {
            writer.append("Cart is empty");
        } else {
            shoppingCart.printReceiptInBrowser(writer);
        }
        writer.append("<br><br><a href='http://localhost:8080/index_04.html'> Click here to add next product </a>");
    }
}


/*
Zadanie 4
W projekcie stwórz servlet Sess 04 oraz stronę HTML index_04.html. Następnie:

Dodaj do strony formularz, zawierający jedno pole tekstowe (nazwa) oraz dwa pola liczbowe (ilość i cena) służące do dodawania produktu do koszyka. Formularz powinien przekierować do servletu metodą POST.
Po odebraniu danych POST w servelecie, dodaj do sesji przedmiot. Pamiętaj, że przedmiotów będzie więcej, więc użyj do tego tablicy.
Dodaj do servletu funkcjonalność, która wyświetli zawartość naszego koszyka. Zawartość ma być wyświetlana zarówno w przypadku wejścia metodą GET, jak i metodą POST.
Przykładowy koszyk:

Produkt 1 - 4 x 5.20zł = 20.80zł
Produkt 2 - 1 x 9.99zł =  9.99zł
Produkt 3 - 1 x 2.20zł =  2.20zł
                   SUMA: 32.99zł


 // obczaj jak wyglada naglowek strony dosteny w opcjach dev w browser z i bez ciasteczka
        // z bibliteki Cookie uzyj cookie new podstawowe komendy bez metod narazie
        // przechowywanie danych w cisteczki dot. mapamietaj nie na sronie zeby nie bylo potrzebne kolejne logowanie
        // jako zmiennych sesyjnych uzywaj typow sparametryzowanych np dla String. w tym zadaniu dla Product
        // List<String> lista = new ArrayList<String>();



 */
