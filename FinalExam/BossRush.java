package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
//            sb.append(message);
            Pattern bossPattern = Pattern.compile("(\\|)(?<boss>[A-Z]{4,})\\1:(#)(?<title>([A-Za-z]+){1} ([A-Z-a-z]+){1})\\3");
            Matcher bossMatcher = bossPattern.matcher(message);
//            Pattern title = Pattern.compile("(#)(?<title>([A-Za-z]+){1} ([A-Z-a-z]+){1})\\1");
//            Matcher titleMatcher = title.matcher(message);
            String boss = "";
            String titleStr = "";
            while (bossMatcher.find()) {
                boss = bossMatcher.group("boss");
                titleStr = bossMatcher.group("title");
            }
            if (!(boss.isEmpty() || titleStr.isEmpty())) {
                System.out.println(boss + ", The " + titleStr);
                System.out.println(">> Strength: " + boss.length());
                System.out.println(">> Armor: "+ titleStr.length());
            } else {
                System.out.println("Access denied!");

            }


        }


    }
}
