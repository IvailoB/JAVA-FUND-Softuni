package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        double price = 0;
        for (int i = 0; i < N; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            price = ((daysInMonth * capsulesCount) * pricePerCapsule);
            System.out.printf("The price for the coffee is: $%.2f%n",price);
            totalPrice += price;
        }
        System.out.printf("Total: $%.2f",totalPrice);
    }
}
