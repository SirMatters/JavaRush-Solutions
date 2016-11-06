package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = r.readLine();
        String secondFile = r.readLine();

        FileInputStream in = new FileInputStream(firstFile);
        FileOutputStream out = new FileOutputStream(secondFile);
        int id = 1;
        while (in.available() > 0 ){
            int k = in.read();
            if (id%2 == 0) {
                out.write((byte) k);
            }
            id++;
        }

        r.close();
        in.close();
        out.close();
    }
}
