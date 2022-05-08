package Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    static void SmallestNumber (int num1, int num2, int num3) {
        if (num1 < num2){
            System.out.print(num1);
        }else if (num2 < num3){
            System.out.print(num2);
        }else
            System.out.print(num3);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

       SmallestNumber(num1, num2, num3);
    }
}
