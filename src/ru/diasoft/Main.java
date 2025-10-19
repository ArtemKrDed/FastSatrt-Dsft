package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            System.out.println("Демонстрация Студента:");
            studentDemo.demoStudent();
            studentDemo.demoPhoneValidation();
            PersonDemo.demonstrateFacultyService();

            System.out.println("\n Работа сортировки метода sortSubject через лямбда-выражение: ");
            student.addSubject("Математика", 5);
            student.addSubject("Машинострение", 4);
            student.addSubject("Геометрия", 5);
            student.addSubject("Сопромат", 3);
            student.addSubject("Труд", 4);
            //student.addSubject("Английский", 5);
            student.addSubject("Рисование", 4);
            System.out.println("(\n Дисцплины отсортированы по убыванию От Я до А");
            for (Map.Entry<String, Integer> subject : student.getSubjects()) {
                System.out.println("  " + subject.getKey() + " - оценка: " + subject.getValue());
            }

            System.out.println();
            System.out.println("Демонстрация Студентов с дисциплинами:");
            studentDemo.demoStudent();
            System.out.println();
            System.out.println("Демонстрация Lombok");
            Student lombokStudent = new Student("Елена", "Смирнова", 21, "ГРУППА-201", 3);
            System.out.println("Группа: " + lombokStudent.getGroup()); // Геттер от Lombok
            lombokStudent.setGroup("ГРУППА-202"); // Сеттер от Lombok
            System.out.println("Новая группа: " + lombokStudent.getGroup());
            PersonDemo.demonstrateFacultyWork();

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Ошибка при добавление номера - " + e.getMessage());
        }

    }
}



