package pl.coderslab.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

public class ShoppingCart {
    Product[] products = new Product[0];


    public boolean productIsInCart(Product product) {
        boolean productInCart = false;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].getId() == product.getId()) {
                productInCart = true;
            }
        }
        return productInCart;
    }

    public boolean idIsInCart(int id) {
        boolean idIsInCart = false;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].getId() == id) {
                idIsInCart = true;
            }
        }
        return idIsInCart;
    }

    public void addProductToCart(Product objectP) {
        if (productIsInCart(objectP)) {
            int index = Arrays.asList(this.products).indexOf(objectP);
            this.products[index].changeQuantity(objectP.getQuantity());
        } else {
            int number = this.products.length;
            this.products = Arrays.copyOf(this.products, number + 1);
            this.products[number] = objectP;
        }
    }

    public void removeSpecificProduct(Product objectP) {
        if (!productIsInCart(objectP)) {
            System.out.println("There is no such product in cart.");
        } else {
            int index = Arrays.asList(this.products).indexOf(objectP);
            int objectQuantity = objectP.getQuantity();
            this.products[index].changeQuantity(-objectQuantity);
            if (this.products[index].getQuantity() == 0) {
                Product[] newProducts = new Product[this.products.length - 1];
                int k = 0;
                for (int i = 0; i < this.products.length; i++) {
                    if (this.products[i].getId() == objectP.getId()) {
                        System.out.println("Product has been removed from cart.");
                        k++;
                    } else {
                        newProducts[i - k] = this.products[i];
                    }
                }
                this.products = newProducts;
                objectP.changeQuantity(objectQuantity); // line needed to stay removed object with proper quantity
            }
        }
    }

    public void removeProduct(int productId) {
        if (idIsInCart(productId)) {
            Product[] newProducts = new Product[this.products.length - 1];
            int k = 0;
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i].getId() == productId) {
                    System.out.println("All products with id: " + productId + " has been removed from cart.");
                    k++;
                } else {
                    newProducts[i - k] = this.products[i];
                }
            }
            this.products = newProducts;
        }
    }

    public void printReceipt() {
        System.out.println("\n------------------------------------------------*** RECEIPT START ***");
        double toPay = 0;
        if (this.products.length > 0) {
            for (int j = 0; j < this.products.length; j++) {
                System.out.println(
                        this.products[j].getId() + ". " +
                                this.products[j].getName() + " " +
                                this.products[j].getQuantity() + " x " +
                                this.products[j].getPrice() + " = " +
                                this.products[j].getTotalSum()
                );
                toPay += this.products[j].getTotalSum();
            }
        } else {
            System.out.println("Cart is empty.");
        }
        System.out.println("---");
        System.out.println("You pay: " + toPay + " ------------------------------------*** RECEIPT E N D ***");
    }

    public void printReceiptInBrowser(PrintWriter writer) {
        writer.append("<br>------------------------------------------------*** RECEIPT START ***");
        double toPay = 0;
        if (this.products.length > 0) {
            for (int j = 0; j < this.products.length; j++) {
                writer.append("<br>" +
                        this.products[j].getId() + ". " +
                        this.products[j].getName() + " " +
                        this.products[j].getQuantity() + " x " +
                        this.products[j].getPrice() + " = " +
                        this.products[j].getTotalSum()
                );
                toPay += this.products[j].getTotalSum();
            }
        } else {
            writer.append("Cart is empty.");
        }
        writer.append("<br>---");
        writer.append("<br>You pay: " + toPay + " ------------------------------------*** RECEIPT E N D ***");
    }


}
