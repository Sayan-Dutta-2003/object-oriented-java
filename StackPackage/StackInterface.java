package StackPackage;

public interface StackInterface {
    void push(int value);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull();

    void displayElements();

    int size();
}
