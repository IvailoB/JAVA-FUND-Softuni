package ExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Cars> carsMap = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String name = data[0];
            int mileage = Integer.parseInt(data[1]);
            int fuel = Integer.parseInt(data[2]);

            Cars car = new Cars(name, mileage, fuel);
            carsMap.put(name, car);
        }

        while (true) {
            String[] commands = scanner.nextLine().split(" : ");
            if (commands[0].equals("Stop")) {
                break;
            }
            String command = commands[0];
            String carName = commands[1];
            int DFK = Integer.parseInt(commands[2]);
            Cars car = carsMap.get(carName);
            switch (command) {
                case "Drive":
                    int fuel = Integer.parseInt(commands[3]);
                    if (car.fuel > fuel) {
                        car.setFuel(car.getFuel() - fuel);
                        car.setMileage(car.getMileage() + DFK);
                        System.out.println(carName + " driven for " + DFK + " kilometers. " + fuel + " liters of fuel consumed.");
                        if (car.getMileage() > 100000) {
                            carsMap.remove(carName);
                            System.out.println("Time to sell the " + carName + "!");
                        }

                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    if (car.getFuel() + DFK >= 75) {
                        int diff = Math.abs(car.getFuel() - 75);
                        car.setFuel(75);
                        System.out.println(carName + " refueled with " + diff + " liters");
                    } else {
                        car.setFuel(car.getFuel() + DFK);
                        System.out.println(carName + " refueled with " + DFK + " liters");
                    }

                    break;
                case "Revert":
                    car.setMileage(car.getMileage() - DFK);
                    if (car.getMileage() < 10000) {
                        car.setMileage(10000);
                    }
                    System.out.println(carName + " mileage decreased by " + DFK + " kilometers");
                    break;
            }
        }
        carsMap.values().forEach(System.out::println);
    }

    static class Cars {
        String name;
        int mileage;
        int fuel;

        public Cars(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        @Override
        public String toString() {
            return String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", this.name, this.mileage, this.fuel);
        }

    }
}
