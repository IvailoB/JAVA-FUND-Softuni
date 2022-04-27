package ListExercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] data = input.split(" ");
            if (data[0].equals("Add")) {
                wagons.add(Integer.parseInt(data[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + Integer.parseInt(data[0]) <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + Integer.parseInt(data[0]));
                       break;
                    }
                }
            }
        }
        for (int i = 0; i < wagons.size(); i++){
            System.out.print(wagons.get(i) +" ");
        }
    }
}
