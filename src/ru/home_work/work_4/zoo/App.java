package ru.home_work.work_4.zoo;

import ru.home_work.work_4.zoo.animal.Bear;
import ru.home_work.work_4.zoo.animal.Gull;
import ru.home_work.work_4.zoo.animal.Rabbit;

//#4
public class App {
//    Необходимо описать классы (всего должны быть семь) для зоопарка.
// 1. Имя пакета для животных может быть например com.zoo.animal, а
//    главный метод находиться например в com.zoo
// 2. Животным необходимо добавить возможность раздачи имен (как сделали в классе) и
// возможности разговора (как сделали в классе).
// 3. Добавить еще два общих метода и два метода, который будет
//    отличаться у каждого животного
// 4. Добавить конструкторы для животных (default, по всем полям).
    public static void main(String[] args) throws InterruptedException {
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
        irvin.eatCarrots(3);
        irvin.move(7);

        topyga.move(4);
        topyga.say("Уаааррр");
        topyga.goToSleep();

        runi.takeWing();
        System.out.println(runi.fly ? "Сечас в полете" : "Сейчас на земле");
        runi.landOn();
    }
}
