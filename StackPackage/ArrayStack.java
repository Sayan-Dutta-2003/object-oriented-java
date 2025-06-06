package StackPackage;

import java.util.EmptyStackException;

public class ArrayStack implements StackInterface{

    private final int[] stackArray;
    private int top;
    private final int capacity;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalStateException("Capacity must be Positive!");
        }
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is Full");
        }
        stackArray[++top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return capacity - 1 == top;
    }

    @Override
    public void displayElements() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println("Stack elements (Top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return top + 1;
    }
}
