package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        if (arr.length == 1) {
            System.out.print(0);
        } else {

            boolean flag = false;
            for (int i = 1; i < arr.length; i++) {
                int leftSum = 0;
                int rightSum = 0;
                for (int j = 0; j < i; j++) {
                    leftSum += arr[j];
                }
                for (int k = i + 1; k < arr.length; k++) {
                    rightSum += arr[k];
                }
                if (leftSum == rightSum){
                    flag = true;
                    System.out.print(i);
                }
            }
            if (!flag){
                System.out.print("no");
            }
        }
    }
}
