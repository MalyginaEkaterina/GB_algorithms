package ru.geekbrains;

public class CatIterator {
    private Node cur;
    private DoubleLinkedList list;

    public CatIterator(DoubleLinkedList list) {
        this.list = list;
        this.cur = list.getHead();
    }

    public void reset() {
        cur = this.list.getHead();
    }

    public void resetEnd() {
        cur = this.list.getTail();
    }

    public Node next() {
        Node temp = cur;
        if (cur != null) {
            cur = cur.next;
        }
        return temp;
    }

    public Node prev() {
        Node temp = cur;
        if (cur != null) {
            cur = cur.previous;
        }
        return temp;
    }

    public Node getCurrent() {
        return cur;
    }

    public boolean atEnd() {
        return (cur == null || cur.next == null);
    }

    public boolean atStart() {
        return (cur == null || cur.previous == null);
    }

    public void insertBefore(Cat c) {
        Node n = new Node(c);
        if (cur == null) {
            cur = n;
            this.list.setTail(n);
            this.list.setHead(n);
            return;
        }
        if (cur.previous == null) {
            cur.previous = n;
            n.next = cur;
            this.list.setHead(n);
        } else {
            Node prev = cur.previous;
            prev.next = n;
            n.previous = prev;
            n.next = cur;
            cur.previous = n;
        }
    }

    public void insertAfter(Cat c) {
        Node n = new Node(c);
        if (cur == null) {
            cur = n;
            this.list.setTail(n);
            this.list.setHead(n);
            return;
        }
        if (cur.next == null) {
            cur.next = n;
            n.previous = cur;
            this.list.setTail(n);
        } else {
            Node next = cur.next;
            next.previous = n;
            n.next = next;
            n.previous = cur;
            cur.next = n;
        }
    }

    public void deleteCurrent() {
        if (cur == null) return;
        if (cur.previous == null && cur.next == null) {
            cur = null;
            this.list.setHead(cur);
            this.list.setTail(cur);
        } else if (cur.previous == null) {
            cur = cur.next;
            cur.previous = null;
            this.list.setHead(cur);
        } else if (cur.next == null) {
            cur = cur.previous;
            cur.next = null;
            this.list.setTail(cur);
        } else {
            Node next = cur.next;
            Node prev = cur.previous;
            prev.next = next;
            next.previous = prev;
            cur = prev;
        }
    }
}
