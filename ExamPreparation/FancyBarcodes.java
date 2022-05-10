package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            String item = scanner.next();
            Pattern pattern = Pattern.compile("@#+(?<item>[A-Z][A-Za-z0-9]+[A-Z])@#+");
            Matcher matcher = pattern.matcher(item);

            StringBuilder sb = new StringBuilder();

            while (matcher.find()) {
                flag = true;
                String s = matcher.group("item");
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }
                if (sb.isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb.toString());
                }
            }
            if (!flag){
                System.out.println("Invalid barcode");
            }
        }
    }
}
