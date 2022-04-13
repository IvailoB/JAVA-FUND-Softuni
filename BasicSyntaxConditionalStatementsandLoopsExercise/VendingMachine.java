package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalCoins = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            totalCoins += coins;

            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f%n", coins);
                totalCoins -= coins;
            }

            input = scanner.nextLine();
        }

        double totalMoney = 0;
        String product = scanner.nextLine();

        while (!product.equals("End")) {
            double pricePerProduct = 0;
            switch (product) {
                case "Nuts":
                    pricePerProduct = 2.0;
                    break;
                case "Water":
                    pricePerProduct = 0.7;
                    break;
                case "Crisps":
                    pricePerProduct = 1.5;
                    break;
                case "Soda":
                    pricePerProduct = 0.8;
                    break;
                case "Coke":
                    pricePerProduct = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
            }

            totalMoney += pricePerProduct;
            if (totalCoins < pricePerProduct) {

                System.out.println("Sorry, not enough money");
            } else if (totalCoins >= pricePerProduct){
                totalCoins-=pricePerProduct;
                System.out.printf("Purchased %s%n", product);
            }
            product = scanner.nextLine();
        }

        double diff = (totalCoins - totalMoney);
        System.out.printf("Change: %.2f", totalCoins);
    }
}
