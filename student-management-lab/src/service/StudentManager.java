package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManager {
    private static StudentManager instance;
    private final List<Student> students;

    private StudentManager() {
        students = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public boolean deleteStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}
