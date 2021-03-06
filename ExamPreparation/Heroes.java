package ExamPreparation;

import java.util.*;

public class Heroes {
    static class Hero {
        String name;
        int hitPoints;
        int manaPoints;

        public String getName() {
            return name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroes = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] heroParams = line.split(" ");
            Hero hero = new Hero(heroParams[0], Integer.parseInt(heroParams[1]), Integer.parseInt(heroParams[2]));
            heroes.put(hero.getName(), hero);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split(" - ");
            String commandName = commandParts[0];
            switch (commandName) {
                case "CastSpell":
                    handleCastSpell(heroes, commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);
                    break;
                case "TakeDamage":
                    handleTakeDamage(heroes, commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);
                    break;
                case "Recharge":
                    handleRecharge(heroes, commandParts[1], Integer.parseInt(commandParts[2]));
                    break;
                case "Heal":
                    handleHeal(heroes, commandParts[1], Integer.parseInt(commandParts[2]));
                    break;
            }
            command = scanner.nextLine();
        }
        for (Hero hero : heroes.values()) {
            System.out.println(hero.getName() + System.lineSeparator()
                    + "  HP: " + hero.getHitPoints() + System.lineSeparator()
                    + "  MP: " + hero.getManaPoints());
        }
    }

    private static void handleCastSpell(Map<String, Hero> heroes, String heroName, int manaPoint, String spellName) {
        Hero hero = heroes.get(heroName);
        if (hero.getManaPoints() >= manaPoint) {
            hero.setManaPoints(hero.getManaPoints() - manaPoint);
            System.out.println(hero.getName() + " has successfully cast " + spellName + " and now has " + hero.getManaPoints() + " MP!");
        } else {
            System.out.println(hero.getName() + " does not have enough MP to cast " + spellName + "!");
        }
    }

    private static void handleTakeDamage(Map<String, Hero> heroes, String heroName, int damage, String attacker) {
        Hero hero = heroes.get(heroName);
        hero.setHitPoints(hero.getHitPoints() - damage);
        if (hero.getHitPoints() > 0) {
            System.out.println(hero.getName() + " was hit for " + damage + " HP by " + attacker + " and now has " + hero.getHitPoints() + " HP left!");
        } else {
            System.out.println(hero.getName() + " has been killed by " + attacker + "!");
            heroes.remove(heroName);
        }
    }

    private static void handleRecharge(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);

        int oldManaPoints = hero.getManaPoints();
        int newManaPoints = Math.min(hero.getManaPoints() + amount, 200);
        hero.setManaPoints(newManaPoints);

        int amountRecovered = newManaPoints - oldManaPoints;
        System.out.println(hero.getName() + " recharged for " + amountRecovered + " MP!");
    }

    private static void handleHeal(Map<String, Hero> heroes, String heroName, int amount) {
        Hero hero = heroes.get(heroName);

        int oldHitPoints = hero.getHitPoints();
        int newHitPoints = Math.min(hero.getHitPoints() + amount, 100);
        hero.setHitPoints(newHitPoints);

        int amountRecovered = newHitPoints - oldHitPoints;
        System.out.println(hero.getName() + " healed for " + amountRecovered + " HP!");
    }
}
