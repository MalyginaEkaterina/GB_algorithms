package ru.geekbrains;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(toPower(2, 5));
        System.out.println(chessKing(5, 0, 0));
        int[][] desk = new int[8][8];
        queen(desk, 2, 0, 1);
        printDesk(desk);
    }

    //1. Написать программу по возведению числа в степень с помощью рекурсии.
    public static int toPower(int base, int n) {
        if (n < 0) {
            throw new RuntimeException("n < 0");
        }
        if (n == 0) {
            return 1;
        }
        return base * toPower(base, --n);
    }

    //2. * Задача о шахматном короле
    public static int chessKing(int n, int i, int j) {
        if (i == n - 1 || j == n - 1) {
            return 1;
        }
        return chessKing(n, i + 1, j) + chessKing(n, i, j + 1);
    }

    //3. * Задача о восьми ферзях
    public static boolean queen(int[][] desk, int x, int y, int qNum) {
        for (int i = 0; i < desk.length; i++) {
            desk[y][i]--;
            desk[i][x]--;
        }
        int xx = x - Math.min(x, y);
        int yy = y - Math.min(x, y);
        while (xx < desk.length && yy < desk.length) {
            desk[yy][xx]--;
            xx++;
            yy++;
        }
        xx = x - Math.min(x, desk.length - 1 - y);
        yy = y + Math.min(x, desk.length - 1 - y);
        while (xx < desk.length && yy >= 0) {
            desk[yy][xx]--;
            xx++;
            yy--;
        }

        desk[y][x] = qNum;

        if (qNum == desk.length) return true;

        int nextY = y + 1;
        for (int nextX = 0; nextX < desk.length; nextX++) {
            if (desk[nextY][nextX] == 0 && queen(desk, nextX, nextY, qNum + 1))
                return true;
        }

        for (int i = 0; i < desk.length; i++) {
            desk[y][i]++;
            desk[i][x]++;
        }
        xx = x - Math.min(x, y);
        yy = y - Math.min(x, y);
        while (xx < desk.length && yy < desk.length) {
            desk[yy][xx]++;
            xx++;
            yy++;
        }
        xx = x - Math.min(x, desk.length - 1 - y);
        yy = y + Math.min(x, desk.length - 1 - y);
        while (xx < desk.length && yy >= 0) {
            desk[yy][xx]++;
            xx++;
            yy--;
        }
        desk[y][x] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int y = 0; y < desk.length; y++) {
            for (int x = 0; x < desk[y].length; x++) {
                System.out.printf("%3d", Math.max(desk[y][x], 0));
            }
            System.out.println();
        }
    }

}
