package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = r.readLine();
        String secondFile = r.readLine();

        BufferedReader bR = new BufferedReader(new FileReader(firstFile));
        BufferedWriter bW = new BufferedWriter(new FileWriter(secondFile, true));
        while (bR.ready()) {
            String s = bR.readLine();
            for (String ss : s.split(" ")) {
                if (isNumber(ss)) {
                    bW.write(ss + " ");
                }
            }
        }
        r.close();
        bR.close();
        bW.close();

    }

    public static boolean isNumber(String s) {
        boolean ans = true;
        try {Double d = Double.parseDouble(s.replaceAll("\uFEFF", ""));}
        catch (NumberFormatException e) { ans = false;}
        return ans;
    }

}
