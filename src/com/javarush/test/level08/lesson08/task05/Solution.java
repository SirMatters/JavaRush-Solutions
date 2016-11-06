package com.javarush.test.level08.lesson08.task05;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("LastName1","Name1");
        map.put("LastName2","Name2");
        map.put("LastName3","Name3");
        map.put("LastName4","Name42");
        map.put("LastName5","Name51");
        map.put("LastName10","Name1");
        map.put("LastName6","Name76");
        map.put("LastName7","Name81");
        map.put("LastName8","Name91");
        map.put("LastName9","Name1");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        for (Map.Entry<String, String> a : map.entrySet()) {
            list.add(a.getValue());
            list1.add(a.getKey());
        }
        for (int i = 0; i <list.size(); i++) {
            String s = list.get(i);
            list.remove(i);
           if (list.contains(s)){
                map.remove(list1.get(i));
            }
            list.add(i,s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
