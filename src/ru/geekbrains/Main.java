package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(9,2,3,7,4,5,6,7,1,8,0);
        System.out.println(array);
//        array.delete();
//        array.delete();
//        System.out.println(array);
//        array.delete(2);
//        System.out.println(array);
        array.sortInsert();
        System.out.println(array);
        System.out.println(array.hasValue(7));
    }
}
