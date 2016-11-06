package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private double left, top, width, height;

    public Rectangle(double left, double top, double height, double width){
        this.left=left;
        this.height=height;
        this.top=top;
        this.width=width;
    }
    public Rectangle(double left, double top){
        this.left=left;
        this.height=0;
        this.top=top;
        this.width=0;
    }
    public Rectangle(double left, double top, double width){
        this.left=left;
        this.height=width;
        this.top=top;
        this.width=width;
    }
    public Rectangle(Rectangle r){
        this.left=r.left;
        this.height=r.width;
        this.top=r.top;
        this.width=r.width;
    }
    //напишите тут ваш код

}
