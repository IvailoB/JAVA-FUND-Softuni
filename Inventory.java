import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String[] data = scanner.nextLine().split(" - ");
            if (data[0].equals("Craft!")) {
                break;
            }
            String item = data[1];
            if (data[0].equals("Collect")) {
                if (!inventory.contains(item)) {
                    inventory.add(item);
                } else {
                    continue;
                }
            } else if (data[0].equals("Drop")) {
                if (inventory.contains(item)) {
                    inventory.remove(item);
                } else {
                    continue;
                }
            } else if (data[0].equals("Combine Items")) {
                String[] items = data[1].split(":");
                String oldItem = items[0];
                String newItem = items[1];
                if (inventory.contains(oldItem)) {
                    inventory.add(inventory.indexOf(oldItem)+1, newItem);
                } else {
                    continue;
                }
            } else if (data[0].equals("Renew")) {
                if (inventory.contains(item)) {
                    inventory.remove(item);
                    inventory.add(item);
                }
            }

        }
        for (int i = 0; i < inventory.size(); i++) {
            if (i != inventory.size() - 1) {
                System.out.print(inventory.get(i) + ", ");
            } else {
                System.out.println(inventory.get(i));
            }
        }
    }
}
