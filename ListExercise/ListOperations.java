package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                 .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (true) {
            String[] operations = scanner.nextLine().split(" ");
            if (operations[0].equals("End")) {
                break;
            }

            if (operations[0].equals("Add")) {
                numbers.add(Integer.parseInt(operations[1]));
            } else if (operations[0].equals("Insert")) {
                if (0 <= Integer.parseInt(operations[2]) && Integer.parseInt(operations[2]) < numbers.size()) {
                    numbers.add(Integer.parseInt(operations[2]), Integer.parseInt(operations[1]));
                } else {
                    System.out.println("Invalid index");
                }
            } else if (operations[0].equals("Remove")) {
                if (0 <= Integer.parseInt(operations[1]) && Integer.parseInt(operations[1]) < numbers.size()) {
                    numbers.remove(Integer.parseInt(operations[1]));
                } else {
                    System.out.println("Invalid index");
                }
            } else if (operations[1].equals("right")) {
                for (int i = 0; i < Integer.parseInt(operations[2]); i++) {
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size() - 1);
                }
            } else if (operations[1].equals("left")) {
                for (int i = 0; i < Integer.parseInt(operations[2]); i++) {
                    numbers.add(numbers.size(), numbers.get(0));
                    numbers.remove(0);
                }
            }

        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}