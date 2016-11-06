package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by K.Perov on 19.05.2016.
 */
public class Singleton {
    private static Singleton s = new Singleton();
    public static Singleton getInstance() {
        return s;
    }

    private Singleton() {
    }
}
