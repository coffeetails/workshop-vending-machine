package nu.kaffekod;

// ASK ABOUT INT AND DOUBLES

public abstract class Product {
    private static int sequenser = 0;
    private int id;
    private double price;
    private String productName;


    public Product(String productName, double price) {
        setProductName(productName);
        setPrice(price);
        this.id = getNextId();
    }


    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private static int getNextId() {
        return ++sequenser;
    }

    public abstract String examine();
    public abstract String use();
}
