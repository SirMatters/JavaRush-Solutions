package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Mark", "Markson", 30);
        Person mom = new Person("Lady", "Markson", 55);
        Person dad = new Person("Sir", "Markson", 49);
        Person child1 = new Person("boy", "Markson", 4);
        Person child2 = new Person("girl", "Markson", 1);
        person.setFather(dad);
        person.setMother(mom);
        List<Person> list = new ArrayList<Person>();
        list.add(child1);
        list.add(child2);
        person.setChildren(list);

        System.out.println(person.firstName+" "+person.lastName+" "+person.age+" "+person.father.firstName+" "+person.mother.firstName+" "+person.children);

        File file = new File("C:/Users/K.Perov/Desktop/JAVA/t.txt");
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file));
        OOS.writeObject(person);
        OOS.close();

        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file));
        Person newPerson = (Person) OIS.readObject();
        OIS.close();

        System.out.println(newPerson.firstName+" "+newPerson.lastName+" "+newPerson.age+" "+newPerson.father.firstName+" "+newPerson.mother.firstName+" "+newPerson.children);
    }


    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {}
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }
}
