package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] output = {0, 1};

        int counter = 1;
        // 1 1 1 2 2 3 3 3 3
        //2 1 1 2 3 3 2 2 2 1
        for (int i = 0; i < number.length - 1; i++) {
            if (number[i] == number[i + 1]) {
                if (i == number.length - 2) {
                    counter++;
                    if (counter > output[1]) {
                        output[1] = counter;
                        output[0] = number[i];
                        break;
                    }
                }
//                System.out.print(number[i] + " ");
                counter++;
                continue;
            } else {
                if (counter > output[1]) {
                    output[1] = counter;
                    output[0] = number[i];
                }
                counter = 1;
            }

        }
        for (int i = 0; i < output[1]; i++) {
            System.out.print(output[0] + " ");
        }
    }
}
