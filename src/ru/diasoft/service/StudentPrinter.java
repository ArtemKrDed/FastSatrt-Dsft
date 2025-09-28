package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class StudentPrinter implements Printer {


    @Override
    public void printInfo(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p; //приведение типов
            //double PI = 3.14;
            //int test = (int) PI;
            PersonPrinter.printInfo(student);
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());
        } else {
            System.out.println("Ошибка: переданный объект не студентом");
        }
        }

    }

