package ru.geekbrains;

public class MainDLL {
    public static void main(String[] args) {
        Cat c1 = new Cat(1, "c1");
        Cat c2 = new Cat(2, "c2");
        Cat c3 = new Cat(3, "c3");
        Cat c4 = new Cat(4, "c4");
        Cat c5 = new Cat(5, "c5");
        DoubleLinkedList l = new DoubleLinkedList();
        l.pushHead(c1);
        l.pushHead(c2);
        l.pushHead(c3);
        l.pushTail(c4);
        CatIterator itr = l.getIterator();
        for (int i = 0; i < 4; i++) {
            System.out.println(itr.next());
        }
        System.out.println(l.contains(c4));
        System.out.println(l.contains(c5));
        itr.reset();
        itr.insertBefore(c5);
        itr.resetEnd();
        for (int i = 0; i < 5; i++) {
            System.out.println(itr.prev());
        }
        System.out.println();
        l.delete(c3);
        itr.reset();
        for (int i = 0; i < 5; i++) {
            System.out.println(itr.next());
        }
    }
}
