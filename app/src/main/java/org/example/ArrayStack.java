package org.example;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T> {
    private T[] stackArray;
    private int maxSize;
    private int top;

    public ArrayStack(int capacity) {
        this.maxSize = capacity;
        this.stackArray = (T[]) new Object[capacity];
        this.top = -1;
    }

    @Override
    public void push(T item) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push item: " + item);
            return;
        }
        stackArray[++top] = item;
    }

    @Override
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        T item = stackArray[top];
        stackArray[top--] = null; // Help GC
        return item;
    }

    @Override
    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return stackArray[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= top; i++) {
            stackArray[i] = null;
        }
        top = -1;
    }
}
