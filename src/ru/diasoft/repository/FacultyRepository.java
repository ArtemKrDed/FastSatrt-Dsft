package ru.diasoft.repository;

import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

public class FacultyRepository {
    private Faculty faculty;

    public FacultyRepository() {
        initializeFaculty();
    }

    private void initializeFaculty() {
        faculty = new Faculty("Факультет Машиностроительных Технологий");

        // Добавляем 5-6 студентов (без телефона, поэтому исключение не нужно)
        Student student1 = new Student("Иван", "Грипов", 20, "ИМАТ-121", 1);
        student1.addSubject("Математика", 5);
        student1.addSubject("Машиностроение", 4);

        Student student2 = new Student("Егор", "Ветров", 21, "ИМАТ-122", 1);
        student2.addSubject("История", 4);
        student2.addSubject("Машиностроение", 5);

        Student student3 = new Student("Григорий", "Ронов", 22, "ИМАТ-121", 2);
        student3.addSubject("Геометрия", 5);
        student3.addSubject("Алгоритмы", 4);

        Student student4 = new Student("Олег", "Калитов", 20, "ИМАТ-123", 2);
        student4.addSubject("Геометрия", 3);
        student4.addSubject("Алгоритмы", 5);

        Student student5 = new Student("Дмитрий", "Петров", 23, "ИМАТ-124", 3);
        student5.addSubject("Сопромат", 5);
        student5.addSubject("Машинное обучение", 4);

        Student student6 = new Student("Сергей", "Валиков", 19, "ИМАТ-125", 3);
        student6.addSubject("Сопромат", 4);
        student6.addSubject("Машинное обучение", 5);

        faculty.addStudent(student1);
        faculty.addStudent(student2);
        faculty.addStudent(student3);
        faculty.addStudent(student4);
        faculty.addStudent(student5);
        faculty.addStudent(student6);
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
