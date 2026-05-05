package model;

public class InternationalStudent extends Student {
    public InternationalStudent(String id, String name, double average) {
        super(id, name, average);
    }

    @Override
    public String getDetails() {
        return "Internacional";
    }
}
