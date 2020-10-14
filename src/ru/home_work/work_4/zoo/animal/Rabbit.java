package ru.home_work.work_4.zoo.animal;

public class Rabbit extends BaseAnimal {
    public Rabbit(String name, String type, String color, Integer age) {
        super(name, type, color, age);
    }

    @Override
    public void move(Integer len) throws InterruptedException {
        super.move(len);
        System.out.println("Итого пропрыгано " + len + " шагов");
    }

    public void eatCarrots(int num) {
        System.out.println("Грызем " + num + " морковоки(ок)");
    }
}
