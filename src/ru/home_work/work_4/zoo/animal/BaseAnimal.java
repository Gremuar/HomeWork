package ru.home_work.work_4.zoo.animal;

import static java.lang.Thread.sleep;

public class BaseAnimal {
    private String name;
    private String type;
    private String color;
    private Integer age;
    private Boolean moving;

    public BaseAnimal(String name, String type, String color, Integer age) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.age = age;
        this.moving = false;
    }

    public void say(String msg) {
        System.out.println(this.name + " произносит " + msg);
    }

    public void move(Integer len) throws InterruptedException {
        for(int i = 1; i <= len; i++) {
            if(i == 1 || i == len) this.moving = !this.moving;
            sleep(1000);
            System.out.println("Пройдено " + i + " шагов, осталось " + (len - i));
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
