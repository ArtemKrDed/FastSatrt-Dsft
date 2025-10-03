package ru.diasoft.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final String name;
    private final List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}