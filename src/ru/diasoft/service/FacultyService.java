package ru.diasoft.service;
import ru.diasoft.domain.Student;
import java.util.List;

public interface FacultyService {
    List<Student> findStudentName(String firstName);
    List<Student> shortStudentSecondName();
    List<Student> findStudentFiveScore();

    void addStudent(Student student);
    List<Student> getAllStudents();
}


