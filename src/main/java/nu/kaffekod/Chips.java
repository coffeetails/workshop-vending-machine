package nu.kaffekod;

public class Chips extends Product {
    private boolean ribbed;


    public Chips(String productName, double price, boolean ribbed) {
        super(productName, price);
        setRibbed(ribbed);
    }


    public boolean isRibbed() {
        return ribbed;
    }

    public void setRibbed(boolean ribbed) {
        this.ribbed = ribbed;
    }


    @Override
    public String examine() {
        return "";
    }

    @Override
    public String use() {
        return "\nproductName: " + getProductName() + "\nprice: " + getPrice() + "\nribbed: " + isRibbed() + "\nid: " + getId();
    }
}

