package Reflection.BasicPrograms;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

public class DynamicObjectCreation {

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
            Object studentObject = constructor.newInstance("Alice", 123);

            Student student = (Student) studentObject;
            student.displayInfo();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}