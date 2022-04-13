package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int number = Integer.parseInt(input);
        int digit = 0;
        int num = number;
        int totalFact = 0;

        for (int i = 0; i < input.length(); i++) {
            digit = num % 10;
            num /= 10;
            int fac = 1;

            for (int j = 1; j <= digit; j++) {
                fac *= j;
            }
            totalFact += fac;
        }

        if (number == totalFact) {

            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
