package Reflection.BasicPrograms;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    private int getAge() { return age; }

    public int publicGetAge() {
        return age;
    }
}

public class PrivateFieldAccess {

    public static void main(String[] args) {
        Person person = new Person(30);

        try {
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true); // Make the private field accessible

            System.out.println("Original age: " + ageField.get(person));

            ageField.set(person, 35); // Modify the private field

            System.out.println("Modified age: " + ageField.get(person));

            //Accessing private method
            Method privateMethod = Person.class.getDeclaredMethod("getAge");
            privateMethod.setAccessible(true);
            System.out.println("Private method getAge(): " + privateMethod.invoke(person));


        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}