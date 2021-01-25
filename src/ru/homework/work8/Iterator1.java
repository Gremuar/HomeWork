package ru.homework.work8;

import java.util.Iterator;

public class Iterator1 implements Iterable<String> {
  /*
  2) (Итератор) последовательность целых чисел с итератором по цифрам десятичного
  представления чисел  (в обратном направлении)
  Дополнительно: в прямом направлении.
   */
  private final String[] numsMass;
  private final String nums;
  private boolean iterReverse;

  /**
   * Instantiates a new Iterator 1.
   *
   * @param nums the nums
   */
  public Iterator1(String nums) {
    this.nums = nums;
    this.numsMass = nums.split("");
    this.iterReverse = true;
  }

  public String getNums() {
    return this.nums;
  }

  public boolean isIterDirection() {
    return iterReverse;
  }

  public void setIterDirection(boolean iterReverse) {
    this.iterReverse = iterReverse;
  }

  @Override
  public Iterator<String> iterator() {
    return iterReverse ? new IntIteratorReverse() : new IntIterator();
  }

  class IntIteratorReverse implements Iterator<String> {
    private int pos = numsMass.length;

    @Override
    public boolean hasNext() {
      pos--;
      return pos >= 0;
    }

    @Override
    public String next() {
      return numsMass[pos];
    }
  }

  class IntIterator implements Iterator<String> {
    private int pos = -1;

    @Override
    public boolean hasNext() {
      pos++;
      return pos < numsMass.length;
    }

    @Override
    public String next() {
      return numsMass[pos];
    }
  }


  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    var x = new Iterator1("123456789101112");
    System.out.println(x.getNums());
    for (String d : x) {
      System.out.println(d);
    }
    x.iterReverse = false;
    System.out.println("*****");
    for (String d : x) {
      System.out.println(d);
    }
  }
}
