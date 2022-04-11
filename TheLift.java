import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            for (int j = 0; j <= people + 2; j++) {
                if (lift[i] < 4) {
                    lift[i]++;
                    people--;
                }else {
                    break;
                }
            }
        }
        if (people ==0){
            System.out.println("The lift has empty spots!");
        }else {
            System.out.printf("There isn't enough space! %d people in a queue!%n",people);
        }
        for (int i = 0; i < lift.length; i++) {
            System.out.print(lift[i] + " ");
        }

    }
}
