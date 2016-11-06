package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        //String fileName = "C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt";
        r.close();

        LinkedHashMap<String, String> bufferedFile = bufferLines(fileName);

        //args = new String[] {"-u","19846","НоывяХеротаКотораяТебе","Очень","Нужна", "121", "12"};
        //args = new String[] {"-d","19846"};


        String proceduredId = decorateString(args[1], 8);

        if (args[0].equals("-u")) {
            bufferedFile.put(proceduredId,decorateString(getProductName(args), 30) + decorateString(args[args.length-2], 8) +decorateString(args[args.length-1], 4));
        } else if (args[0].equals("-d")) {
            bufferedFile.remove(proceduredId);
        }

        //sayFile(bufferedFile);
        printFile(fileName, bufferedFile);

    }

    private static LinkedHashMap<String, String> bufferLines (String filename) throws IOException{
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String id;
        String inf;
        String line;
        while (r.ready()) {
            line = r.readLine();
            id = decorateString((line.substring(0,8).replaceAll("\uFEFF", "")).trim(), 8); //remove BOM
            inf = line.substring(8, line.length());
            map.put(id,inf);
        }
        r.close();
        return map;
    }

    private static void sayFile(LinkedHashMap<String, String > map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + entry.getValue() + System.getProperty("line.separator"));
        }
    }

    private static void printFile(String fileName,LinkedHashMap<String, String > map) throws IOException {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            w.write(entry.getKey() + entry.getValue());
            w.newLine();
        }
        w.close();
    }

    private static String decorateString(String s, int length) {
        String newS = s;
        if (s.length() > length) {
            newS = s.substring(0,length);
        } else if (s.length() < length) {
            while (newS.length() < length) {
                newS+=" ";
            }
        }
        return newS;
    }

    private static String getProductName(String[] a) {
        String s = "";
        for (int i = 2; i < a.length - 2; i++) {
            s+=a[i]+" ";
        }
        return s;
    }
}
