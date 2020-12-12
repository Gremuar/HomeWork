package ru.homework.work10;

import java.util.ArrayList;
import java.util.function.Predicate;

class predInteger {
  private int value;
//  private Predicate<Integer> isPrime =  x->x==x;
//  private Predicate<Integer> isPrime =  x->x==x;
//  private Predicate<Integer> isPrime =  x->x==x;

  public predInteger(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}

public class Generic {
   /*
   (Generics) Напишите общий метод для подсчета количества элементов в коллекции,
  которые имеют определенное свойство (например, нечетные целые числа, простые числа, палиндромы).
  Данное свойство реализовать через функциональный интерфейс,
  который возвращает true/false в зависимости от принадлежности к свойству или нет
 */

  public static int countIf(ArrayList<Integer> array, Predicate<Integer> predicate) {
    return 0;
  }

  public static void main(String[] args) {

  }
}
