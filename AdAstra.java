import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdAstra {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[#|]");
        List<String> itemsNames = new ArrayList<>();
        List<String> itemsDates = new ArrayList<>();
        List<String> itemsCalories = new ArrayList<>();

        for (int i = 0; i < input.length - 2; i++) {
            if (isFood(input[i])) {
                if (isDate(input[i + 1])) {
                    if (isCalories(input[i + 2])) {
                        itemsNames.add(input[i]);
                        itemsDates.add(input[i + 1]);
                        itemsCalories.add(input[i + 2]);
                    }
                }
            }
        }

        int totalCalories = 0;
        for (String s : itemsCalories) {
            totalCalories += Integer.parseInt(s);
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (int i = 0; i < itemsNames.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",
                    itemsNames.get(i),
                    itemsDates.get(i),
                    itemsCalories.get(i));
        }
    }

    private static boolean isCalories(String s) {
        int calories;
        try {
            calories = Integer.parseInt(s);
            if (calories < 0 || calories > 10000) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isDate(String date) {
        String[] dateArr = date.split("/");

        char[] chars = date.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(Character.isDigit(chars[i]) || chars[i] == '/')) {
                return false;
            }
        }
        if (dateArr.length != 3) {
            return false;
        }
        for (int i = 0; i < dateArr.length; i++) {
            if (dateArr[i].length() != 2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFood(String food) {
        if (food.isBlank()) {
            return false;
        }

        char[] c = food.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!(Character.isLetter(c[i]) || Character.isSpaceChar(c[i]))) {
                return false;
            }
        }
        return true;
    }
}
