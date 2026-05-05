package main;

import factory.ConcreteStudentFactory;
import factory.StudentFactory;
import model.Student;
import service.StudentManager;
import strategy.SortByAverageStrategy;
import strategy.SortByNameStrategy;
import strategy.SortByIdStrategy;
import strategy.SortingStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = StudentManager.getInstance();
        StudentFactory factory = new ConcreteStudentFactory();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistema de Gestión de Estudiantes ===");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes (Orden de registro)");
            System.out.println("3. Listar estudiantes (Orden por Nombre)");
            System.out.println("4. Listar estudiantes (Orden por Promedio Descendente)");
            System.out.println("5. Listar estudiantes (Orden por ID)");
            System.out.println("6. Buscar estudiante por ID");
            System.out.println("7. Eliminar estudiante");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    double average = 0;
                    boolean validAvg = false;
                    while (!validAvg) {
                        System.out.print("Promedio: ");
                        try {
                            average = Double.parseDouble(scanner.nextLine());
                            validAvg = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor ingrese un número válido.");
                        }
                    }

                    System.out.print("Tipo (regular/becado/internacional): ");
                    String type = scanner.nextLine();

                    try {
                        Student student = factory.createStudent(type, id, name, average);
                        manager.addStudent(student);
                        System.out.println("¡Estudiante agregado exitosamente!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    displayStudents(manager.getAllStudents());
                    break;
                case "3":
                    List<Student> studentsByName = manager.getAllStudents();
                    SortingStrategy sortByName = new SortByNameStrategy();
                    sortByName.sort(studentsByName);
                    displayStudents(studentsByName);
                    break;
                case "4":
                    List<Student> studentsByAvg = manager.getAllStudents();
                    SortingStrategy sortByAvg = new SortByAverageStrategy();
                    sortByAvg.sort(studentsByAvg);
                    displayStudents(studentsByAvg);
                    break;
                case "5":
                    List<Student> studentsById = manager.getAllStudents();
                    SortingStrategy sortById = new SortByIdStrategy();
                    sortById.sort(studentsById);
                    displayStudents(studentsById);
                    break;
                case "6":
                    System.out.print("Ingrese ID a buscar: ");
                    String searchId = scanner.nextLine();
                    manager.findStudentById(searchId).ifPresentOrElse(
                            s -> System.out.println("Encontrado: " + s),
                            () -> System.out.println("Estudiante no encontrado."));
                    break;
                case "7":
                    System.out.print("Ingrese ID a eliminar: ");
                    String deleteId = scanner.nextLine();
                    if (manager.deleteStudent(deleteId)) {
                        System.out.println("Estudiante eliminado correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case "8":
                    running = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("--- Lista de Estudiantes ---");
            for (Student s : students) {
                System.out.println(s);
            }
            System.out.println("----------------------------");
        }
    }
}
