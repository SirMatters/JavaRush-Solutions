package com.javarush.test.level14.lesson08.home05;


/**
 * Created by K.Perov on 10.05.2016.
 */
public class Computer {
    private Monitor Monitor;
    private Keyboard Keyboard;
    private Mouse Mouse;

    public Computer() {
        this.Monitor = new Monitor();
        this.Mouse = new Mouse();
        this.Keyboard = new Keyboard();
    }

    public Monitor getMonitor() {
        return Monitor;
    }

    public Mouse getMouse() {
        return Mouse;
    }

    public Keyboard getKeyboard() {
        return Keyboard;
    }
}
