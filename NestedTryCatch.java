// 12.	Write a program in Java for nested try catch.

import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        int[] marks = {100, 200, 300};
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Access Array Element");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                // Outer try-catch for menu operations
                try {
                    switch (choice) {
                        case 1 -> {
                            boolean validIndex = false;
                            while (!validIndex) {
                                try {
                                    System.out.print("Enter array index (0-2): ");
                                    int index = sc.nextInt();

                                    // Inner try-catch for array access
                                    try {
                                        System.out.println("Value at index " + index + ": " + marks[index]);
                                        validIndex = true;
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("Level 3 Inner Catch: Invalid index! Maximum index is 2");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Level 2 Middle Catch: Please enter numbers only for index!");
                                    sc.nextLine(); // Clear invalid input
                                }
                            }
                        }
                        // Middle try-catch for index input

                        case 2 -> {
                            running = false;
                            System.out.println("Exiting program...");
                        }
                        default -> System.out.println("Invalid menu choice!");
                    }
                } catch (Exception e) {
                    System.out.println("Level 1 Outer Catch: General error in menu operation");
                }

            } catch (InputMismatchException e) {
                System.out.println("Top-level Catch: Invalid input! Please enter numbers only for menu choice.");
                sc.nextLine(); // Clear invalid input
            }
        }
        sc.close();
    }
}