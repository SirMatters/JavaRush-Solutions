package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> se = new HashSet<String>();
        String l = "Л";
        for (int i = 0; i <20; i++) {
            se.add(l);
            l = l + "л";
        }
        return se;
    }
}
