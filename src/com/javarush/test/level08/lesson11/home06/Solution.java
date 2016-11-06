package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> kids = new ArrayList<Human>();
        ArrayList<Human> par = new ArrayList<Human>();
        ArrayList<Human> fam = new ArrayList<Human>();

        kids.add(new Human("K1", true, 10, null));
        kids.add(new Human("K2", true, 10, null));
        kids.add(new Human("K3", true, 10, null));

        par.add(new Human("D", true, 30, kids));
        par.add(new Human("M", false, 30, kids));

        fam.add(new Human("GM1",false,66, par));
        fam.add(new Human("GM2",false,66, par));
        fam.add(new Human("GD1",true,66, par));
        fam.add(new Human("GD2",true,66, par));

        fam.addAll(0,par);
        fam.addAll(0,kids);

        for (Human i :fam) {
            System.out.println(i);
        }
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (children !=null) {
                this.children = children;
            } else {
                this.children = new ArrayList<Human>();
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
