package ExamPreparation;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int coolThresholdSum = 1;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());

            coolThresholdSum *= digit;
        }
        System.out.println("Cool threshold: " + coolThresholdSum);

        pattern = Pattern.compile("(?<sign>[:]{2}|[*]{2})(?<emoji>[A-Z]{1}[a-z]{2,})\\1");
        matcher = pattern.matcher(line);
        List<String> emoji = new LinkedList<>();

        int counter = 0;
        while (matcher.find()) {
            counter++;
            String name = matcher.group();
            int charSum = 0;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                charSum = charSum + c;
            }
            if (charSum >= coolThresholdSum) {
                emoji.add(name);
            }

        }


        System.out.println(counter + " emojis found in the text. The cool ones are:");
        emoji.stream().forEach(System.out::println);
    }
}
