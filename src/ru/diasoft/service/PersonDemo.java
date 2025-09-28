package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class PersonDemo {
   private Person person;

    public PersonDemo(Person person) {
        this.person = person;
    }

    public void demo() {
        PersonPrinter.printFI(person);
        PersonPrinter.printInfo(person);
    }
    public void demoStudent() {
        if (person instanceof Student) {
            Printer studentPrinter = new StudentPrinter();
            studentPrinter.printInfo(person);

        }
    }
}

