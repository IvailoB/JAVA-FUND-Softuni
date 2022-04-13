package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];

        for (int i = 0; i < train.length; i++) {
            train[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < train.length; i++) {
            System.out.print(train[i] + " ");
            sum += train[i];
        }
        System.out.println();
        System.out.println(sum);


    }
}
