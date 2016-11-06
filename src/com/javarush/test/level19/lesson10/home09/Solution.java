package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
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
        String say = buildString(byteArrayOutputStream.toString());
        byteArrayOutputStream.reset();
        System.setOut(defaultPrintStream);
        System.out.println(say);

}

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    private static String buildString(String s) {
        StringBuilder sB = new StringBuilder();
        String[] aS = s.split(System.getProperty("line.separator"));
        for (int i = 0; i < aS.length ; i++) {
            sB.append(aS[i]).append(System.getProperty("line.separator"));
            if (!(i==0) && !(i%2 == 0)) {
                sB.append("JavaRush - курсы Java онлайн").append(System.getProperty("line.separator"));
            }
        }
        return sB.toString();
    }
}

