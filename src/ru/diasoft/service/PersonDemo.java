package ru.diasoft.service;

import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.repository.FacultyRepository;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;

import java.util.List;
import java.util.Map;

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

    public static void demonstrateFacultyWork() {
        System.out.println("\n Работа FacultyRepository: ");
        FacultyRepository repository = new FacultyRepository();
        Faculty faculty = repository.getFaculty();
        System.out.println("Факультет: " + faculty.getName());
        System.out.println("Количество студентов: " + faculty.getAllStudents().size());
        System.out.println("\n Студенты и Дисциплины: ");
        List<Student> students = faculty.getAllStudents();
        Printer studentPrinter = new StudentPrinter();

        for (Student student : students) {
            studentPrinter.printInfo(student);
        }
        System.out.println("\n Сортировка: ");
        if (!students.isEmpty()) {
            Student firstStudent = students.get(0);
            System.out.println("Дисциплины студента " + firstStudent.getFirstName() + " " +
                    firstStudent.getSecondName() + ":");

            List<Map.Entry<String, Integer>> subjects = firstStudent.getSubjects();
            for (Map.Entry<String, Integer> subject : subjects) {
                System.out.println("  - " + subject.getKey() + ": " + subject.getValue());
            }
        }
    }
}



