import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //0123
        //asdf
        for (int i = 0; i < input.length(); i++) {

            int number = Integer.parseInt(input);
            char symbol = input.charAt(i);

           // System.out.println(i);
            System.out.println(number);
        }


    }
}
