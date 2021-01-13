package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        System.out.println(exponentiation(3, 19));
        System.out.println(exponentiationFast(3,19));
        int[] arr = {3, 2, 5, 7, 3, 2, -2, 8};
        System.out.println(findMin(arr));
        int[] arr2 = {1, 2, 3, 3};
        System.out.println(calcAvg(arr2));
        System.out.println(9 >> 1);
    }

    //сложность O(n), т.к. требуется n(степень) итераций
    public static int exponentiation(int a, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= a;
        }
        return res;
    }

    //сложность O(n), т.к. требуется n итераций(один полный проход по массиву)
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //сложность O(n), т.к. требуется n итераций(один полный проход по массиву)
    public static float calcAvg(int[] arr) {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    //сложность O(log(n)). Внутри цикла фиксированное число операций (2 или 3), итераций цикла (целая часть log(n))+1.
    public static int exponentiationFast(int a, int n) {
        int res = 1;
        int exp = 1;
        int i = n;
        while (i > 0) {
            if (exp == 1) {
                exp = a;
            } else {
                exp = exp * exp;
            }
            if ((i & 1) == 1) {
                res *= exp;
            }
            i = i >> 1;
        }
        return res;
    }
}
