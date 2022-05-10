package ExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());


        while (true) {
            String[] instructions = scanner.nextLine().split(">>>");
            if (instructions[0].equals("Generate")) {
                break;
            }
            switch (instructions[0]) {
                case "Contains":
                    if (sb.toString().contains(instructions[1])) {
                        System.out.println(sb.toString() + " contains " + instructions[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(instructions[2]);
                    int endIndex = Integer.parseInt(instructions[3]);
                    if (instructions[1].equals("Lower")) {
                        String substring = sb.substring(startIndex, endIndex);
                        sb.replace(startIndex, endIndex, substring.toLowerCase());
                    } else if (instructions[1].equals("Upper")) {
                        String substring = sb.substring(startIndex, endIndex);
                        sb.replace(startIndex, endIndex, substring.toUpperCase());
                    }
                    System.out.println(sb);
                    break;
                case "Slice":
                    int start = Integer.parseInt(instructions[1]);
                    int end = Integer.parseInt(instructions[2]);
                    sb.delete(start, end);
                    System.out.println(sb);
                    break;
            }
        }
        System.out.println("Your activation key is: " + sb.toString());
    }
}
