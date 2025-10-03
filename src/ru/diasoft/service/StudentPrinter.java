package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import java.util.*;
import java.util.Map;

public class StudentPrinter implements Printer {


    @Override
    public void printInfo(Person p) {
        if (p instanceof Student) {
            Student student = (Student) p;
            System.out.println("СТУДЕНТ: ");
            System.out.println("Имя: " + student.getFirstName());
            System.out.println("Фамилия: " + student.getSecondName());
            System.out.println("Возраст: " + student.getAge() + " лет");
            System.out.println("Телефон: " + (student.getPhone() != null ? student.getPhone() : "не указан"));
            System.out.println("Группа: " + student.getGroup());
            System.out.println("Курс: " + student.getCourse());

            printSubjects(student);
            System.out.println();
        }
    }

    private void printSubjects(Student student) {
        List<Map.Entry<String, Integer>> subjects = student.getSubjects();
        if (subjects.isEmpty()) {
            System.out.println("Дисциплины: нет дисциплин");
        } else {
            System.out.println("Дисциплины: ");
            int index = 1;
            for (Map.Entry<String, Integer> subject : subjects) {
                System.out.println("  " + index + ". " + subject.getKey() + " - " + subject.getValue());
                index++;
            }
        }
    }
}


