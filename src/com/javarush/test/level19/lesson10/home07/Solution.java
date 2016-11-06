package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt","C:\\Users\\K.Perov\\Desktop\\JAVA\\t1.txt"};
        BufferedReader bFR = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bFW = new BufferedWriter(new FileWriter((args[1]),true));
        String line;
        String[] aLine;
        ArrayList<String> list = new ArrayList<String>();
        while (bFR.ready()) {
            line = bFR.readLine();
            aLine = line.split(" ");
            for(String s : aLine) {
                if (s.length()>6) {
                    list.add(s);
                    System.out.println(s);
                }
            }
        }
        printList(list, bFW);
        bFR.close();
        bFW.close();
    }

    private static void printList(ArrayList<String> list, BufferedWriter w) throws IOException {
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            w.write(itr.next());
            if (itr.hasNext()) {
                w.write(",");
            }
        }
    }
}

