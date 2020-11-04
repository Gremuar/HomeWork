package ru.homework.work4.zoo.animal;

public class Lion extends BaseAnimal {
  private Boolean sleep;

  public Lion(String name, String type, String color, Integer age) {
    super(name, type, color, age);
  }

  public void goToHunt() {
    System.out.println("Лев выходит на охоту");
  }

  public void goToSleep() {
    this.sleep = true;
    System.out.println("Лев засыпает");
  }

  public Boolean getSleep() {
    return sleep;
  }
}
