package TextProccesing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.indexOf("."));
        String extension = filePath.substring(filePath.indexOf(".") + 1);
        System.out.printf("File name: %s%n", fileName);
        System.out.println("File extension: ".concat(extension));

    }
}
