package ru.homework.work2;

import java.util.Scanner;

/**
 * The type Print bordered message.
 */
//#2.1
public class PrintBorderedMessage {
  static int width;
  static int height;
  static String msg;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    while (true) {
      getInput();
      debug();
      if (msg.length() + 2 > width || height < 3) {
        System.out.println("Строка не помещается в заданные размеры.");
        System.out.println("Задайте новые размеры.");
        continue;
      }
      debug();
      draw(width, height, msg);
      break;
    }
  }

  /**
   * Draw.
   *
   * @param w the w
   * @param h the h
   * @param t the t
   */
  @SuppressWarnings("checkstyle:LocalVariableName")
  public static void draw(int w, int h, String t) {
    int textLineNum = h % 2 > 0 ? h / 2 + 1 : h / 2;
    int spaces = w - t.length() - 2;
    spaces = (spaces - spaces % 2) / 2;
    String emptyRow = "*" + " ".repeat(w - 2) + "*";
    String textLine = "*" + " ".repeat(spaces) + t + " ".repeat(w - t.length() - spaces - 2) + "*";

    for (int i = 1; i <= h; i++) {
      if (i == 1 || i == h) {
        System.out.println("*".repeat(w));
      } else if (i == textLineNum) {
        System.out.println(textLine);
      } else {
        System.out.println(emptyRow);
      }
    }
  }

  /**
   * Gets input.
   */
  public static void getInput() {
    Scanner input = new Scanner(System.in);
    System.out.print("Введите высоту рамки: ");
    if (input.hasNextInt()) {
      height = input.nextInt();
    } else {
      System.out.println("Высота должна быть целым числом");
      getInput();
      return;
    }
    System.out.print("Введите ширину рамки: ");
    if (input.hasNextInt()) {
      width = input.nextInt();
    } else {
      System.out.println("Ширина должна быть целым числом");
      getInput();
      return;
    }
    System.out.print("Введите сообщение: ");
    msg = input.next();
  }

  /**
   * Debug.
   */
  public static void debug() {
    System.out.println("------Входные данные------");
    System.out.println("Ширина " + width);
    System.out.println("Высота " + height);
    System.out.println("Сообщение: " + msg);
    System.out.println("Длина сообщения: " + msg.length());
    System.out.println(
        "Строка превышает длину рамки: " + ((msg.length() > width + 2 || height < 3) ? "Да" : "Нет")
    );
    System.out.println("--------------------------");
  }
}
