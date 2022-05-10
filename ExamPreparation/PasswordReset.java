package ExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("Done")) {
                break;
            }
            switch (command[0]) {
                case "TakeOdd":
                    for (int i = 0; i < input.length(); i++) {

                        if (i % 2 != 0) {
                            sb.append(input.charAt(i));
                        }
                    }
                    System.out.println(sb.toString());
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    sb.delete(index, index + length);
                    System.out.println(sb.toString());
                    break;
                case "Substitute":
                    String old = command[1];
                    String replacement = command[2];
                    if (sb.toString().contains(old)) {
                        String s = sb.toString().replaceAll(old, replacement);
                        System.out.println(s);
                        sb.setLength(0);
                        sb.append(s);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
        }
        System.out.println("Your password is: " + sb);
    }
}
