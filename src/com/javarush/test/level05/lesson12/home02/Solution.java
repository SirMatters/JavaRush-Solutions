package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man ("Ivan", 4, "Serty");
        Man man2 = new Man ("Los", 3, "Gov");
        Woman woman1 = new Woman("Nas", 14, "Serty");
        Woman woman2 = new Woman("Tan", 43, "Serty");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man{
        private String name;
        private String address;
        private int age;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public Man(String name, int age){
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Man(String name){
            this.name = name;
            this.age = 999;
            this.address = null;
        }
        public String toString() {
            return name + " " + age+ " " + address;
        }
    }
    public static class Woman{
        private String name;
        private String address;
        private int age;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public Woman(String name, int age){
            this.name = name;
            this.age = age;
            this.address = null;
        }
        public Woman(String name){
            this.name = name;
            this.age = 999;
            this.address = null;
        }
        public String toString() {
            return name +" " + age+ " " + address;
        }
    }
}
