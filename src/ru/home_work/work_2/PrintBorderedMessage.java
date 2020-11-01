package ru.home_work.work_2;

import java.util.Scanner;

//#2.1
public class PrintBorderedMessage {
    static int width;
    static int height;
    static String msg;

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            getInput();
            debug();
            if (msg.length() + 2 > width || height < 3) {
                System.out.println("Строка не помещается в заданные размеры.");
                System.out.println("Задайте новые размеры.");
                continue;
            }
            debug();
            draw(width, height, msg);
            flag = !flag;
        }
    }

    public static void draw(int w, int h, String t) {
        int tLineNum = h / 2 + 1;
        int spaces = w - t.length() - 2;
        spaces = (spaces - spaces % 2) / 2;
        String emptyRow = "*" + " ".repeat(w - 2) + "*";
        String tLine = "*" + " ".repeat(spaces) + t + " ".repeat(w - t.length() - spaces - 2) + "*";

        for (int i = 1; i <= h; i++) {
            if (i == 1 || i == h) {
                System.out.println("*".repeat(w));
            } else if (i == tLineNum) {
                System.out.println(tLine);
            } else {
                System.out.println(emptyRow);
            }
        }
    }

    public static void getInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите ширину рамки: ");
        width = input.nextInt();
        System.out.print("Введите высоту рамки: ");
        height = input.nextInt();
        System.out.print("Введите сообщение: ");
        msg = input.next();
    }

    public static void debug() {
        System.out.println("------Входные данные------");
        System.out.println("Ширина " + width);
        System.out.println("Высота " + height);
        System.out.println("Сообщение: " + msg);
        System.out.println("Длина сообщения: " + msg.length());
        System.out.println("Строка превышает длину рамки: " + ((msg.length() > width + 2 || height < 3) ? "Да" : "Нет"));
        System.out.println("--------------------------");
    }
}
