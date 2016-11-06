package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human GF1 = new Human("GF1",true,66,null,null);
        Human GF2 = new Human("GF2",true,66,null,null);
        Human GM1 = new Human("GM1",false,66,null,null);
        Human GM2 = new Human("GM2",false,66,null,null);

        Human F = new Human("F",true,50,GF1,GM1);
        Human M = new Human("M",false,50,GF2,GM2);

        Human K1 = new Human("K1", true, 12, F, M);
        Human K2 = new Human("K2", true, 12, F, M);
        Human K3 = new Human("K3", true, 12, F, M);

        System.out.println(GF1);
        System.out.println(GF2);
        System.out.println(GM1);
        System.out.println(GM2);

        System.out.println(F);
        System.out.println(M);

        System.out.println(K1);
        System.out.println(K2);
        System.out.println(K3);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}

