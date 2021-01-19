package ru.geekbrains;

import java.util.Arrays;
import java.util.Scanner;
//1. Создать программу, которая переворачивает вводимые строки (читает справа налево) при помощи стека.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            int size = line.length();
            Stack s = new Stack(size);
            for (int i = 0; i < size; i++) {
                s.push((int) line.charAt(i));
            }
            for (int i = 0; i < size; i++) {
                System.out.print((char) s.pop());
            }
        }
    }
}
