package ru.homework.work4.zoo.animal;

public class Gull extends BaseAnimal {
  private Boolean fly;

  public Gull(String name, String type, String color, Integer age) {
    super(name, type, color, age);
  }

  public void takeWing() {
    this.fly = true;
    System.out.println("Чайка взлетает");
  }

  public void landOn() {
    this.fly = false;
    System.out.println("Чайка приземляется");
  }

  public Boolean getFly() {
    return fly;
  }
}
