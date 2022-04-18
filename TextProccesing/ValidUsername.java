package TextProccesing;

import java.util.Arrays;
import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(", ")).filter(ValidUsername::isValid).forEach(System.out::println);
    }

    static boolean isValid(String username) {
        return username.length() >= 3 && username.length() <= 16 && username.matches("[a-zA-Z_\\-\\d]+");
    }
}
