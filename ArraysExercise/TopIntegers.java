package ArraysExercise;

import java.util.ArrayList;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] number = new int[array.length];
        ArrayList<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            number[i] = Integer.parseInt(array[i]);
        }
        for (int i = 0; i < number.length; i++) {
            boolean isTop = true;
            for (int j = i; j < number.length; j++) {
                if (number[i] < number[j]){
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                topNumbers.add(number[i]);
            }
        }

        for (int i = 0; i < topNumbers.size() - 1; i++){
            System.out.print(topNumbers.get(i) + " ");
        }
        if (topNumbers.size() != 0) {
            System.out.print(topNumbers.get(topNumbers.size() - 1));
        }
    }
}

