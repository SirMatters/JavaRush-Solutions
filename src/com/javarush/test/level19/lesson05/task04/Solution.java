package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = r.readLine();
        String secondFile = r.readLine();
        r.close();

        //String firstFile = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        //String secondFile = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t1.txt";

        FileInputStream iS = new FileInputStream(firstFile);
        FileOutputStream oS = new FileOutputStream(secondFile);

        while (iS.available() > 0) {
            int k = iS.read();
            if (k == 46 ) {
                k = 33;
            }
            oS.write((byte) k);
        }
        iS.close();
        oS.close();
    }
}
