package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[] {"C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt"};
        HashMap<String , Double > map = sumValues(args[0]);
        TreeSet<String > set = sortMap(map);
        sayFile(map, set);
    }

    private static void sayFile(Map<String, Double> map, Set<String> set) {
        for (String s : set) {
            System.out.println(s + " " + map.get(s));
        }
    }

    private static HashMap<String, Double> sumValues (String filename) throws IOException {
        HashMap<String, Double> map = new HashMap<String, Double>();
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String name;
        Double salary;
        String line;
        while (r.ready()) {
            line = r.readLine();
            //name = line.split(" ")[0].replaceAll("\uFEFF", "");
            name = line.split(" ")[0];
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

    private static TreeSet sortMap (Map<String, Double> map) {
        TreeSet<String> set = new TreeSet<String>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            set.add(entry.getKey());
        }
        return set;
    }
}