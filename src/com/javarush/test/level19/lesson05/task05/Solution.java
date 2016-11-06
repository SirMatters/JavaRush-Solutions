package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = r.readLine();
        String secondFile = r.readLine();
        r.close();

        //String firstFile = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        //String secondFile = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t1.txt";

        BufferedReader bR = new BufferedReader(new FileReader(firstFile));
        BufferedWriter bW = new BufferedWriter(new FileWriter(secondFile));
        while (bR.ready()) {
            bW.write(bR.readLine().replaceAll("\\p{Punct}","").replaceAll(System.getProperty("line.separator"),""));
        }
        bR.close();
        bW.close();
    }
}
