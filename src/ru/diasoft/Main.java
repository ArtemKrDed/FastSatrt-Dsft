package ru.diasoft;

import org.w3c.dom.ls.LSOutput;
import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Artem", "Petrov", 20, "8-999-656-56-98");
            PersonDemo demo = new PersonDemo(person);
            demo.demo();
            System.out.println();
            Student student = new Student("Anton", "Ivanov", 20, "8-965-989-55-88", "ГРУППА-124", 2);
            PersonDemo studentDemo = new PersonDemo(student);
            System.out.println();
            System.out.println("Демонстрация student:");
            studentDemo.demoStudent();
            studentDemo.demoPhoneValidation();

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Ошибка при добавление номера - " + e.getMessage());
        }
    }
}
