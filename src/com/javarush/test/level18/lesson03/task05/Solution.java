package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(r.readLine());

        while (in.available() > 0) {
            map.put((byte) in.read(), 0);
        }
        ArrayList<Byte> list = new ArrayList<Byte>();
        for (Map.Entry<Byte,Integer> m : map.entrySet()) {
            list.add(m.getKey());
        }
        Collections.sort(list);
        for (Byte a : list) {
            System.out.println(a + " ");
        }
        in.close();

    }
}
