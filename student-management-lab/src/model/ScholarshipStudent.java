package model;

public class ScholarshipStudent extends Student {
    public ScholarshipStudent(String id, String name, double average) {
        super(id, name, average);
    }

    @Override
    public String getDetails() {
        return "Becado";
    }
}
