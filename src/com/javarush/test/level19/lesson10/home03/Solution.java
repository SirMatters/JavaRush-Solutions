package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        //args = new String[] {"C:\\Users\\K.Perov\\Desktop\\JAVA\\t.txt"};

        BufferedReader bR = new BufferedReader(new FileReader(args[0]));
        String line;
        while (bR.ready()) {
            line = bR.readLine();
            PEOPLE.add(new Person(getName(line), getBirthDate(line)));
        }
        bR.close();
    }

    private static Date getBirthDate(String line) {
        String[] aDate = line.split(" ");
        int year = Integer.parseInt(aDate[aDate.length - 1]);
        int month = Integer.parseInt(aDate[aDate.length - 2]) - 1;
        int day = Integer.parseInt(aDate[aDate.length - 3]);

        Date date = new Date(year, month, day);
        return date;
    }

    private static String getName(String line) {
        String name = "";
        String[] aLine = line.split(" ");
        int nameLength = aLine.length - 3;
        for (int i = 0; i <nameLength; i++) {
            name+=aLine[i]+" ";
        }
        return name.trim();
    }

}
