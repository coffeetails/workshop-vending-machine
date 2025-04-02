package nu.kaffekod;

public class Snackbar extends Product {
    private boolean nuts;
    private NutType nutType;


    public Snackbar(String productName, double price, boolean nuts, NutType nutType) {
        this(productName, price, nuts);
        setNutType(nutType);
    }

    public Snackbar(String productName, double price, boolean nuts) {
        super(productName, price);
        setNuts(nuts);
    }


    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public NutType getNutType() {
        return nutType;
    }

    public void setNutType(NutType nutType) {
        this.nutType = nutType;
    }


    @Override
    public String examine() {
        return "";
    }

    @Override
    public String use() {
        String nutInfo = "\nno nuts";
        if (isNuts()) {
            nutInfo = String.valueOf(getNutType());
        }
        return "\nproductName: " + getProductName() + "\nprice: " + getPrice() +  "\nnuts: " + nutInfo + "\nid: " + getId();
    }
}

