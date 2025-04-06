package nu.kaffekod.products;

import nu.kaffekod.Product;

public class Chips extends Product {
    private boolean ribbed;


    public Chips(String productName, double price, boolean ribbed) {
        super(productName, price);
        this.ribbed = ribbed;
    }


    @Override
    public String use() {
        return " * crunch crunch * potatoes ARE a veggie, I'm eating a salad";
    }

    @Override
    public String examine() {
        String ribbedInfo = ", isn't ribbed ";
        if (this.ribbed) {
            ribbedInfo = ", is ribbed ";
        }
        return getId() +". " + getProductName() + ribbedInfo + getPrice() + ":-";
    }
}

