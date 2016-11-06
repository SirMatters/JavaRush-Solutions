package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt","C:\\Users\\K.Perov\\Desktop\\JAVA\\t1.txt"};
        BufferedReader bFR = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bFW = new BufferedWriter(new FileWriter(args[1], true));
        String line;
        String[] aLine;
        while(bFR.ready()) {
            line = bFR.readLine();
            aLine = line.split(" ");
            for (String s : aLine) {
                if (analyzeWord(s)) {
                    bFW.write(s + " ");
                }
            }
        }
        bFR.close();
        bFW.close();

    }

    private static boolean analyzeWord(String s) {
        return s.matches(".*\\d+.*"); //херачит все словно сраный апач
        //return s.matches("[a-zA-Z ]*\\d+.*"); //не учитывает не буквы
    }
}
