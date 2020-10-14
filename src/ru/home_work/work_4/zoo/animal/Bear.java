package ru.home_work.work_4.zoo.animal;

public class Bear extends BaseAnimal {
    public Boolean sleep;

    public Bear(String name, String type, String color, Integer age) {
        super(name, type, color, age);
    }

    public void fishing() {
        System.out.println("Медведь идет ловить рыбу");
    }

    public void goToSleep() {
        this.sleep = true;
        System.out.println("Медведь уходит в спячку");
    }


}
