package com.javarush.test.level11.lesson06.task02;

/* Домашние животные
Написать три класса: Pet (домашнее животное), Cat(кот) и Dog(собака).
Унаследовать кота и собаку от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Pet
    {
        private String name;
    }

    public class Cat extends Pet
    {
        private String meow;
    }

    public class Dog extends Pet
    {
        private String woof;
    }
}
