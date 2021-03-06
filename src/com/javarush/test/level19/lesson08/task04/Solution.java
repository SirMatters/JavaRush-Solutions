package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(defaultPrintStream);
        String say = byteArrayOutputStream.toString().replaceAll(System.getProperty("line.separator"),"");

        String[] result = say.split(" ");

        Integer.parseInt(result[0]);
        int ans = 0;

        if (result[1].equals("-")) {
            ans =  Integer.parseInt(result[0]) - Integer.parseInt(result[2]);
        } else if (result[1].equals("*")) {
            ans =  Integer.parseInt(result[0]) * Integer.parseInt(result[2]);
        } else {
            ans =  Integer.parseInt(result[0]) + Integer.parseInt(result[2]);
        }
        System.out.println(say + ans);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

