package crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class CryptoUtility {

    private static final String PATH_NAME = "crypto/";

    private CryptoUtility() {

    }

    public static String readFromFile(final String inputFile) {
        final File file = new File(PATH_NAME + inputFile);
        final StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
        }
        return stringBuilder.toString();
    }

    public static void writeToFile(final String fileName, final String data) {
        File file = new File(PATH_NAME + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUserInput(final String message) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s: ", message);
        userInput = scanner.nextLine();
        return userInput;
    }
}
