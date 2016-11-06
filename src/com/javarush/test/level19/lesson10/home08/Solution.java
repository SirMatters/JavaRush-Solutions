package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        //String fileName = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        r.close();
        StringBuilder s;
        BufferedReader bFR = new BufferedReader(new FileReader(fileName));
        while (bFR.ready()) {
            s = new StringBuilder(bFR.readLine());
            s.reverse();
            System.out.println(s);
        }
        bFR.close();
    }
}
