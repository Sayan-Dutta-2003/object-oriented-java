// 17.	Write a program in Java to count the vowels of a 2-to-3-line text.

import java.util.Scanner;

public class vowelCounter {
    private static final String END_MARKER = ":end";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Text Analyzer =====");
            System.out.println("1. Start New Analysis");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            if (choice.equals("2")) {
                System.out.println("Exiting program...");
                break;
            } else if (choice.equals("1")) {
                analyzeText(sc);
            }
            else {
                System.out.println("Invalid choice! Please enter 1 or 2");
            }
        }
        sc.close();
    }
    private static void analyzeText(Scanner sc) {
        System.out.println("\nEnter your text (type '" + END_MARKER + "' on a new line to finish):");

        int lineCount = 0;
        int vowelCount = 0;
        int characterCount = 0;

        while (true) {
            String line = sc.nextLine();

            if (line.equalsIgnoreCase(END_MARKER)) {
                break;
            }
            lineCount++;
            characterCount += line.length();

            // Count vowels in current line
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                }
            }

        }

        System.out.println("\n=== Analysis Results ===");
        System.out.println("Total lines: " + lineCount);
        System.out.println("Total characters: " + characterCount);
        System.out.println("Total vowels: " + vowelCount);
    }
}

