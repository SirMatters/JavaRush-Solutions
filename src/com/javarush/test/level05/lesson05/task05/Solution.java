package com.javarush.test.level05.lesson05.task05;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat qwe = new Cat("qwe",1,2,13);
        Cat qw = new Cat("qw",1,2,33);
        Cat q = new Cat("q",1,4,37);

        System.out.println(qwe.fight(qw));
        System.out.println(qwe.fight(q));
        System.out.println(qw.fight(q));
    }

    public static class Cat {

        public static int count = 0;
        public static int fightCount = 0;

        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            fightCount++;

            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2 ? true : false;
        }
    }
}
