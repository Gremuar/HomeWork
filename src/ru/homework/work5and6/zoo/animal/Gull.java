package ru.homework.work5and6.zoo.animal;

import static java.lang.Thread.sleep;

import ru.homework.work5and6.zoo.interfaces.Eating;
import ru.homework.work5and6.zoo.interfaces.Fly;

public class Gull extends BaseAnimal implements Fly, Eating {
  private Boolean fly;
  private Boolean eats;

  /**
   * Instantiates a new Gull.
   *
   * @param name  the name
   * @param type  the type
   * @param color the color
   * @param age   the age
   */
  public Gull(String name, String type, String color, Integer age) {
    super(name, type, color, age);
    this.fly = false;
    this.eats = false;
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
    System.out.println("Итого пропрыгано " + len + " шагов");
  }

  public void say(String msg) {
    System.out.println(this.name + " произносит " + msg);
  }

  public Boolean getFly() {
    return fly;
  }

  public Boolean getEats() {
    return eats;
  }

  @Override
  public void takeWing() {
    this.fly = true;
    System.out.println("Чайка взлетает");
  }

  @Override
  public void landOn() {
    this.fly = false;
    System.out.println("Чайка приземляется");
  }

  @Override
  public void eat(int num) {
    this.eats = true;
    //какие то действия
    System.out.println("Клюет " + num + "шт. рачков");
    this.eats = false;
  }

  @Override
  public String toString() {
    return "Gull{"
        + "fly=" + fly
        + ", name='" + name + '\''
        + ", type='" + type + '\''
        + ", color='" + color + '\''
        + ", age=" + age
        + ", moving=" + moving
        + '}';
  }
}
