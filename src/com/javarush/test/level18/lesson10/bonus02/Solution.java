package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        r.close();
        //args = new String[] {"-c", "TheNewFuckingShitYou","Really","Need", "121", "12"};

        String newProductName;
        String newProductPrice;
        String newProductQuantity;
        String newProductId;

        if (args[0].equals("-c")) {
            newProductName = decorateString(getProductName(args), 30);
            newProductPrice =  decorateString(args[args.length - 2], 8);
            newProductQuantity = decorateString(args[args.length - 1], 4);
            newProductId = decorateString(getNextId(fileName) + "", 8);

            addLineToFile(fileName,newProductId + newProductName + newProductPrice + newProductQuantity);
       }

    }

    private static int getNextId(String filename) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String s;
        String num;
        int id = 0;
        int max = -1;
        while (fileReader.ready()) {
            s = fileReader.readLine();
            if (!s.isEmpty()) {
                num = s.substring(0,8).trim();
                id = Integer.parseInt(num);
                if (id > max) {
                    max = id;
                }
            }
        }
        fileReader.close();
        return max + 1;
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

    private static void addLineToFile(String filename, String line) throws IOException{
        BufferedWriter BW = new BufferedWriter(new FileWriter(filename, true));
        BW.newLine();
        BW.write(line);
        BW.close();
    }

    private static String getProductName(String[] a) {
        String s = "";
        for (int i = 1; i < a.length - 2; i++) {
            s+=a[i]+" ";
        }
        return s;
    }
}
