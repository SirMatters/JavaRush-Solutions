package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name, colour;
    private double height;

    public Dog(String name) {
        this.name = name;
    }
    public Dog(String name, double height) {
        this.name = name;
        this.height = height;

    }
    public Dog(String name, double height, String colour) {
        this.name = name;
        this.height = height;
        this.colour = colour;
    }
    //напишите тут ваш код

}