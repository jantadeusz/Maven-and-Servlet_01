package pl.coderslab.Model;

public class Product {

    private static int nextId = 1;
    private final int id;
    public String name;
    private String description;
    private double price;
    private int quantity;


    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price > 0.01) {
            this.price = price;
        } else {
            this.price = 0.01;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public void changeQuantity(int deltaQuantity) {
        if (this.quantity + deltaQuantity < 0) {
            System.out.println("Inproper quantity.");
        } else {
            this.quantity += deltaQuantity;
        }
    }

    public Double getPrice() {
        return price;
    }

    public double getTotalSum() {
        return this.price * this.quantity;
    }

    public Product(String name, String description, double price, int quantity) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        setQuantity(quantity);
    }

    public Product(String name, String description, int quantity) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        setQuantity(quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
