package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double total = 0;

        switch (type) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45;
                } else if (day.equals("Saturday")) {
                    price = 9.80;
                } else if (day.equals("Sunday")) {
                    price = 10.46;
                }
                total = price * people;
                if (people >= 30) {
                    total *= 0.85;
                }
                break;

            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90;
                } else if (day.equals("Saturday")) {
                    price = 15.60;
                } else if (day.equals("Sunday")) {
                    price = 16;
                }
                total = price * people;
                if (people >= 100) {
                    people -= 10;
                    total = price * people;
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    price = 15;
                } else if (day.equals("Saturday")) {
                    price = 20;
                } else if (day.equals("Sunday")) {
                    price = 22.50;
                }
                total = price * people;
                if (people >= 10 && people <= 20) {

                    total *= 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", total);
    }
}
