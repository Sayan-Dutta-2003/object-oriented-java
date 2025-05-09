// 6.	Write a program in Java to implement stack data structure.

import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack {

    private final int[] elements;
    private int top;
    private final int capacity;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive!");
        }
        this.capacity = capacity;
        elements = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is Full!");
        }
        elements[++top] = value;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top--];
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void displayElements() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println("Stack elements (Top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.println(elements[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Stack Capacity: ");
        int capacity = sc.nextInt();
        Stack stack = new Stack(capacity);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Get Size");
            System.out.println("7. Show all elements");
            System.out.println("8. Exit");
            System.out.println("Enter Choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter a value to push: ");
                        int value = sc.nextInt();
                        stack.push(value);
                        System.out.println("Pushed " + value);
                    }
                    case 2 -> System.out.println("Popped: " + stack.pop());
                    case 3 -> System.out.println("Top element: " + stack.peek());
                    case 4 -> System.out.println("Is stack Empty?: " + stack.isEmpty());
                    case 5 -> System.out.println("Is stack full?: " + stack.isFull());
                    case 6 -> System.out.println("Current Size: " + stack.size() + "\nCapacity: " + capacity);
                    case 7 -> stack.displayElements();
                    case 8 -> {
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } catch (EmptyStackException e) {
                System.out.println("Error: Stack is empty!");

            } catch (StackOverflowError e) {
                System.out.println("Error: Stack is full!");
            }
        }
    }
}
