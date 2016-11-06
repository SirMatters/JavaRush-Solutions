package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int t = 0;
        for (int i = 1; i < min(a, b); i++) {

            if ((a%i == 0) && (b%i == 0)) {
                t = i;
            }
        }
        System.out.println(t);
    }
    public static int min(int a, int b) {
        if (a<b) {
            return a;
        } else return b;
    }
}

