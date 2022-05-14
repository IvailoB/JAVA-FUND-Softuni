package FinalExam;

import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sb = scanner.nextLine();
//        StringBuilder sb1 = new StringBuilder();


        while (true) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            if (command.equals("Done")) {
                break;
            }
            switch (command) {
                case "Change":
                    String charAsString = data[1];
                    String replacement = data[2];
                    sb = sb.replace(charAsString, replacement);
                    System.out.println(sb);
                    break;
                case "Includes":
                    String substring = data[1];
                    if (sb.contains(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String sub = data[1];

                    if (sb.endsWith(sub)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    sb = sb.toUpperCase();
                    System.out.println(sb);
                    break;
                case "FindIndex":
                    String c = data[1];
                    System.out.println(sb.indexOf(c));
                    break;
                case "Cut":
                    int index = Integer.parseInt(data[1]);
                    int length = index + Integer.parseInt(data[2]);
                    String substring1 = sb.substring(index, length);
                    System.out.println(substring1);
                    break;
            }
        }
    }
}
