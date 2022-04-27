package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("end")) {
                break;
            } else if (input[0].equals("Delete")) {
                int remove = Integer.parseInt(input[1]);
                for (int i = 0; i < numbers.size(); ) {
                    if (numbers.get(i) == remove) {
                        numbers.remove(i);
                    } else {
                        i++;
                    }
                }
            } else if (input[0].equals("Insert")) {
                int element = Integer.parseInt(input[1]);
                int position = Integer.parseInt(input[2]);
                numbers.add(position, element);
            }

        }
        for (int i = 0; i < numbers.size(); i++){
            System.out.print(numbers.get(i) + " ");
        }
    }
}
