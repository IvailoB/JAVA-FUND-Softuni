package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String pass = "";
        for (int i = user.length() - 1; i >= 0; i--) {
            pass += user.charAt(i);

        }
        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals(pass)) {
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", user);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }
        if (input.equals(pass)) {
            System.out.printf("User %s logged in.", user);
        }
    }
}
