package ru.geekbrains;

public class ObjPriority<T> {
    private T value;
    private int priority;

    public ObjPriority(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "{value=" + value +
                ", priority=" + priority +
                '}';
    }
}
