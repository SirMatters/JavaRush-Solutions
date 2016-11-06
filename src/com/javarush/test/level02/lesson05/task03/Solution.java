package com.javarush.test.level02.lesson05.task03;

/* У каждого животного должна быть хозяйка.
Создайте объект типа Cat(кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
Присвойте каждому животному владельца (owner).
*/
public class Solution
{
    public static void main(String[] args)
    {
        Woman Kate = new Woman();
        Cat Ti = new Cat();
        Ti.owner = Kate;
        Dog Tm = new Dog();
        Tm.owner= Ti.owner;
        Fish Tf = new Fish();
        Tf.owner  = Kate;
    }

    public static class Cat
    {
        public Woman owner;
    }

    public static class Dog
    {
        public Woman owner;
    }

    public static class Fish
    {
        public Woman owner;
    }

    public static class Woman
    {
    }
}
