package nu.kaffekod.products;

import nu.kaffekod.NutType;
import nu.kaffekod.Product;

public class Snackbar extends Product {
    private boolean nuts;
    private NutType nutType;


    public Snackbar(String productName, double price, boolean nuts, NutType nutType) {
        this(productName, price, nuts);
        this.nutType = nutType;
    }

    public Snackbar(String productName, double price, boolean nuts) {
        super(productName, price);
        this.nuts = nuts;
    }


    @Override
    public String use() {
        return " snacks on snackbar, yum!";
    }

    @Override
    public String examine() {
        String nutInfo = ", no nuts ";
        if (this.nuts) {
            nutInfo = ", with " + this.nutType + " ";
        }
        return getId() +". " + getProductName() + nutInfo + getPrice() + ":-";
    }
}

