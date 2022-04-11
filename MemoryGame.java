import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String line = scanner.nextLine();
        int moves = 0;
        while (!line.equals("end")) {
            String[] data = line.split(" ");
            int firstIndex = Integer.parseInt(data[0]);
            int secondIndex = Integer.parseInt(data[1]);
            moves++;
            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex < 0 || firstIndex > elements.size() || secondIndex > elements.size()) {
                elements.add(elements.size() / 2, "-" + moves + "a");
                elements.add(elements.size() / 2, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
                line = scanner.nextLine();
                continue;
            }
            if (Objects.equals(elements.get(firstIndex), elements.get(secondIndex))) {
                System.out.println("Congrats! You have found matching elements - " + elements.get(firstIndex) + "!");
                if (secondIndex > firstIndex) {
                    elements.remove(secondIndex);
                    elements.remove(firstIndex);
                } else if (secondIndex < firstIndex) {
                    elements.remove(firstIndex);
                    elements.remove(secondIndex);
                }
            } else {
                System.out.println("Try again!");
            }

            if (elements.size() == 0) {
                System.out.printf("You have won in %d turns!", moves);
                break;
            }
            line = scanner.nextLine();
        }
        if (elements.size() > 0) {
            System.out.println("Sorry you lose :(");
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
