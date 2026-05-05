package model;

public class RegularStudent extends Student {
    public RegularStudent(String id, String name, double average) {
        super(id, name, average);
    }

    @Override
    public String getDetails() {
        return "Regular";
    }
}
