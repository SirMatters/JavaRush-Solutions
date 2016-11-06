package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String file1 = r.readLine();
        String file2 = r.readLine();
        r.close();
        //String file1 = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        //String file2 = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t1.txt";

        ArrayList<String> aList = bufferFile(file1);
        ArrayList<String> bList = bufferFile(file2);

        lines = compareLists(aList, bList);

        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }


    }

    private static ArrayList<LineItem> compareLists (List<String> a, List<String> b) {
        ArrayList<LineItem> list = new ArrayList<LineItem>();
        int minLength = Math.min(a.size(), b.size());

        while(a.size() > 1 && b.size() > 1) {
            if (a.get(0).equals(b.get(0))) {
                list.add(new LineItem(Type.SAME, a.get(0)));
                a.remove(0); b.remove(0);
            } else if (a.get(0).equals(b.get(1))) {
                list.add(new LineItem(Type.ADDED, b.get(0)));
                b.remove(0);
            } else {
                list.add(new LineItem(Type.REMOVED, a.get(0)));
                a.remove(0);
            }
        }

        // тк каждая операция разделена сэймом : ab a, ab b; a ab, a ba; a a
        if (a.size() > b.size()) {
            if (a.get(0).equals(b.get(0))) {
                list.add(new LineItem(Type.SAME,a.get(0)));
                list.add(new LineItem(Type.REMOVED,a.get(1)));
            } else {
                list.add(new LineItem(Type.REMOVED,a.get(0)));
                list.add(new LineItem(Type.SAME,a.get(1)));
            }
        } else if (a.size() < b.size()){
            if (a.get(0).equals(b.get(0))) {
                list.add(new LineItem(Type.SAME,a.get(0)));
                list.add(new LineItem(Type.ADDED,b.get(1)));
            } else {
                list.add(new LineItem(Type.SAME,a.get(1)));
                list.add(new LineItem(Type.ADDED,b.get(0)));
            }

        } else {
            list.add(new LineItem(Type.SAME, a.get(0)));
        }

        return list;
    }
    private static ArrayList<String> bufferFile(String file) throws IOException{
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bFR = new BufferedReader(new FileReader(file));
        while (bFR.ready()) {
            list.add(bFR.readLine().replaceAll("\uFEFF",""));
        }
        bFR.close();
        return list;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
