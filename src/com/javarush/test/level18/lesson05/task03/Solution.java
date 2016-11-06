package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream in = new FileInputStream(r.readLine());
        FileOutputStream out1 = new FileOutputStream(r.readLine());
        FileOutputStream out2 = new FileOutputStream(r.readLine());

        ArrayList<Byte> list = new ArrayList<Byte>();

        while (in.available() > 0) {
            list.add((byte) in.read());
        }

        if (list.size()%2 ==0) {
            for (int i = 0; i < list.size()/2; i++) {
                out1.write(list.get(i));
                out2.write(list.get(i+list.size()/2));
            }
        } else {
            for (int i = 0; i < list.size()/2; i++) {
                out2.write(list.get(i));
            }
            for (int i = list.size()/2; i <list.size(); i++) {
                out1.write(list.get(i));
            }
        }
        r.close();
        in.close();
        out1.close();
        out2.close();
    }
}
