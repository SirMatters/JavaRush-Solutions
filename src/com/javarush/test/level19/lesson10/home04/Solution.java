package com.javarush.test.level19.lesson10.home04;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String file = bR.readLine();
        //String file = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        bR.close();

        ArrayList<String> list =  bufferLines(file);

        for (String s : list) {
            if (analyzeLine(s, words)) {
                System.out.println(s);
            }
        }
    }

    private static boolean analyzeLine(String line, List<String> list) {
        int i = 0;
        String[] aLine = line.split(" ");
            for (String s : aLine) {
                if (list.contains(s)) {
                    i++;
                }
            }
        return i == 2 ? true : false;
    }

    private static ArrayList<String> bufferLines (String filename) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bFR = new BufferedReader(new FileReader(filename));
        while (bFR.ready()) {
            list.add(bFR.readLine().replaceAll("\uFEFF", ""));
        }
        bFR.close();
        return list;
    }
}
