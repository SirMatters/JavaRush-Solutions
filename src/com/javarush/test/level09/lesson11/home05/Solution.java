package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String t = reader.readLine();

        char[] tc = t.toCharArray();
        ArrayList<Character> vowels = new ArrayList<Character>();
        ArrayList<Character> other = new ArrayList<Character>();

        for (int i = 0; i <tc.length; i++) {
            if (Character.isSpaceChar(tc[i])) {
                continue;
            } else if (isVowel(tc[i])) {
                vowels.add(tc[i]);
            } else {
                other.add(tc[i]);
            }
        }

        for (char a : vowels) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (char a : other) {
            System.out.print(a + " ");
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel (char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels) {
            if (c == d)
                return true;
        }
        return false;
    }
}
