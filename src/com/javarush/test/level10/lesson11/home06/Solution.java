package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/


public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        String surname;
        int age;
        boolean sex;
        Human father;
        Human mother;

        public Human(String name, String surname,int age, boolean sex, Human father, Human mother) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, String surname,int age,  Human father, Human mother) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, String surname,int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String surname, Human father, Human mother) {
            this.name = name;
            this.surname = surname;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, boolean sex, Human father, Human mother) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name,  Human father, Human mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }
    }
}
