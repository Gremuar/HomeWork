package ru.homework.work5and6.zoo.animal;

import static java.lang.Thread.sleep;

public class Tiger extends BaseAnimal {
  private Boolean sleep;

  public Tiger(String name, String type, String color, Integer age) {
    super(name, type, color, age);
  }

  @Override
  public void say(String msg) {
    System.out.println(this.name + " произносит " + msg);
  }

  @Override
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


  public void goToDrink() {
    System.out.println("Тигр идет на водопой");
  }

  public void goToSleep() {
    this.sleep = true;
    System.out.println("Тигр засыпает");
  }

  public Boolean getSleep() {
    return sleep;
  }

  @Override
  public String toString() {
    return "Tiger{"
        + "sleep=" + getSleep()
        + ", name='" + name + '\''
        + ", type='" + type + '\''
        + ", color=" + color
        + ", age=" + age
        + ", moving=" + moving
        + '}';
  }
}
