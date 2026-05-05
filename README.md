# Student Management Lab

Un sistema de gestión de estudiantes por línea de comandos (CLI) construido en Java puro, diseñado para demostrar el dominio de Programación Orientada a Objetos (OOP), Patrones de Diseño (GoF) y Principios SOLID. Desarrollado como laboratorio para la asignatura de Programación II en Jala University.

## Características

- **CRUD Completo:** Agregar, listar, buscar y eliminar estudiantes.
- **Tipos de Estudiantes:** Soporte para estudiantes Regulares, Becados e Internacionales.
- **Ordenamiento Dinámico:** Capacidad de listar estudiantes por nombre, promedio o ID.

## Patrones de Diseño Utilizados

Este proyecto implementa los siguientes patrones de diseño del Gang of Four (GoF):

1. **Singleton (`StudentManager`):** Garantiza que exista una única instancia del gestor de estudiantes durante toda la ejecución del programa, centralizando el acceso a la colección de datos.
2. **Factory Method (`StudentFactory` / `ConcreteStudentFactory`):** Encapsula y centraliza la lógica de creación de objetos `Student`. Permite instanciar diferentes tipos de estudiantes (Regular, Becado, Internacional) basándose en un parámetro de entrada, sin acoplar el código cliente a las clases concretas.
3. **Strategy (`SortingStrategy` y sus implementaciones):** Define una familia de algoritmos de ordenamiento (por nombre, por promedio, por ID), encapsula cada uno de ellos y los hace intercambiables. Permite que el algoritmo varíe independientemente de los clientes que lo utilizan.

## Principios SOLID Aplicados

- **S - Single Responsibility Principle (SRP):** Cada clase tiene una única responsabilidad. Por ejemplo, `StudentManager` solo administra la colección, y las clases del paquete `strategy` solo se encargan de ordenar.
- **O - Open/Closed Principle (OCP):** El código está abierto a la extensión pero cerrado a la modificación. Nuevos tipos de estudiantes pueden agregarse en la `ConcreteStudentFactory` y nuevas formas de ordenamiento implementando `SortingStrategy`.
- **L - Liskov Substitution Principle (LSP):** Las subclases `RegularStudent`, `ScholarshipStudent` e `InternationalStudent` pueden sustituir a la clase base abstracta `Student` sin alterar el comportamiento del programa.
- **I - Interface Segregation Principle (ISP):** Interfaces pequeñas y específicas como `SortingStrategy` con un único método `sort`.
- **D - Dependency Inversion Principle (DIP):** El servicio depende de abstracciones (`StudentFactory`, `SortingStrategy`) en lugar de implementaciones concretas.

## Estructura del Proyecto

```text
src/
├── main/
│   └── Main.java                 # Punto de entrada de la aplicación
├── model/
│   ├── Student.java              # Clase base abstracta
│   ├── RegularStudent.java       # Implementación concreta
│   ├── ScholarshipStudent.java   # Implementación concreta
│   └── InternationalStudent.java # Implementación concreta
├── factory/
│   ├── StudentFactory.java       # Interfaz Factory
│   └── ConcreteStudentFactory.java # Implementación del Factory
├── strategy/
│   ├── SortingStrategy.java      # Interfaz Strategy
│   ├── SortByNameStrategy.java   # Ordenamiento por nombre
│   ├── SortByAverageStrategy.java# Ordenamiento por promedio
│   └── SortByIdStrategy.java     # Ordenamiento por ID
└── service/
    └── StudentManager.java       # Patrón Singleton para el CRUD
```

## Instrucciones de Compilación y Ejecución

**Requisitos:** Java Development Kit (JDK) 17 o superior instalado.

1. **Abrir la terminal** y navegar a la raíz del proyecto (`student-management-lab`).
2. **Crear una carpeta `bin`** (opcional, pero recomendado para mantener limpio el proyecto) para los archivos compilados:

   ```bash
   mkdir bin
   ```

3. **Compilar el código fuente:**
   Ejecutar el siguiente comando desde la raíz del proyecto. Esto compilará todos los archivos `.java` en la carpeta `bin` respetando la estructura de paquetes.

   ```bash
   javac -d bin src/model/*.java src/factory/*.java src/strategy/*.java src/service/*.java src/main/*.java
   ```

4. **Ejecutar la aplicación:**
   Ejecutar la clase principal especificando el classpath:

   ```bash
   java -cp bin main.Main
   ```
