package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Artem", "Petrov", 20, "8-900-656-56-98");
        Person person2 = new Person("Egor", "Krutov", 25, "8-965-989-09-07");

        PersonDemo demo1 = new PersonDemo(person1);
        PersonDemo demo2 =new PersonDemo(person2);
        demo1.demo();
        demo2.demo();

    }
}