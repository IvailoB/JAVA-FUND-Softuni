import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\|");

        int initialHeal = 100;
        int initialBitcoin = 0;
        int currentHeal = 100;

        for (int i = 0; i < line.length; i++) {
            if (currentHeal <= 0) {
                break;
            }
            String[] data = line[i].split(" ");
            String command = data[0];
            int number = Integer.parseInt(data[1]);

            switch (command) {
                case "potion":
                    currentHeal += number;
                    if (currentHeal > initialHeal) {
                        number = currentHeal - 110;
                        currentHeal = initialHeal;

                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", currentHeal);
                    break;
                case "chest":
                    initialBitcoin += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    currentHeal -= number;
                    if (currentHeal > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %s", i+1);
                    }
            }
        }
        if (currentHeal > 0) {
            System.out.printf("You've made it!%n" +
                    "Bitcoins: %d%n" +
                    "Health: %d", initialBitcoin, currentHeal
            );
        }
    }
}
