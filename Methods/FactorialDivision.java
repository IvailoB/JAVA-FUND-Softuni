package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        double fac1 = factorial(num1);
        double fac2 = factorial(num2);
        System.out.printf("%.2f", fac1 / fac2);
    }

    private static double factorial(int num) {
        double result = 1;
        for (int i = num; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
