// 7.	Write a program in Java to implement queue data structure.

import java.util.Scanner;

public class Queue {
    private final int[] elements;
    private final int capacity;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full!");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = value;
        size++;
    }

    public int dequeue() throws NoSuchFieldException {
        if(isEmpty()) {
            throw new NoSuchFieldException("Queue is Empty");
        }
        int value = elements[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() throws NoSuchFieldException {
        if (isEmpty()) {
            throw new NoSuchFieldException("Queue is Empty");
        }
        return elements[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(elements[index] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter queue Capacity: ");
        int capacity = sc.nextInt();
        Queue queue = new Queue(capacity);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if empty");
            System.out.println("5. Check if full");
            System.out.println("6. Display elements");
            System.out.println("7. Get size");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter value to enqueue: ");
                        int value = sc.nextInt();
                        queue.enqueue(value);
                        System.out.println("Enqueued " + value);
                    }
                    case 2 -> System.out.println("Dequeued: " + queue.dequeue());
                    case 3 -> System.out.println("Front element: " + queue.peek());
                    case 4 -> System.out.println("Queue is empty: " + queue.isEmpty());
                    case 5 -> System.out.println("Queue is full: " + queue.isFull());
                    case 6 -> queue.display();
                    case 7 -> System.out.println("Current size: " + queue.getSize() + "\nCapacity: " + capacity);
                    case 8 -> {
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
