package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<String, String>();
    public static Properties pr = new Properties();

    public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);
        new Solution().save(new FileOutputStream("C:\\Users\\K.Perov\\Desktop\\JAVA\\1.properties"));
    }

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(r.readLine());
        r.close();
        load(fileProperties);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        if (pr.size() > 0)
            pr.putAll(properties);
        pr.store(outputStream, "");
        printWriter.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        pr.load(inputStream);
        for (String current : pr.stringPropertyNames())
            properties.put(current, pr.getProperty(current));
        bufferedReader.close();

    }
}
