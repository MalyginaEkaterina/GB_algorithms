package ru.geekbrains;

import java.util.Arrays;

public class PriorityQueue<T> {
    public ObjPriority<T>[] queue;
    private int items;

    public PriorityQueue(int size) {
        queue = new ObjPriority[size];
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == queue.length;
    }

    public int length() {
        return items;
    }

    public void insert(ObjPriority<T> o) {
        if (isFull())
            throw new RuntimeException("Queue is full!");
        if (items == 0) {
            queue[0] = o;
        } else {
            for (int i = items - 1; i >= 0; i--) {
                if (queue[i].getPriority() <= o.getPriority()) {
                    queue[i + 1] = queue[i];
                    queue[i] = o;
                } else {
                    queue[i + 1] = o;
                }
            }
        }
        items++;

    }

    public ObjPriority<T> remove() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queue[--items];
    }

    public static void main(String[] args) {
        ObjPriority<Integer> o1 = new ObjPriority<>(11, 1);
        ObjPriority<Integer> o2 = new ObjPriority<>(12, 2);
        ObjPriority<Integer> o3 = new ObjPriority<>(13, 3);
        ObjPriority<Integer> o4 = new ObjPriority<>(14, 4);
        ObjPriority<Integer> o5 = new ObjPriority<>(15, 4);
        ObjPriority<Integer> o6 = new ObjPriority<>(16, 4);
        PriorityQueue<Integer> q = new PriorityQueue<>(5);
        q.insert(o2);
        q.insert(o1);
        q.insert(o4);
        q.insert(o3);
        q.insert(o5);
        System.out.println(Arrays.toString(q.queue));
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.insert(o1);
        System.out.println(q.remove());
    }
}
