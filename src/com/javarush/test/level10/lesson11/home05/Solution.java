package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        int[] abcN = new int[abcArray.length];

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)  {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (int i = 0; i < list.size(); i++) {
            char[] ss = list.get(i).toCharArray();
            for (int j = 0; j < abcArray.length; j++) {
                for (int k = 0; k < ss.length; k++) {
                    if (abcArray[j] == ss[k]) {
                        abcN[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < abcN.length; i++) {
            System.out.println(abcArray[i] + " " + abcN[i]);
        }

    }
}