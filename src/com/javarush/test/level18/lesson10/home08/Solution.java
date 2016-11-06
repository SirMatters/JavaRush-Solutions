package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.System.in;
import static java.lang.System.setOut;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources

*/
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String file;
        try {
            while (!((file = r.readLine()).equals("exit"))) {
                Thread t = new ReadThread(file);
                t.start();
            }
            r.close();
        } catch (Exception e) {
        }


    }

    public static class ReadThread extends Thread {
       private String filename;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        public ReadThread(String fileName) {
            this.filename = fileName;
        }

        public void run() {
            try {
                int max = -1;
                FileInputStream in = new FileInputStream(filename);
                while (in.available() > 0) {
                    int b = in.read();
                    if (map.containsKey(b)) {
                        map.put(b, map.get(b) + 1);
                    } else {
                        map.put(b, 1);
                    }
                }
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    if (m.getValue() > max) {
                        max = m.getValue();
                    }
                }

                synchronized (resultMap) {
                    for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                        if (m.getValue() == max) {
                            Solution.resultMap.put(filename, m.getKey());
                        }
                    }
                }
                in.close();
            } catch (Exception e) {

            }
        }
    }
}