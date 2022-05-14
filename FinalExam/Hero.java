package FinalExam;

import java.util.*;

public class Hero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Heroes> heroesMap = new LinkedHashMap<>();

        while (true) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            if (command.equals("End")) {
                break;
            }
            String heroName = data[1];
//            Heroes hero = new Heroes(heroName, data[2]);
            switch (command) {
                case "Enroll":
                    if (heroesMap.containsKey(heroName)) {
                        System.out.println(heroName + " is already enrolled.");
                    } else {
                        Heroes hero = new Heroes(heroName);
                        heroesMap.put(heroName, hero);
                    }
                    break;
                case "Learn":
                    String spell = data[2];
                    Heroes hero;

                    if (heroesMap.containsKey(heroName)) {
                        hero = heroesMap.get(heroName);
                        if (hero.getSpell().contains(spell)) {
                            System.out.println(heroName + " has already learnt " + spell + ".");
                            break;
                        }
                        hero.addSpell(spell);
                        heroesMap.replace(heroName, hero);
                    } else {
                        System.out.println(heroName + " doesn't exist.");
                    }
                    break;
                case "Unlearn":
                    String spell1 = data[2];
                    if (heroesMap.containsKey(heroName)) {
                        hero = heroesMap.get(heroName);
                        if (!hero.getSpell().contains(spell1)) {
                            System.out.println(heroName + " doesn't know " + spell1 + ".");
                        }
                        hero.removeSpell(spell1);
                        heroesMap.replace(heroName, hero);
                    } else {
                        System.out.println(heroName + " doesn't exist.");
                    }
                    break;
            }

        }
        System.out.println("Heroes:");


        for (Map.Entry<String, Heroes> entry : heroesMap.entrySet()) {
            System.out.printf("== %s:", entry.getKey());
            if (entry.getValue().getSpell().size() == 1) {
                System.out.print(" " + entry.getValue().getSpell().get(0));
            } else if (entry.getValue().getSpell().size() > 1) {
                for (int j = 0; j < entry.getValue().getSpell().size() - 1; j++) {
                    System.out.printf(" %s,", entry.getValue().getSpell().get(j));
                }
                System.out.printf(" %s", entry.getValue().getSpell().get(entry.getValue().getSpell().size() - 1));
            }
            System.out.println();
        }

    }

    static class Heroes {
        String name;
        List<String> spell;

        public Heroes(String name) {
            this.name = name;
            this.spell = new ArrayList<>();
        }

        public Heroes(String name, List<String> spell) {
            this.name = name;
            this.spell = spell;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addSpell(String spell) {
            this.spell.add(spell);
        }

        public void removeSpell(String spell) {
            this.spell.remove(spell);

        }

        public List<String> getSpell() {
            return spell;
        }

        public void setSpell(List<String> spell) {
            this.spell = spell;
        }

    }
}
