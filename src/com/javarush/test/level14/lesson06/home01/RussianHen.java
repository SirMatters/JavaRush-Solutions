package com.javarush.test.level14.lesson06.home01;

/**
 * Created by K.Perov on 06.05.2016.
 */
public class RussianHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 10;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
