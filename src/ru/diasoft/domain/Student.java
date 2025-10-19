package ru.diasoft.domain;

import lombok.Getter;
import lombok.Setter;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;
import java.util.*;

@Getter
@Setter
public class Student extends Person {
    private String group;
    private int course;
    private List<Map.Entry<String, Integer>> subjects;

    public Student(String firstName, String secondName, int age, String group, int course) {
        super(firstName, secondName, age);
        this.group = group;
        this.course = course;
        this.subjects = new ArrayList<>();
    }

    public Student(String firstName, String secondName, int age, String phone, String group, int course) throws InvalidPhoneNumberException {
        super(firstName, secondName, age, phone);
        this.group = group;
        this.course = course;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(String subjectName, int grade) {
        Map.Entry<String, Integer> subject = new AbstractMap.SimpleEntry<>(subjectName, grade);
        subjects.add(subject);
        sortSubjects();
    }

    public List<Map.Entry<String, Integer>> getSubjects() {
        return new ArrayList<>(subjects);
    }

    private void sortSubjects() {
        subjects.sort((subject1, subject2) -> subject2.getKey().compareTo(subject1.getKey()));
    }
}


/*  ------------Версия класса без LOMBOK--------------------
package ru.diasoft.domain;
import ru.diasoft.service.exceptions.InvalidPhoneNumberException;
import java.util.*;

public class Student extends Person {
    private String group;
    private int course;
    private List<Map.Entry<String, Integer>> subjects;



    public Student(String firstName, String secondName, int age, String group, int course) {
        super(firstName, secondName, age);
        this.group = group;
        this.course = course;
        this.subjects = new ArrayList<>();
    }

    public Student(String firstName, String secondName, int age, String phone, String group, int course) throws InvalidPhoneNumberException {
        super(firstName, secondName, age, phone);
        this.group = group;
        this.course = course;
        this.subjects = new ArrayList<>();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void addSubject(String subjectName, int grade) {
        Map.Entry<String, Integer> subject = new AbstractMap.SimpleEntry<>(subjectName, grade);
        subjects.add(subject);
        sortSubjects();
    }

    public List<Map.Entry<String, Integer>> getSubjects() {
        return new ArrayList<>(subjects);
    }
//  -----------------Использовал этот метод , до задания из модуля 11----------------
//  Задание : Осуществить работу с компаратором в проекте модуля 9 при помощи лямбда-выражения!
//    private void sortSubjects() {
//        Collections.sort(subjects, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> subject1, Map.Entry<String, Integer> subject2) {
//                return subject2.getKey().compareTo(subject1.getKey());
//            }
//        });
//    }
    private void sortSubjects() {
        subjects.sort((subject1, subject2) -> subject2.getKey().compareTo(subject1.getKey()));
}
}*/


