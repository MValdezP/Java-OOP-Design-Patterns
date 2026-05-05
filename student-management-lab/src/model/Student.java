package model;

public abstract class Student {
    private String id;
    private String name;
    private double average;

    public Student(String id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return String.format("[%s] %s - Promedio: %.2f - Tipo: %s", id, name, average, getDetails());
    }
}
