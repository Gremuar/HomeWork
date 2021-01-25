package ru.homework.work5and6.zoo.animal;

import java.util.ArrayList;
import java.util.Arrays;

abstract class BaseAnimal {
  protected String name;
  protected String type;
  protected ArrayList<String> color = new ArrayList<>();
  protected Integer age;
  public Boolean moving;


  public BaseAnimal(String name, String type, String color, Integer age) {
    this.name = name;
    this.type = type;
    this.color.add(color);
    this.age = age;
    this.moving = false;
  }


  public abstract void say(String msg);

  public abstract void move(Integer len) throws InterruptedException;

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
    this.color.clear();
    this.color.add(color);
  }

  public void setColor(String[] color) {
    this.color = new ArrayList<>(Arrays.asList(color));
  }

  public String[] getColor() {
    return (String[]) color.toArray();
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public abstract String toString();
}
