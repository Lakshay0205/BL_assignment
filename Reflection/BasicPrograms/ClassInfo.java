package Reflection.BasicPrograms;
import java.lang.reflect.*;

public class ClassInfo {

    public static void getClassInfo(String className) {
        try {
            Class<?> cls = Class.forName(className);

            System.out.println("Class: " + cls.getName());
            System.out.println("--------------------");

            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor.toString());
            }

            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method.toString());
            }

            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field.toString());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }

    public static void main(String[] args) {
        getClassInfo("java.util.ArrayList");
        getClassInfo("java.lang.String");
        getClassInfo("NonExistentClass");

    }
}