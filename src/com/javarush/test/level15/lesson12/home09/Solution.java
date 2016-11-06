package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
http:
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        String t1 = s.substring(s.indexOf("?")+1);
        String[] t2 = t1.split("&");

        ArrayList<String> par = new ArrayList<String>();
        ArrayList<String> val = new ArrayList<String>();

        for (String k : t2) {
            if (k.contains("=")) {
                String[] t3 = k.split("=");
                par.add(t3[0]);
                if (t3[0].equals("obj")){
                    val.add(t3[1]);
                }
            } else {
                par.add(k);
            }
        }
        for (String k : par) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (String k : val) {
            try {
                alert(Double.parseDouble(k));
            } catch (NumberFormatException e) {
                alert(k);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

