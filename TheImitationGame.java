import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (true) {
            String[] command = scanner.nextLine().split("\\|");
            if (command[0].equals("Decode")) {
                break;
            }
            String operation = command[0];

            switch (operation) {
                case "Move":
                    for (int i = 0; i < Integer.parseInt(command[1]); i++) {
                        input = input.substring(1) + input.charAt(0);
                    }
                    break;
                case "Insert":
                    List<String> list = new ArrayList<>(Arrays.asList(input.split("")));
                    list.add(Integer.parseInt(command[1]) , command[2]);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String element : list) {
                        stringBuilder.append(element);
                    }
                    input = stringBuilder.toString();
                    break;
                case "ChangeAll":
                    String toReplace = command[1];
                    String replace = command[2];
                    input = input.replace(toReplace, replace);
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s",input);
    }
}
