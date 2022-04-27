package ListExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[2].equals("not")) {
                if (names.contains(input[0])) {
                    names.remove(input[0]);
                } else {
                    System.out.printf("%s is not in the list!\n", input[0]);
                }
            } else {
                if (!names.contains(input[0])) {
                    names.add(input[0]);
                } else {
                    System.out.printf("%s is already in the list!\n", input[0]);
                }
            }
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }
}
