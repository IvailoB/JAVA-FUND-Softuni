import java.util.Scanner;

public class Property {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double priceWithoutTax = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            priceWithoutTax += price;
            input = scanner.nextLine();
        }
        if (priceWithoutTax == 0) {
            System.out.println("Invalid order!");
        } else {
            double tax = priceWithoutTax * 0.20;
            double totalPrice = tax + priceWithoutTax;
            if (input.equals("special")) {
                totalPrice *= 0.90;
            }
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", priceWithoutTax, tax, totalPrice);

        }
    }
}
