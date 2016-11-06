package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        System.out.println(a+b+c - max(max(a,b),c) - min(min(a,b),c));
    }

    public static int max(int a, int b){
        return (a<b) ? b : a;
        }
    public static int min(int a, int b){
        return (a>b) ? b : a;
        }
    }

