package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (i != 1) {

                System.out.println();
            }
            for (int j = 1; j <= i; j++) {
                for (int k = i; k <= i; k++) {
                    System.out.print(k + " ");
                }

            }
        }
    }

}