package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(r.readLine());

        while (in.available() > 0) {
            byte b = (byte) in.read();
            if (map.containsKey(b)) {
                int n = map.get(b);
                n++;
                map.put(b, n);
            } else {
                map.put(b, 1);
            }
        }

        int max = -128;
        for (Map.Entry<Byte, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
            }
        }
        for (Map.Entry<Byte, Integer> m : map.entrySet()) {
            if (m.getValue() == max) {
                System.out.println(m.getKey());
            }
        }
        in.close();
    }
}
