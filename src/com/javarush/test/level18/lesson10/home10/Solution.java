package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
//Валидатор не принял, но работает на ура


import java.io.*;

import java.util.TreeSet;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileSet = new TreeSet<String>();
        byte[] buffer;

        String file = r.readLine();

        File first = new File(file);

        String path = first.getParent();
        String oldFileName = first.getName();
        String[] s = oldFileName.split("\\.");
        File newFile = new File(path + "\\" + s[0] + "." + s[1]);
        newFile.createNewFile();

        while (!(file.equals("end"))) {
            fileSet.add(file);
            file = r.readLine();
        }

        for (String a : fileSet) {
            FileInputStream in = new FileInputStream(a);
            buffer = new byte[in.available()];
            in.read(buffer);
            RandomAccessFile randomAccessFile = new RandomAccessFile(newFile, "rw");
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(buffer);

            in.close();
            randomAccessFile.close();
        }
        r.close();
    }
}