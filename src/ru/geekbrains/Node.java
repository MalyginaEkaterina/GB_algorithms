package ru.geekbrains;

public class Node {
    Cat c;
    Node next;
    Node previous;

    public Node(Cat c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("Node(c=%s)", c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return c.equals(node.c);
    }
}
