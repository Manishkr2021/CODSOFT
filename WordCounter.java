import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word Counter");

        System.out.println("Choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String text = "";

        switch (choice) {
            case 1:
                System.out.println("Enter the text:");
                text = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the path to the file:");
                String filePath = scanner.nextLine();
                try {
                    text = readTextFromFile(filePath);
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return;
        }

        int wordCount = countWords(text);
        System.out.println("Total words: " + wordCount);

        scanner.close();
    }

    private static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+"); // Split by whitespace or punctuation
        return words.length;
    }

    private static String readTextFromFile(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("E:\\cuk\\mysqlResetPassword.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
        
    }
}
