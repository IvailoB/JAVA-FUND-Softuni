import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double temp = 0;
        int maxAttendances = 0;

        for (int i = 1; i <= students; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = 1.0 * attendances / lectures * (5 + additionalBonus);
            if (totalBonus > temp) {
                temp = totalBonus;
                maxAttendances = attendances;
            }
        }

        System.out.printf("Max Bonus: %d.%n", Math.round(temp));
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
