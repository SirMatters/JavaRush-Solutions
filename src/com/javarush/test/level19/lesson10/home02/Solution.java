package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt"};


        HashMap<String , Double > map = sumValues(args[0]);
        double max = getMaxValue(map);
        sayFile(map, max);
    }

    private static void sayFile(Map<String, Double> map, double max) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue()== max) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static double getMaxValue(HashMap<String, Double> map) {
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    private static HashMap<String, Double> sumValues (String filename) throws IOException {
        HashMap<String, Double> map = new HashMap<String, Double>();
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String name;
        Double salary;
        String line;
        while (r.ready()) {
            line = r.readLine();
            name = line.split(" ")[0].replaceAll("\uFEFF", "");
            salary = Double.parseDouble(line.split(" ")[1]);
            if (!map.containsKey(name)) {
                map.put(name,salary);
            } else {
                map.put(name, map.get(name) + salary);
            }
        }
        r.close();
        return map;
    }
}
