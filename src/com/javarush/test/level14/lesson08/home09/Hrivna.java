package com.javarush.test.level14.lesson08.home09;

/**
 * Created by K.Perov on 17.05.2016.
 */
public class Hrivna extends Money {

    public Hrivna(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return "HRN";
    }

}
