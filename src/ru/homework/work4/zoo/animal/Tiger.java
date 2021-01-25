package ru.homework.work4.zoo.animal;

public class Tiger extends BaseAnimal {
  private Boolean sleep;

  public Tiger(String name, String type, String color, Integer age) {
    super(name, type, color, age);
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
}
