package com.javarush.test.level08.lesson08.task03;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        int N = getCountTheSameFirstName(map, "N1");
        int S = getCountTheSameLastName(map, "S1");
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("N1","S1");
        map.put("N2","S2");
        map.put("N3","S3");
        map.put("N4","S1");
        map.put("N5","S5");
        map.put("N6","S6");
        map.put("N7","S1");
        map.put("N8","S8");
        map.put("N9","S1");
        map.put("N10","S10");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<String, String> k = iterator.next();
            String key = k.getValue();
            if (key.equals(name)){
                i++;
            }
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<String, String> k = iterator.next();
            String key = k.getKey();
            if (key.equals(lastName)){
                i++;
            }
        }
        return i;
    }
}
