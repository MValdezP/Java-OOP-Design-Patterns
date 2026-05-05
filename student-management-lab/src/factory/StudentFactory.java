package factory;

import model.Student;

public interface StudentFactory {
    Student createStudent(String type, String id, String name, double average);
}
