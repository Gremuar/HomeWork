package ru.homework.work4.zoo.animal;

public class Wolf extends BaseAnimal {
  private Boolean sleep;

  public Wolf(String name, String type, String color, Integer age) {
    super(name, type, color, age);
  }

  public void gatherFlock() {
    System.out.println("Вы слышите призывный вой");
  }

  public void goToSleep() {
    this.sleep = true;
    System.out.println("Волк засыпает");
  }

  public Boolean getSleep() {
    return sleep;
  }
}
