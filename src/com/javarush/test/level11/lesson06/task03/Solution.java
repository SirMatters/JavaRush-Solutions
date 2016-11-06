package com.javarush.test.level11.lesson06.task03;

/* В гостях у бабушки
Написать шесть классов: Animal (животное), Cow(корова) и Pig(свинья), Sheep(овца), Bull(бык), Goat(козел).
Унаследовать корову, свинью, овцу, быка и козла от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Animal
    {
        private String name;
    }

    public class Cow extends Animal
    {
        private String moo;
    }

    public class Pig extends Animal
    {
        private String bacon;
    }

    public class Sheep extends Animal
    {
        private String wool;
    }

    public class Bull extends Animal
    {
        private String beef;
    }

    public class Goat extends Animal
    {
        private String horns;
    }

}
