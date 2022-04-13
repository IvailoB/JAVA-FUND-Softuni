package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class PrintOfSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
            System.out.printf("%d ",i);
        }
        System.out.printf("\nSum: %d",sum);

    }
}
