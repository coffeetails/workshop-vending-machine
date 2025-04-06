package nu.kaffekod;

// Allowed currencies: 1,2,5,10,20,50,100,200,500,1000

import nu.kaffekod.products.Chips;
import nu.kaffekod.products.Snackbar;
import nu.kaffekod.products.Soda;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int[] acceptableCurrencies = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    public static int notValidMenu = -1;

    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) throws InterruptedException {
        Product[] addProducts = new Product[]{
            new Soda("Coola Coola", 25, true),
            new Chips("Smooth Dill", 30, false),
            new Snackbar("Snacky Bee", 18, false),
            new Snackbar("Hangry Bee", 18.99, true, NutType.cashew)
        };

        VendingMachineImpl stationMachine = new VendingMachineImpl(addProducts);
        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;
        String userInput =  "";
        int userInputInt = notValidMenu;


        do {
            showMainMenu();
            userInput = scanner.nextLine();
            userInputInt = checkUserInput(userInput, "Please choose a menu item by typing 1, 2, 3, 4 or 0: ");

            textDivider();
            switch (userInputInt) {
                case 1: {
                    System.out.println(CYAN + "Purchase products: ");
                    Product[] products = stationMachine.getProducts();
                    displayProducts(products);

                    userInput = scanner.nextLine();
                    userInputInt = checkUserInput(userInput, "Please enter numbers only. ");
                    --userInputInt; //avoid off by one error
                    if (userInputInt != notValidMenu && userInputInt < products.length) {
                        int deposit = stationMachine.getDepositPool();
                        double price = products[userInputInt].getPrice();
                        if (deposit >= price) {
                            int newDeposit = deposit - (int) price;
                            stationMachine.setDepositPool(newDeposit);
                            System.out.println("You bought: " + products[userInputInt].getProductName());
                            System.out.println("Your deposit is now: " + stationMachine.getDepositPool());
                            System.out.println(GREEN + products[userInputInt].use());
                        } else {
                            System.out.println(YELLOW + "Sorry, your balance is too low.");
                            System.out.println("Your balance: " + deposit);
                            System.out.println("Price: " + price);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println(PURPLE + "Examine products: ");
                    Product[] products = stationMachine.getProducts();
                    displayProducts(products);

                    userInput = scanner.nextLine();
                    userInputInt = checkUserInput(userInput, "Please enter numbers only. ");
                    --userInputInt; //avoid off by one error
                    if (userInputInt != notValidMenu && userInputInt < products.length) {
                        System.out.println(PURPLE + products[userInputInt].examine());
                    } else {
                        System.out.println(YELLOW + "Please choose an existing product");
                    }
                    break;
                }
                case 3: {
                    System.out.println(CYAN + "Acceptable currencies: " + Arrays.toString(acceptableCurrencies));
                    System.out.print(PURPLE + "Add currency: ");
                    userInput = scanner.nextLine();
                    userInputInt = checkUserInput(userInput, "Please enter numbers only. ");
                    if (userInputInt != notValidMenu) {
                        stationMachine.addCurrency(Integer.parseInt(userInput));
                    }
                    break;
                }
                case 4: {
                    System.out.println(PURPLE + "Your balance is: " + stationMachine.getBalance());
                    break;
                }
                case 0: {
                    System.out.println(YELLOW + "Returning deposit of " + stationMachine.endSession() + " and exiting");

                    System.out.println(
                        " /\\_/\\   (\\ __ /)   A__A\n" +
                        "( ˶•o•˶) ( •ω• )  (•⤙• )\n" +
                        "ଘ(ა\uD83C\uDF6A)   (ა\uD83E\uDD64૮)｡  (\uD83C\uDF6B٩  )੭"
                    );
                    // 🍫 \uD83C\uDF6B
                    // 🥤 \uD83E\uDD64
                    // 🍪 \uD83C\uDF6A

                    runProgram = false;
                    break;
                }
                default: {
                    System.out.println(YELLOW + "Please choose a menu item by typing 1, 2, 3, 4 or 0: ");
                    break;
                }
            }
            textDivider();
        } while (runProgram);

    }

    private static void showMainMenu() {
        System.out.print(
            CYAN + "~~ Vending ~ Machine ~~\n" +
            PURPLE + "[1] Purchase products\n" +
            "[2] Examine products\n" +
            "[3] Add currency\n" +
            "[4] Check balance\n" +
            "[0] Get currency and exit\n" +
            "Please choose a menu option: "
        );
    }

    private static void textDivider() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(250);
        System.out.print(CYAN + "~~ ");
        TimeUnit.MILLISECONDS.sleep(250);
        System.out.print(CYAN + "~~~~~~~ ~");
        TimeUnit.MILLISECONDS.sleep(250);
        System.out.print(CYAN + "~~~~~~~");
        TimeUnit.MILLISECONDS.sleep(250);
        System.out.print(CYAN + " ~~\n");
        TimeUnit.MILLISECONDS.sleep(250);
    }

    private static void displayProducts(Product[] products) {
        for(Product product : products) {
            System.out.printf("[%o]  %s  %.2f:-\n", product.getId(), product.getProductName(), product.getPrice());
        }
    }

    private static int checkUserInput(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            System.out.println(YELLOW + errorMessage + e);
            return -1;
        }
    }

}