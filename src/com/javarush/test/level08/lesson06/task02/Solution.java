package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // ArrayList
        Date ArrBeg = new Date();
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);
        Date ArrEnd = new Date();

        long ArrDif=ArrEnd.getTime() - ArrBeg.getTime();
        System.out.println(ArrDif);

        // LinkedList
        Date LinBeg = new Date();
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
        Date LinEnd = new Date();
        long LinDif = LinEnd.getTime()-LinBeg.getTime();
        System.out.println(LinDif);
    }

    public static void insert10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i <10000; i++) {
            list.add(null);
        }
    }

    public static void get10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i <10000; i++) {
            list.get(i);
        }

    }

    public static void set10000(List list)
    {
        for (int i = 0; i <10000; i++) {
            list.set(i,null);
        }

    }

    public static void remove10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i <10000; i++) {
            list.remove(0);
        }
    }
}
