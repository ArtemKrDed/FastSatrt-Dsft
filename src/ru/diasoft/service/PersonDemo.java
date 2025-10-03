package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;

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

    public void demoPhoneValidation() {
        System.out.println("Номер телефона - " + (person.getPhone() != null ? person.getPhone() : "- Не указан"));

        String[] validPhones = {
                "+7 (999) 345-67-76",
                "89993456776"
        };

        for (String phone : validPhones) {
            try {
                person.setPhone(phone);
                System.out.println("Номер выбран - " + phone);
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Ошибка номера - " + phone + " - " + e.getMessage());
            }
        }

        String[] invalidPhones = {
                "8999",
                "8999365665789778988",
                "8uyt987",
                "8#999!#8787"
        };
        for (String phone : invalidPhones) {
            try {
                person.setPhone(phone);
                System.out.println("Номер выбран - " + phone);
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Ошибка номера - " + phone + " - " + e.getMessage());
            }
        }
    }
}

