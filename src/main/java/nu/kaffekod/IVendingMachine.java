package nu.kaffekod;

public interface IVendingMachine {
    void addCurrency(int amount);
    double getBalance();
    int endSession();
    String getDescription(int id);
    Product[] getProducts();
}
