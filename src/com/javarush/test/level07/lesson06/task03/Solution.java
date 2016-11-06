package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        String[] l = new String[5];
        int[] le = new int[l.length];
        int min = 10000;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<l.length; i++) {
            l[i] = r.readLine();
            le[i] = l[i].length();
            if (le[i] < min) {
                min = le[i];
            }
        }

        for (int i=0; i<l.length; i++){
            if (le[i] == min){
                System.out.println(l[i]);
            }
        }
    }
}
