package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //String file = r.readLine(); r.close();
        String file = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt"; args = new String[]{"span"};
        String bufferedFile = bufferFileToString(file);
        HashMap<Integer, Integer> map = whereTags(bufferedFile,args[0]);
        outputRight(map, bufferedFile);
    }

    private static HashMap<Integer, Integer> whereTags(String s, String tag) throws IOException{
        StringBuilder sB = new StringBuilder();
        ArrayList<Integer> sList = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j; // tag beginning position
        for (int i = 0; i < s.length(); i++) {
            j = i-tag.length()-1;

            if (sB.append(s.charAt(i)).toString().length() > tag.length() + 2) {
                sB.deleteCharAt(0);
                if (sB.toString().contains("<" + tag) && sB.toString().charAt(0) == 60) {
                    sList.add(j);
                } else if (sB.toString().contains("</" + tag)) {
                    map.put(sList.get(sList.size()-1), i+2);
                    sList.remove(sList.size()-1);
                }
            }
        }
        return map;
    }

    private static void outputRight(HashMap<Integer, Integer> map, String s) {
        TreeSet<Integer> set = new TreeSet<Integer>(map.keySet());
        for (Integer i : set) {
            System.out.println(s.substring(i, map.get(i)));
        }
    }

    private static String bufferFileToString(String fileName) throws IOException {
        StringBuilder sB = new StringBuilder();
        BufferedReader bFR = new BufferedReader(new FileReader(fileName));
        while(bFR.ready()) {
            sB.append(bFR.readLine());
        }
        bFR.close();
        return sB.toString().replaceAll("\r\n","");
    }
}