package ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");

        for (String second : secondLine) {
            for (String first : firstLine) {
                if (second.equals(first)) {
                    System.out.print(first + " ");
                }
            }
        }
    }
}
