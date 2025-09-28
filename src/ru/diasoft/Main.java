package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Artem", "Petrov", 20, "8-900-656-56-98");
        Person person2 = new Person("Egor", "Krutov", 25, "8-965-989-09-07");

        PersonDemo demo1 = new PersonDemo(person1);
        PersonDemo demo2 =new PersonDemo(person2);
        System.out.println("Демонстрация person:");
        demo1.demo();
        demo2.demo();

        Student student = new Student("Anton", "Ivanov", 20, "8-965-989-55-88", "ГРУППА-124", 2);
        PersonDemo studentDemo = new PersonDemo(student);
        System.out.println();
        System.out.println("Демонстрация student:");
        studentDemo.demoStudent();

    }
}