package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class blbalbab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++) {
                matrix[i][j] = i + j;
                System.out.print(i + j + " ");
            }
            System.out.println();
        }
    }
}

