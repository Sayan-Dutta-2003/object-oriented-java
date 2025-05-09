// 11.	Write a program in Java to create your own exception.

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class VotingEligibility {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be Negative!");
        } else if (age < 18) {
            throw new InvalidAgeException("You must be at least 18 years old to vote!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Check your voting eligibility!");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter your age: ");
                            int age = sc.nextInt();
                            validateAge(age);
                            System.out.println("\nVoting eligibility confirmed!");
                        } catch (InvalidAgeException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter numbers only.");
                            sc.nextLine();
                        }
                        break;

                    case 2:
                        sc.close();
                        System.out.println("Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
            }
        }
    }
}