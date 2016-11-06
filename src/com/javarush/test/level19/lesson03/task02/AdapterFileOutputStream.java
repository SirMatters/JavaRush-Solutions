package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream FOStream;
    public AdapterFileOutputStream(FileOutputStream stream) {
        this.FOStream = stream;
    }

    @Override
    public void flush() throws IOException {
        this.FOStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.FOStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        this.FOStream.close();
    }
}

