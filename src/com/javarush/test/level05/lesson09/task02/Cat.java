package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    private String name;
    private double weight;
    private int age;
    private String colour;
    private String adress;

    public Cat(String name) {
        this.name = name;
        this.weight = 1.0;
        this.adress = null;
    }

    public Cat(String name,double weight, int age) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.adress = null;
    }

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
        this.weight = 1.0;
        this.adress = null;
    }
    public Cat(double weight, String colour){
        this.weight = weight;
        this.colour = colour;
        this.adress = null;
        this.name = null;
    }
    public Cat(double weight, String colour, String adress){
        this.weight = weight;
        this.colour = colour;
        this.adress = adress;
    }
    //напишите тут ваш код
}

