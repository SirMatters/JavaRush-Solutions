package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int j=1;
        while (j<11){
            int i=1;
            while (i<11) {
                System.out.print("S");
                i++;
            }
            j++;
            System.out.println();
        }
    }
}