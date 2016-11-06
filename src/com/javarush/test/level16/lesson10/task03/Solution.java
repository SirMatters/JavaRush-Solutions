package com.javarush.test.level16.lesson10.task03;

/* Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
*/
///// код изменен для проверки прерывания!
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread t = new TestThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run() {
                while (!Thread.currentThread().isInterrupted()) { //иначе нитка не узнает что ее надо бы прервать!
                    System.out.println("1");
                }
        }
    }
}
