package ExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cities> cities = new LinkedHashMap<>();
        while (true) {
            String[] data = scanner.nextLine().split("\\|\\|");
            if (data[0].equals("Sail")) {
                break;
            }
            String name = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);
            if (cities.containsKey(name)) {
                Cities city = cities.get(name);
                city.setGold(city.getGold() + gold);
                city.setPopulations(city.getPopulations() + population);
            } else {
                Cities city = new Cities(name, population, gold);
                cities.put(name, city);
            }
        }

        while (true) {
            String[] command = scanner.nextLine().split("=>");
            if (command[0].equals("End")) {
                break;
            }

            switch (command[0]) {
                case "Plunder":
                    String name = command[1];
                    int people = Integer.parseInt(command[2]);
                    int gold = Integer.parseInt(command[3]);
                    Cities city = cities.get(name);
                    city.setPopulations(city.getPopulations() - people);
                    city.setGold(city.getGold() - gold);

                    System.out.println(name + " plundered! " + gold + " gold stolen, " + people + " citizens killed.");
                    if (city.getGold() == 0 || city.getPopulations() == 0) {
                        cities.remove(name);
                        System.out.println(city.getName() + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    String townName = command[1];
                    int coin = Integer.parseInt(command[2]);
                    if (coin < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        continue;
                    }
                    Cities town = cities.get(townName);
                    town.setGold(town.getGold() + coin);
                    System.out.println(coin + " gold added to the city treasury. " + townName + " now has " + town.getGold() + " gold.");
                    break;
            }
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");
            cities.values().forEach(System.out::println);
        }
    }


    static class Cities {
        String name;
        int populations;
        int gold;

        public Cities(String city, int populations, int gold) {
            this.name = city;
            this.populations = populations;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulations() {
            return populations;
        }

        public void setPopulations(int populations) {
            this.populations = populations;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        @Override
        public String toString() {
            return String.format("%s -> Population: %d citizens, Gold: %d kg", name, populations, gold);
        }
    }
}
