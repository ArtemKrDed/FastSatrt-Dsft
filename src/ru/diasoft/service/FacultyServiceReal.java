package ru.diasoft.service;
import ru.diasoft.domain.Student;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyServiceReal implements FacultyService {
    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findStudentName(String firstName) {
        return students.stream().filter(student -> student.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
    }

    @Override
    public List<Student> shortStudentSecondName() {
        return students.stream().sorted(Comparator.comparing(Student::getSecondName)).collect(Collectors.toList());
    }

    @Override
    public List<Student> findStudentFiveScore() {
        return students.stream().filter(student -> student.getSubjects().stream().allMatch(subject -> subject.getValue() == 5)).collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}

