package Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        middleChar(string);
    }

    private static void middleChar(String string) {
        if (string.length() % 2 == 0) {
            System.out.println(string.charAt(string.length() / 2 - 1) + "" + string.charAt(string.length() / 2));
        } else {
            System.out.println(string.charAt(string.length() / 2));
        }
    }
}