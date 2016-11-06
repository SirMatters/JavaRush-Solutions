package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JANUARY 1 2013");
    }

    public static boolean isDateOdd(String date)
    {
        Date td = new Date(date);
        System.out.println(td);
        int ye = td.getYear();
        Date cd = new Date(ye, 0, 0);
        System.out.println(cd);

        long dif = (td.getTime()-cd.getTime())/(60*60*24*1000);
        System.out.println(dif);
        return(dif%2!=0);
    }
}
