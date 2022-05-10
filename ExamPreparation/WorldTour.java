package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());

        while (true) {
            String[] manipulate = scanner.nextLine().split(":");
            if (manipulate[0].equals("Travel")) {
                break;
            }
            String command = manipulate[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(manipulate[1]);
                    String s = manipulate[2];
                    sb.insert(index, s);
                    System.out.println(sb);
                    break;
                case "Remove Stop":
                    int start = Integer.parseInt(manipulate[1]);
                    int end = Integer.parseInt(manipulate[2]);
                    sb.delete(start, end + 1);
                    System.out.println(sb);
                    break;
                case "Switch":
                    String old = manipulate[1];
                    String newStr = manipulate[2];
                    if (sb.toString().contains(old)){
                        sb.replace(sb.indexOf(old),old.length(),newStr);
                    }
                    System.out.println(sb);
                    break;
            }

        }
        System.out.println("Ready for world tour! Planned stops: "+ sb.toString());
    }
}
