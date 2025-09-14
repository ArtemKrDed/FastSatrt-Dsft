package ru.diasoft.service;

import ru.diasoft.domain.Person;

public class PersonPrinter {
    public static void printFI(Person p) {
        System.out.println("Имя - " + p.getFirstName() + " Фамилия - " + p.getSecondName());
    }

    public static void printInfo(Person p) {
        System.out.println("Имя - " + p.getFirstName() + " Фамилия - " + p.getSecondName() + " Возраст - " + p.getAge() + " Телефон - " + p.getPhone());

    }
}
