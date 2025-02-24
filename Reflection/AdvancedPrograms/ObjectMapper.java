package Reflection.AdvancedPrograms;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                try {
                    Field field = clazz.getDeclaredField(entry.getKey());
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                } catch (NoSuchFieldException e) {
                    // Field not found, skip
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // Handle access errors
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or throw a custom exception
        }
    }

    public static void main(String[] args) {
        class Person {
            private String name;
            private int age;
            private boolean isStudent;

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public boolean isStudent() {
                return isStudent;
            }
        }

        Map<String, Object> personMap = Map.of(
                "name", "Alice",
                "age", 30,
                "isStudent", true,
                "city", "New York" //Extra field to test noSuchFieldException
        );

        Person person = ObjectMapper.toObject(Person.class, personMap);

        if (person != null) {
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Is Student: " + person.isStudent());
        }
    }
}