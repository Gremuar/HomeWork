package ru.homework.work3;

import java.util.Arrays;

//#3.3

public class ArrayReverse {
  //(на массивы) Написать функцию, которая переворачивает массив, размерностью 8.
  //Например,
  //8 7 6 5 4 3 2 1
  //Результат программы:
  //1 2 3 4 5 6 7 8

  public static void main(String[] args) {
    System.out.println(Arrays.toString(arrayReverse(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    System.out.println(Arrays.toString(arrayReverse(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
  }

  /**
   * Функция вовзращает перевернутый массив.
   *
   * @param arr some int[]
   * @return int[]
   */
  public static int[] arrayReverse(int[] arr) {
    int mid = arr.length / 2;
    int[] newArr = new int[arr.length];
    for (int i = 0; i < mid; i++) {
      newArr[i] = arr[arr.length - i - 1];
      newArr[arr.length - i - 1] = arr[i];
    }
    if (arr.length % 2 > 0) {
      newArr[mid] = arr[mid];
    }

    return newArr;
  }
}
