 package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

 import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 import java.util.ArrayList;

 import static java.util.Collections.sort;

 public class Solution  {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //InputStream in = new FileInputStream("C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt");
        InputStream in = new FileInputStream(f.readLine());
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String line = null;
        while ((line = r.readLine()) != null) {
            if (Integer.parseInt(line)%2 == 0) {
                list.add(Integer.parseInt(line));
            }
        }
        sort(list);

        for (int i : list) {
            System.out.println(i);
        }
    }
}
