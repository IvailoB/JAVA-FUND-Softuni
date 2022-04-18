package DataTypesAndVariablesExercise;

        import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;
        int num = Integer.parseInt(input);
        for (int i = 0; i < input.length(); i++) {
            int digit =  num % 10;
            sum += digit;
            num = num / 10;
        }
            System.out.print(sum);
    }
}
