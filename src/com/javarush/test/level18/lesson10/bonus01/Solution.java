package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = args[0];
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);

        if (s.equals("-e")){
            while (in.available()>0) {
                byte b = (byte) in.read();
                if (b == Byte.MAX_VALUE) {
                    out.write(Byte.MIN_VALUE);
                } else {
                    out.write(b + 1);
                }
            }
        } else {
            while (in.available() > 0) {
                byte b = (byte) in.read();
                if (b == Byte.MIN_VALUE) {
                    out.write(Byte.MAX_VALUE);
                } else {
                    out.write(b - 1);
                }
            }
        }
        in.close();
        out.close();
    }

}
