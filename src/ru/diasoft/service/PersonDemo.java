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
    public static void demonstrateFacultyService() {
        System.out.println("\n Stream API");
        FacultyService facultyService = new FacultyServiceReal();
            Student student1 = new Student("Иван", "Глыбов", 20, "Имат-144", 1);
            student1.addSubject("Информатика", 5);
            student1.addSubject("Физика", 5);

            Student student2 = new Student("Иван", "Васьков", 21, "Имат-178", 2);
            student2.addSubject("Информатика", 4);
            student2.addSubject("Физика", 5);

            Student student3 = new Student("Олег", "Лосев", 22, "Имат-188", 1);
            student3.addSubject("Информатика", 5);
            student3.addSubject("Физика", 4);

            Student student4 = new Student("Петр", "Сумкин", 22, "Имат-156", 1);
            student3.addSubject("Информатика", 5);
            student3.addSubject("Физика", 4);

            Student student5 = new Student("Андрей", "Рожков", 22, "Имат-135", 1);
            student3.addSubject("Информатика", 5);
            student3.addSubject("Физика", 4);

            Student student6 = new Student("Павел", "Листов", 22, "Имат-148", 1);
            student3.addSubject("Информатика", 5);
            student3.addSubject("Физика", 4);

            facultyService.addStudent(student1);
            facultyService.addStudent(student2);
            facultyService.addStudent(student3);
            facultyService.addStudent(student4);
            facultyService.addStudent(student5);
            facultyService.addStudent(student6);

            System.out.println("1. Студенты с именем 'Иван':");
            facultyService.findStudentName("Иван").forEach(s -> System.out.println("   " + s.getFirstName() + " " + s.getSecondName()));

            System.out.println("\n2. Сортировка студентов по фамилии:");
            facultyService.shortStudentSecondName().forEach(s -> System.out.println("   " + s.getSecondName() + " " + s.getFirstName()));

            System.out.println("\n3. Отличники: ");
            List<Student> bestStudents = facultyService.findStudentFiveScore();
            if (bestStudents.isEmpty()) {
                System.out.println("   Отличников нет");
            } else {
                bestStudents.forEach(s -> System.out.println("   " + s.getFirstName() + " " + s.getSecondName()));
            }

        }
    }






