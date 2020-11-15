package ru.homework.work11;

import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
  public static void main(String[] args) {
    /*
    1. Создайте стрим из случайных положительных и отрицательныхчисел
    2. Выберитетолькоположительные,нечетныечисла
    3. Умножьтекаждоечислона2
    4. Выведитевконсольstream
    5. Сохранитерезультат 15-ти чисел в Set<Integer>
    6. Найдите сумму(используя stream api)
     */
    Stream<Integer> rnd = Stream.generate(() -> {
      Supplier<Integer> r = () -> new Random().nextInt(100);
//      int r = new Random().nextInt(10);
//      int r = (int) Math.round(Math.random() * 10);
      return r.get() > 50 ? r.get() : -r.get();
    });
    Set<Integer> set = rnd
        .filter(x -> x > 0 && x % 2 == 1)
        .map(x -> x * 2)
        .peek(System.out::println)
        .limit(15)
        .collect(Collectors.toSet());
    System.out.print("Summ: " + set.stream()
        .reduce(0, (a, b) -> a + b));
  }
}
