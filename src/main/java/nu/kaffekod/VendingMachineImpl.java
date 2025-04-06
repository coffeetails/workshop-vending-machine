package nu.kaffekod;

import java.util.Arrays;

import static nu.kaffekod.Main.*;

public class VendingMachineImpl implements IVendingMachine {
    private Product[] products;
    private int depositPool;


    public VendingMachineImpl(Product[] products) {
            setProducts(products);
    }


    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getDepositPool() {
        return depositPool;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }


    @Override
    public void addCurrency(int amount) {
        boolean validAmount = false;
        for (int currency : acceptableCurrencies) {
            if (currency == amount) {
                setDepositPool(amount + this.depositPool);
                validAmount = true;
                System.out.println("Current balance: " + getDepositPool());
                break;
            }
        }
        if(!validAmount) {
            System.out.println(YELLOW + "Amount is not valid. ");
        }
    }

    @Override
    public double getBalance() {
        return this.depositPool;
    }

    @Override
    public int endSession() {
        int tempDeposit = getDepositPool();
        setDepositPool(0);
        return tempDeposit;
    }

    @Override
    public String getDescription(int id) {
        return "";
    }
}
