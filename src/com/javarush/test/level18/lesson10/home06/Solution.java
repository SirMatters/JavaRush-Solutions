package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = args[0];
        FileInputStream file1 = new FileInputStream(s);
        HashMap <Byte, Integer> map = new HashMap<Byte, Integer>();

        while (file1.available() > 0) {
            byte b = (byte) file1.read();
            if(map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }

        Map<Byte, Integer> map1 = new TreeMap<Byte, Integer>(map);

        for (Map.Entry<Byte, Integer> entry : map1.entrySet()) {
            System.out.println((((char) (entry.getKey()).byteValue())+ " " + entry.getValue()));
        }
        file1.close();
    }
}
