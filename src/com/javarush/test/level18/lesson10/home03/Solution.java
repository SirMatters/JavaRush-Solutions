package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        String s2;
        String s3;
        s1 = r.readLine();
        FileInputStream in2 = new FileInputStream(s2 =r.readLine());
        FileInputStream in3 = new FileInputStream(s3 =r.readLine());
        FileOutputStream out1 = new FileOutputStream(s1, true);
        while (in2.available() > 0) {
            out1.write(in2.read());
        }
        while (in3.available() > 0) {
            out1.write(in3.read());
        }
        r.close();
        out1.close();
        in2.close();
        in3.close();
    }
}
