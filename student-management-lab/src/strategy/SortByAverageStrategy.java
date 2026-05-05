package strategy;

import model.Student;
import java.util.Comparator;
import java.util.List;

public class SortByAverageStrategy implements SortingStrategy {
    @Override
    public void sort(List<Student> students) {
        students.sort(Comparator.comparingDouble(Student::getAverage).reversed());
    }
}
