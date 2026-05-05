package strategy;

import model.Student;
import java.util.Comparator;
import java.util.List;

public class SortByIdStrategy implements SortingStrategy {
    @Override
    public void sort(List<Student> students) {
        students.sort(Comparator.comparing(Student::getId));
    }
}
