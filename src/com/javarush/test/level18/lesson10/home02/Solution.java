package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int n1 = 0;
        int n2 = 0;
        while (file.available() > 0) {
            n1++;
            int c = file.read();
            if (Integer.valueOf(c) == 32) {
                n2++;
            }
        }
        float n = (float) n2/n1 * 100;
        System.out.format("%10.2f%n",n);
        file.close();
    }

}
