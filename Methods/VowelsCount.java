package Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelsCount {
    private static void Vowels(String string) {
        List<String> vowels = List.of("a", "e", "i", "o", "u", "y");
        String[] n = string.split("");
        int counter = 0;
        for (String s : n) {
            if (vowels.contains(s)) {
                counter++;
            }
        }
        System.out.println(counter);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Vowels(string.toLowerCase());
    }
}
