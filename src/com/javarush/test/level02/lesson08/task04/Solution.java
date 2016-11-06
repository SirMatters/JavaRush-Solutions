package com.javarush.test.level02.lesson08.task04;
public class Solution {
    public static int min(int a, int b, int c, int d) {
        if (min(a,b)<min(c,d)) return min(a,b);
        else return min(c,d);
    }

    public static int min(int a, int b) {
        if (a<b) return a;
        else return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println( min(-20, -10) );
        System.out.println( min(-20, -10, -30, -40) );
        System.out.println( min(-20, -10, -30, 40) );
    }
}