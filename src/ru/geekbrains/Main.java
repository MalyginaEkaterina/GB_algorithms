package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(1,2,3,4,5,6,7,9,8,10);
        System.out.println(array);
        //array.sortBubble();
        //array.sortSelect();
        array.sortInsert();
        System.out.println(array);
        Array array2 = new Array(1,9,3,4,3,6,7,8,2,0,13,15,16,21,23,14,11,18,3,10,43,3);
        System.out.println(array2);
        //array2.sortBubble();
        //array2.sortSelect();
        //array2.sortInsert();
        System.out.println(array2);
        array2.deleteAll(3);
        System.out.println(array2);
        array2.insert(2, 13);
        System.out.println(array2);
        Array array3 = new Array(-6,-3,-2,-3,-6,-1,-1,0,0,-3,-2);
        System.out.println(array3);
        array3.sortCount(-6,0);
        System.out.println(array3);
        Array array4 = new Array(true,1);
        array4.deleteAllSorted(1);
//        array2.deleteAll();
//        System.out.println(array2);
//        array.delete();
//        array.delete();
//        System.out.println(array);
//        array.delete(2);
//        System.out.println(array);
//        array.sortInsert();
//        System.out.println(array);
//        System.out.println(array.hasValue(7));
    }
}
