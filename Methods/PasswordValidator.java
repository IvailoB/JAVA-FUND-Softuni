package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        passValidation(pass);

    }

    private static void passValidation(String pass) {
        boolean length = false;
        boolean lettersAndDigits = true;
        boolean leastDigits = false;

        int counter = 0;
        if (pass.length() >= 6 && pass.length() <= 10) {
            length = true;
        }
        for (char c : pass.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                lettersAndDigits = false;
            }
        }
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) {
                counter++;
            }
        }
        if (counter >= 2) {
            leastDigits = true;
        }
        if (length && leastDigits && lettersAndDigits){
            System.out.print("Password is valid");
        }
        if (!length){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!lettersAndDigits){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!leastDigits){
            System.out.println("Password must have at least 2 digits");
        }

    }
}
