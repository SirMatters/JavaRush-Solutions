package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nn1 = Integer.parseInt(reader.readLine());
        int nn2 = Integer.parseInt(reader.readLine());
        System.out.println(min(nn1,nn2));

    }

    public static int min(int a, int b) {
        if (a<b) return a;
        else return b;

    }
}