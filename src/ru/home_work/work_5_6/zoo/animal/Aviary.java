package ru.home_work.work_5_6.zoo.animal;

import ru.home_work.work_5_6.zoo.exception.AviaryDuplicateAnimalException;
import ru.home_work.work_5_6.zoo.exception.AviaryOverflowException;

import java.util.ArrayList;

public class Aviary {
    private Integer max = 0;
    private Integer curr = 0;
    private String title = "untitled";
    private ArrayList<BaseAnimal> list = new ArrayList<>();

    public Aviary() {
    }

    public Aviary(int max) {
        this.max = max;
    }

    public Aviary(String title, int max) {
        this.title = title;
        this.max = max;
    }

    public Aviary(String title, int max, ArrayList<BaseAnimal> list) {
        this.title = title;
        this.max = max;
        this.list = list;
    }

    public Aviary add(BaseAnimal animal) throws AviaryOverflowException, AviaryDuplicateAnimalException {
        if (this.curr >= max) throw new AviaryOverflowException("Вольер заполнен. Добавление невозможно!");
        if (this.list.contains(animal))
            throw new AviaryDuplicateAnimalException("Ошибка. Животное \""+animal.name+"\", уже находится в вольере");
        this.curr++;
        this.list.add(animal);
        return this;
    }

    boolean del(BaseAnimal animal) {
        if (this.curr > 0) {
            this.curr--;
            this.list.remove(animal);
            return true;
        } else {
            return false;
        }
    }

    boolean clear() {
        this.curr = 0;
        this.list.clear();
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getCurr() {
        return curr;
    }

    public Aviary printList() {
        System.out.println(list);
        return this;
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "max=" + max +
                ", curr=" + curr +
                ", list=" + list +
                '}';
    }
}
