package ru.homework.work5and6.zoo;


import ru.homework.work5and6.zoo.animal.Aviary;
import ru.homework.work5and6.zoo.animal.Bear;
import ru.homework.work5and6.zoo.animal.Gull;
import ru.homework.work5and6.zoo.animal.Lion;
import ru.homework.work5and6.zoo.animal.Rabbit;
import ru.homework.work5and6.zoo.animal.Tiger;
import ru.homework.work5and6.zoo.animal.Wolf;
import ru.homework.work5and6.zoo.exception.AviaryDuplicateAnimalException;
import ru.homework.work5and6.zoo.exception.AviaryOverflowException;
/*
Домашняя работа №5:
    Сделать класс BaseAnimal абстрактным.
    Все методы,которые общие для разных животных,сделать абстрактными.
    Методы,которые являются различными для всех животных,
    вынести в интерфейсы.(например,Moveable и т.д)
    Животные подкласса класса Animal должны реализовать(имплементировать)эти интерфейсы.
    Добавить метод с перегрузкой(два метода с одинаковыми именами,но разными параметрами)для Animal.
    Добавить пакет исключений для зоопарка(com.zoo.exception),
    создать два типа(класса)проверяемых исключений.
    Для некоторых методов"бросить"исключения при определенных условиях,
    а в главном методе перехватывать данные исключения.

Домашняя работа №6:
    Создать вольер.Должна быть возможность добавлять/удалять животных.
    Если добавляем одинаковых животных в вольер-отрабатывает исключение.
    Если добавляем животное в заполненный вольер-отрабатывает исключение.
*/

public class App {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws AviaryOverflowException        the aviary overflow exception
   * @throws AviaryDuplicateAnimalException the aviary duplicate animal exception
   */
  public static void main(String[] args)
      throws AviaryOverflowException, AviaryDuplicateAnimalException {
    Rabbit irvin = new Rabbit(
        "Ирвин",
        "кролик",
        "белый",
        2
    );
    Bear topyga = new Bear(
        "Топыга",
        "медведь",
        "коричневый",
        10
    );
    Gull runi = new Gull(
        "Руни",
        "чайка",
        "белый",
        5
    );
    Lion simba = new Lion(
        "Симба",
        "лев",
        "оранжевый",
        6
    );
    Tiger zelos = new Tiger(
        "Зелос",
        "тигр",
        "синий",
        1000
    );
    Wolf cyberwolf = new Wolf(
        "Киберволк",
        "волк",
        "серый",
        15
    );

    /*
    irvin.eat(2);
    irvin.move(2);

    topyga.move(2);
    topyga.say("Уаааррргх");
    topyga.goToSleep();

    runi.takeWing();
    System.out.println(runi.getFly() ? "Сечас в полете" : "Сейчас на земле");
    runi.landOn();

    System.out.println(irvin);
    System.out.println(topyga);
    System.out.println(runi);
    System.out.println(irvin.getName());
    runi.setColor(new String[] {"white", "gray"});
    System.out.println(runi);
     */

    //Вольер
    Bear tern = new Bear("Tern", "Ursus arctos", "Brown", 5);
    Bear wern = new Bear("Wern", "Ursus arctos", "Brown", 4);
    Bear mern = new Bear("Mern", "Ursus arctos", "Brown", 7);
    Bear zern = new Bear("Zern", "Ursus arctos", "Brown", 15);
    Bear kern = new Bear("Kern", "Ursus arctos", "Brown", 6);
    Rabbit meto = new Rabbit("Meto", "Венский белый", "Белый", 3);
    Rabbit keto = new Rabbit("Keto", "Серый Великан", "Серый", 2);
    Rabbit rezo = new Rabbit("Rezo", "Чешский красный", "Красный", 4);
    Gull vigo = new Gull("Vigo", "Озерная", "Серая", 3);
    Gull hijo = new Gull("Higo", "Сизая", "Серая", 5);
    Gull jiro = new Gull("Jigo", "Полярная", "Белая", 2);
    Aviary zone1 = new Aviary(3);
    Aviary zone2 = new Aviary(6);
    Aviary zone3 = new Aviary(3);
    try {
      zone1.add(runi).add(vigo).add(hijo).add(jiro);
    } catch (AviaryOverflowException e) {
      System.out.println(e.getMessage());
    }
    zone2.add(topyga).add(tern).add(wern).add(mern).add(zern).add(kern);
    zone3.add(meto).add(keto).add(rezo);

    System.out.println(zone1.getCurr());
    zone1.printList();
    System.out.println(zone2.getCurr());
    zone2.printList();
    System.out.println(zone3.getCurr());
    zone3.printList();

    zone1.setMax(5);
    try {
      zone1.add(runi).add(vigo);
    } catch (AviaryDuplicateAnimalException e) {
      System.out.println(e.getMessage());
    }
    zone1.printList();
  }
}
