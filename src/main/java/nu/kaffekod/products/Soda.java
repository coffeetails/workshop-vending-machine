package nu.kaffekod.products;

import nu.kaffekod.Product;

public class Soda extends Product {
    private boolean carbonated;


    public Soda(String productName, double price, boolean carbonated) {
        super(productName, price);
        this.carbonated = carbonated;
    }


    @Override
    public String use() {
        return " Sluuurp, mmh, refreshing";
    }

    @Override
    public String examine() {
        String carbonatedInfo = ", isn't carbonated ";
        if (this.carbonated) {
            carbonatedInfo = ", is carbonated ";
        }
        return getId() +". " + getProductName() + carbonatedInfo + getPrice() + ":-";
    }
}

