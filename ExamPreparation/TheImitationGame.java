package ExamPreparation;

import java.util.Scanner;


public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] commandPart = command.split("\\|");
            String commandName = commandPart[0];

            switch (commandName) {
                case "ChangeAll":
                    message = changeAll(message, commandPart[1], commandPart[2]);
                    break;
                case "Insert":
                    message = insert(message, Integer.parseInt(commandPart[1]), commandPart[2]);
                    break;
                case "Move":
                    message = move(message, Integer.parseInt(commandPart[1]));
                    break;
                default:
                    throw new IllegalStateException("Unknown command " + commandName);
            }

            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);
    }

    private static String changeAll(String message, String subst, String replacement) {
        return message.replace(subst, replacement);
    }

    private static String insert(String message, int index, String s) {
        String firstPart = message.substring(0, index);
        String secondPart = message.substring(index);
        return firstPart + s + secondPart;
    }

    private static String move(String message, int length) {
        String firstPart = message.substring(0, length);
        String secondPart = message.substring(length);
        return secondPart + firstPart;
    }
}
