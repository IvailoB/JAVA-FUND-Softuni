package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int blackListCount = 0;
        int lostNamesCount = 0;
        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("Report")) {
                break;
            }
            switch (command[0]) {
                case "Blacklist":
                    if (names.contains(command[1])) {
                        names.set(names.indexOf(command[1]), "Blacklisted");
                        System.out.printf("%s was blacklisted.%n", command[1]);
                        blackListCount++;
                    } else {
                        System.out.printf("%s was not found.%n", command[1]);
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(command[1]);
                    if (0 <= index && index < names.size()) {
                        String name = names.get(index);
                        if (!name.equals("Blacklisted") && !name.equals("Lost")) {
                            names.set(index, "Lost");
                            System.out.printf("%s was lost due to an error.%n", name);
                            lostNamesCount++;
                        }
                    }
                    break;
                case "Change":
                    int indexOfChange = Integer.parseInt(command[1]);
                    if (0 <= indexOfChange && indexOfChange < names.size()) {
                        String name = command[2];
                        System.out.printf("%s changed his username to %s.%n", names.get(indexOfChange), name);
                        names.set(indexOfChange, name);
                    }
                    break;
            }
        }

        System.out.printf("Blacklisted names: %d%n", blackListCount);
        System.out.printf("Lost names: %d%n", lostNamesCount);
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }

    }
}
