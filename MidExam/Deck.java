package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Deck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> deck = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String command = data[0];
            switch (command) {
                case "Add":
                    String cardName = data[1];
                    if (!deck.contains(cardName)) {
                        deck.add(cardName);
                        System.out.println("Card successfully added");
                    } else {
                        System.out.println("Card is already in the deck");
                    }
                    break;
                case "Remove":
                    String cardNameRemove = data[1];
                    if (deck.contains(cardNameRemove)) {
                        deck.remove(cardNameRemove);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(data[1]);
                    if (0 <= index && index < deck.size()) {
                        deck.remove(index);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexOfInsert = Integer.parseInt(data[1]);
                    String nameCard = data[2];
                    if (0 <= indexOfInsert && indexOfInsert < deck.size()) {
                        if (!deck.contains(nameCard)) {
                            deck.add(indexOfInsert, nameCard);
                            System.out.println("Card successfully added");
                        } else {
                            System.out.println("Card is already added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }
        for (int i = 0; i < deck.size() - 1; i++) {
            System.out.print(deck.get(i) + ", ");
        }
        System.out.print(deck.get(deck.size() - 1));
    }
}
