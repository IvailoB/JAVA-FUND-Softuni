package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Spices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int consume = 0;
        int leaving = startYield;
        while (startYield >= 100) {
            days++;
            leaving = startYield - 26;
            consume += leaving;
            startYield -= 10;

        }
        if (leaving >= 0) {
            System.out.println(days);
            System.out.println(consume - 26);
        }
    }
}
