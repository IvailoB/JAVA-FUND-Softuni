package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        int counter = 0;
        StringBuilder mirrorWords = new StringBuilder();
        while (matcher.find()) {
            counter++;
            StringBuilder sb = new StringBuilder();
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");

            sb.append(wordOne);
            sb.reverse();
            if (sb.toString().equals(wordTwo)) {
                mirrorWords.append(wordOne);
                mirrorWords.append(" <=> ");
                mirrorWords.append(wordTwo);
                mirrorWords.append(", ");
            }

        }
        if (!mirrorWords.isEmpty()) {
            System.out.println(counter + " word pairs found!");
            mirrorWords.delete(mirrorWords.length() - 2, mirrorWords.length() - 1);
            System.out.println("The mirror words are: \n" + mirrorWords);
        } else if (mirrorWords.isEmpty() && counter > 0) {
            System.out.println(counter + " word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.println("No word pairs found!\n" +
                    "No mirror words!\n");
        }

    }
}
