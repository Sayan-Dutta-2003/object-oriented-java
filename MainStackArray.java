// 9.	Write a program in Java to implement stack data structure using package and interface.

import StackPackage.StackInterface;
import StackPackage.ArrayStack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MainStackArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Stack Capacity: ");
        int capacity = sc.nextInt();
        StackInterface stack = new ArrayStack(capacity);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if empty");
            System.out.println("5. Check if full");
            System.out.println("6. Get Size");
            System.out.println("7. Show all elements");
            System.out.println("8. Exit");
            System.out.println("Enter Choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter value to Push: ");
                        int value = sc.nextInt();
                        stack.push(value);
                        System.out.println("Pushed " + value);
                    }
                    case 2 -> System.out.println("Popped: " + stack.pop());
                    case 3 -> System.out.println("Top element: " + stack.peek());
                    case 4 -> System.out.println("Stack is empty: " + stack.isEmpty());
                    case 5 -> System.out.println("Stack is full: " + stack.isFull());
                    case 6 -> System.out.println("Current Size: " + stack.size() + "\nCapacity: " + capacity);
                    case 7 -> stack.displayElements();
                    case 8 -> {
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }catch (EmptyStackException | StackOverflowError e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}