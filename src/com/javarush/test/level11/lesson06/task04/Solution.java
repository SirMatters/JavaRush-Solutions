package com.javarush.test.level11.lesson06.task04;

/* Все мы работники
Написать четыре класса: Employee(сотрудник), Manager(управляющий), Chief(директор) и  Secretary(секретарь).
Унаследовать управляющего, директора и секретаря от сотрудника.
*/

public class Solution
{
    public class Manager extends Employee
    {
        private String assistant;
    }

    public class Chief extends Employee
    {
        private String rights;
    }

    public class Employee
    {
        private String name;
    }

    public class Secretary  extends Employee
    {
        String coffee;
    }
}
