package Methods;

import java.util.Scanner;

public class CharactersinRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        printChars(start, end);
    }

    private static void printChars(char start, char end) {
        if (start > end){
            char temp = start;
            start = end;
            end = temp;
        }
        for (int i = start + 1; i < end; i++){
            System.out.printf("%c " ,i);
        }
    }
}
