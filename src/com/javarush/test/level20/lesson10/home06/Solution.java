package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SubSolution ss = new SubSolution();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/JavaDev/t.txt"));
        oos.writeObject(ss);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/JavaDev/t.txt"));
        SubSolution sss = (SubSolution) ois.readObject();

    }
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream stream) throws IOException {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }

    }
}
