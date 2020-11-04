package ru.homework.work5and6.zoo.animal;

import static java.lang.Thread.sleep;

import ru.homework.work5and6.zoo.interfaces.Eating;

public class Bear extends BaseAnimal implements Eating {
  private Boolean sleep;
  private Boolean eats;

  /**
   * Instantiates a new Bear.
   *
   * @param name  the name
   * @param type  the type
   * @param color the color
   * @param age   the age
   */
  public Bear(String name, String type, String color, Integer age) {
    super(name, type, color, age);
    this.sleep = false;
    this.eats = false;
  }

  public void fishing() {
    System.out.println("Медведь идет ловить рыбу");
  }

  public void goToSleep() {
    this.sleep = true;
    System.out.println("Медведь уходит в спячку");
  }

  /**
   * move.
   *
   * @param len the len
   */
  public void move(Integer len) throws InterruptedException {
    for (int i = 1; i <= len; i++) {
      if (i == 1 || i == len) {
        this.moving = !this.moving;
      }
      sleep(1000);
      System.out.println("Пройдено " + i + " шагов, осталось " + (len - i));
    }
    System.out.println("Итого пройдено " + len + " шагов");
  }

  public void say(String msg) {
    System.out.println(this.name + " произносит " + msg);
  }

  @Override
  public void eat(int num) {
    this.eats = true;
    //какие то действия
    System.out.println("Поглощает " + num + "шт. ягод");
    this.eats = false;
  }

  @Override
  public String toString() {
    return "Bear{"
        + "sleep=" + sleep
        + ", name='" + name + '\''
        + ", type='" + type + '\''
        + ", color='" + color + '\''
        + ", age=" + age
        + ", moving=" + moving
        + '}';
  }
}
