package nu.kaffekod;

import java.util.Objects;

public abstract class Product {
    int id;
    double price;
    String productName;


    public Product(String productName, double price) {
        setProductName(productName);
        setPrice(price);
        setId(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        int newId = Objects.hash(this.productName, this.price);
        if(newId < 0) {
            newId = Math.multiplyExact(newId+1, -1);
        }
        this.id = newId;
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


    public abstract String examine();
    public abstract String use();
}
