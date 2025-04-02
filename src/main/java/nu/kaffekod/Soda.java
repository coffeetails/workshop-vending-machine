package nu.kaffekod;

public class Soda extends Product {
    private boolean carbonated;


    public Soda(String productName, double price, boolean carbonated) {
        super(productName, price);
        setCarbonated(carbonated);
    }


    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }


    @Override
    public String examine() {
        return "";
    }

    @Override
    public String use() {
        return "\nproductName: " + getProductName() + "\nprice: " + getPrice() + "\ncarbonated: " + isCarbonated() + "\nid: " + getId();
    }
}

