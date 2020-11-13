package ru.homework.work9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class IntComporator {
  private Integer intValue;

  public IntComporator(Integer intValue) {
    this.intValue = intValue;
  }

  public Integer getIntValue() {
    return intValue;
  }

  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

  @Override
  public String toString() {
    return "" + this.getIntValue();
  }

  public static void main(String[] args) {
    // 1) (Компаратор) Класс целых чисел с порядком на основе количества простых делителей.

    var list = new ArrayList<>(
        Arrays.asList(
            new IntComporator(6),
            new IntComporator(13),
            new IntComporator(16),
            new IntComporator(27)
        ));
    for (IntComporator i : list) {
      System.out.println(i);
    }
    list.sort(new Comparator<>() {
      final HashMap<Integer, Integer> cache = new HashMap<>();

      @Override
      public int compare(IntComporator o1, IntComporator o2) {
        int val1 = getPrimeDivisors(o1.getIntValue());
        int val2 = getPrimeDivisors(o2.getIntValue());
        return Integer.compare(val1, val2);
      }

      private int getPrimeDivisors(int val) {
        if (cache.containsKey(val)) {
          return cache.get(val);
        }
        int divCount = 0;
        for (int i = 2; i < val; i++) {
          if (val % i == 0) {
            divCount++;
          }
        }
        cache.put(val, divCount);
        return divCount;
      }
    });
    for (IntComporator i : list) {
      System.out.println(i);
    }
  }
}