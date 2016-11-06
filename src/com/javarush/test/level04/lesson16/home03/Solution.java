package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int sum = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int h = Integer.parseInt(r.readLine());
            sum += h;
             if (h == -1) {
                 break;
             }
        }
        System.out.println(sum);
    }
}