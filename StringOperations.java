// 21.	Write a Java program to implement any five functions of String.

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== String Operations Menu =====");
            System.out.println("1. Get String Length");
            System.out.println("2. Concatenate Two Strings");
            System.out.println("3. Compare Two Strings");
            System.out.println("4. Check Substring Existence");
            System.out.println("5. Replace characters in String");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a String: ");
                    String str = sc.nextLine();
                    System.out.println("Length: " + str.length());
                }
                case 2 -> {
                    System.out.print("Enter First String: ");
                    String str1 = sc.nextLine();
                    System.out.print("Enter Second String: ");
                    String str2 = sc.nextLine();
                    System.out.println("Concatenated String: " + str1.concat(str2));
                }
                case 3 -> {
                    System.out.print("Enter First String: ");
                    String str1 = sc.nextLine();
                    System.out.print("Enter Second String: ");
                    String str2 = sc.nextLine();
                    if (str1.equals(str2)) {
                        System.out.println("Strings are Equal");
                    } else {
                        System.out.println("Strings are not Equal");
                    }
                }
                case 4 -> {
                    System.out.print("Enter main String: ");
                    String mainStr = sc.nextLine();
                    System.out.print("Enter substring to search: ");
                    String subStr = sc.nextLine();
                    System.out.println("Substring exists: " + mainStr.contains(subStr));
                }
                case 5 -> {
                    System.out.print("Enter Original String: ");
                    String originalString = sc.nextLine();
                    System.out.print("Enter characters to replace: ");
                    String oldChar = sc.nextLine();
                    System.out.print("Enter replacement character: ");
                    String newChar = sc.nextLine();
                    System.out.println("Modified String: " + originalString.replace(oldChar,newChar));
                }
                case 6 -> System.out.println("Exiting Program...");
                default -> System.out.println("Invalid choice! Please try again.");
            }

        }while (choice != 6);

        sc.close();
    }
}