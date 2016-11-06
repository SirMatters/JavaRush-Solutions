package com.javarush.test.level14.lesson08.bonus01;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.*;
import java.util.zip.DataFormatException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        exceptions.add(new IOException());
        exceptions.add(new NullPointerException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new DataFormatException());
        exceptions.add(new NoSuchElementException());
        exceptions.add(new InterruptedIOException());
        exceptions.add(new InputMismatchException());


        //Add your code here

    }
}
