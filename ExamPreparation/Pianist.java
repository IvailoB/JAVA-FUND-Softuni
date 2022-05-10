package ExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Pieces> piecesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            String name = data[0];
            String compositor = data[1];
            String key = data[2];
            Pieces piece = new Pieces(name, compositor, key);
            piecesMap.put(name, piece);
        }

        while (true) {
            String[] data = scanner.nextLine().split("\\|");
            if (data[0].equals("Stop")) {
                break;
            }
            String name = data[1];
            switch (data[0]) {
                case "Add":
                    String compositor = data[2];
                    String key = data[3];
                    Pieces piece = new Pieces(name, compositor, key);
                    if (piecesMap.containsKey(name)) {
                        System.out.println(name + " is already in the collection!");
                    } else {
                        piecesMap.put(name, piece);
                        System.out.printf("%s by %s in %s added to the collection!\n", name, compositor, key);
                    }
                    break;
                case "Remove":
                    if (piecesMap.containsKey(name)) {
                        piecesMap.remove(name);
                        System.out.println("Successfully removed " + name + "!");
                    } else {
                        System.out.println("Invalid operation! " + name + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    String newKey = data[2];
                    Pieces play = piecesMap.get(name);
                    if (piecesMap.containsKey(name)) {
                        play.setKey(newKey);
                        System.out.println("Changed the key of " + name + " to " + newKey + "!");
                        break;
                    } else {
                        System.out.println("Invalid operation! " + name + " does not exist in the collection.");
                    }
            }

        }
        piecesMap.values().forEach(System.out::println);
    }

    static class Pieces {
        String piece;
        String compositor;
        String key;

        public Pieces(String piece, String compositor, String key) {
            this.piece = piece;
            this.compositor = compositor;
            this.key = key;
        }

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        public String getCompositor() {
            return compositor;
        }

        public void setCompositor(String compositor) {
            this.compositor = compositor;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.format("%s -> Composer: %s, Key: %s", this.piece, this.compositor, this.key);
        }
    }
}

