package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)  throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(r.readLine());
        FileOutputStream out = new FileOutputStream(r.readLine());
        ArrayList<Byte> list = new ArrayList<Byte>();

        while (in.available() > 0) {
            list.add((byte) in.read());
        }
        for (int i = list.size(); i > 0 ; i--) {
            out.write(list.get(i-1));
        }
        r.close();
        in.close();
        out.close();
    }
}
