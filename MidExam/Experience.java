package MidExam;

import java.util.Scanner;

public class Experience {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExp = Double.parseDouble(scanner.nextLine());
        int battles = Integer.parseInt(scanner.nextLine());
        int battlesCounter = 0;
        double currentExp = 0;
        for (int i = 0; i < battles; i++) {
            double exp = Double.parseDouble(scanner.nextLine());
            battlesCounter++;
            if (battlesCounter % 15 == 0) {
                exp *= 1.05;
            }
            if (battlesCounter % 3 == 0) {
                exp *= 1.15;
            } else if (battlesCounter % 5 == 0) {
                exp *= 0.90;
            }
            currentExp += exp;
            if (currentExp >= neededExp) {
                break;
            }
        }
        if (currentExp >= neededExp) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCounter);
        }else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",neededExp - currentExp);
        }
    }
}
