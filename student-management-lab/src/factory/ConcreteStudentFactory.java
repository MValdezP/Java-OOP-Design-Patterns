package factory;

import model.InternationalStudent;
import model.RegularStudent;
import model.ScholarshipStudent;
import model.Student;

public class ConcreteStudentFactory implements StudentFactory {
    @Override
    public Student createStudent(String type, String id, String name, double average) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularStudent(id, name, average);
            case "becado":
                return new ScholarshipStudent(id, name, average);
            case "internacional":
                return new InternationalStudent(id, name, average);
            default:
                throw new IllegalArgumentException("Tipo de estudiante no válido: " + type);
        }
    }
}
