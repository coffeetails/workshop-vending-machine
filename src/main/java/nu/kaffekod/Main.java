package nu.kaffekod;

// Allowed currencies: 1,2,5,10,20,50,100,200,500,1000

public class Main {
    public static void main(String[] args) {
        Soda coolaCola = new Soda("Coola Coola", 25, true);
        Chips smoothDill = new Chips("Smooth Dill", 30, false);
        Snackbar snackyBee = new Snackbar("Snacky Bee", 18, false);
        Snackbar hangryBee = new Snackbar("Hangry Bee", 18, true, NutType.cashew);

        System.out.println(coolaCola.use());
        System.out.println(smoothDill.use());
        System.out.println(snackyBee.use());
        System.out.println(hangryBee.use());
    }
}