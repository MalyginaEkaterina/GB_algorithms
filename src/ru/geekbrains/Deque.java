package ru.geekbrains;

//2. Создать класс для реализации дека.
public class Deque {
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque(int size) {
        this.deque = new int[size];
        this.head = 0;
        this.tail = -1;
        this.items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == deque.length;
    }

    public int length() {
        return items;
    }

    public void insertTail(int i) {
        if (isFull())
            throw new RuntimeException("Deque is full!");
        if (tail == deque.length - 1) {
            tail = -1;
        }
        deque[++tail] = i;
        items++;
    }

    public void insertHead(int i) {
        if (isFull())
            throw new RuntimeException("Deque is full!");
        if (head == 0) {
            head = deque.length;
        }
        deque[--head] = i;
        items++;
    }

    public int removeTail() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int temp = deque[tail--];
        if (tail == -1) {
            tail = deque.length - 1;
        }
        items--;
        return temp;
    }

    public int removeHead() {
        if (isEmpty()) throw new RuntimeException("Deque is empty");
        int temp = deque[head++];
        head %= deque.length;
        items--;
        return temp;
    }
}
