package ru.diasoft.service;

import ru.diasoft.domain.Person;

public class PersonDemo {
    Person person;

    public PersonDemo(Person person) {
        this.person = person;
    }

    public void demo() {
        PersonPrinter.printFI(person);
        PersonPrinter.printInfo(person);
    }
}
