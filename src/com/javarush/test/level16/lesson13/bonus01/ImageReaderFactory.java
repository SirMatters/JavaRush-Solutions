package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by K.Perov on 17.07.2016.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes a) {
        ImageReader r;
        if (a == ImageTypes.BMP) {
            r = new BmpReader();
        } else if (a == ImageTypes.PNG) {
            r = new PngReader();
        } else if (a == ImageTypes.JPG) {
            r = new JpgReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return r;
    }
}
