package ru.geekbrains;

public class HashTables {
    public static class Item {
        private int data;
        private Item next;

        public Item(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return data == item.data;
        }
    }

    public static class HashCat {
        private Item[] hashArray;
        private int arraySize;

        public HashCat(int arraySize) {
            this.arraySize = arraySize;
            this.hashArray = new Item[arraySize];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arraySize; i++) {
                if (hashArray[i] != null) {
                    Item cur = hashArray[i];
                    sb.append(cur.getData());
                    while (cur.getNext() != null) {
                        sb.append(", ");
                        cur = cur.getNext();
                        sb.append(cur.getData());
                    }
                } else {
                    sb.append("*");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        private int hashFunc(int key) {
            return key % arraySize;
        }

        public void insert(Item item) {
            int key = item.getData();
            int hashVal = hashFunc(key);
            if (hashArray[hashVal] == null) {
                hashArray[hashVal] = item;
            } else {
                Item cur = hashArray[hashVal];
                if (cur.equals(item)) {
                    return;
                }
                while (cur.getNext() != null) {
                    cur = cur.getNext();
                    if (cur.equals(item)) {
                        return;
                    }
                }
                cur.setNext(item);
            }

        }

        public Item find(int key) {
            int hashVal = hashFunc(key);
            if (hashArray[hashVal] == null) {
                return null;
            } else {
                Item cur = hashArray[hashVal];
                while (cur.getData() != key || cur.getNext() != null) {
                    cur = cur.getNext();
                }
                if (cur.getData() == key) {
                    return cur;
                } else {
                    return null;
                }
            }
        }

        public Item delete(int key) {
            int hashVal = hashFunc(key);
            if (hashArray[hashVal] == null) {
                return null;
            } else {
                Item cur = hashArray[hashVal];
                Item par = null;
                while (cur.getData() != key && cur.getNext() != null) {
                    par = cur;
                    cur = cur.getNext();
                }
                if (cur.getData() == key) {
                    if (par == null) {
                        if (cur.getNext() == null) {
                            hashArray[hashVal] = null;
                        } else {
                            hashArray[hashVal] = cur.getNext();
                        }
                    } else {
                        par.setNext(cur.getNext());
                    }
                    return cur;
                } else {
                    return null;
                }
            }
        }
    }

    public static void main(String[] args) {
        HashCat cat = new HashCat(10);
        cat.insert(new Item(10));
        cat.insert(new Item(11));
        cat.insert(new Item(21));
        cat.insert(new Item(22));
        cat.insert(new Item(55));
        cat.insert(new Item(75));
        cat.insert(new Item(41));
        cat.insert(new Item(71));
        cat.insert(new Item(41));
        System.out.println(cat);
        cat.delete(11);
        System.out.println();
        System.out.println(cat);
    }
}