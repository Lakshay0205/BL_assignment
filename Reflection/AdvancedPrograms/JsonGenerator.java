package Reflection.AdvancedPrograms;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonGenerator {

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }

        if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }

        if (obj instanceof Map) {
            return mapToJson((Map<?, ?>) obj);
        }

        if (obj.getClass().isArray()) {
            return arrayToJson((Object[]) obj);
        }

        return objectToJson(obj);
    }

    private static String objectToJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!first) {
                    json.append(",");
                } else {
                    first = false;
                }
                json.append("\"").append(field.getName()).append("\":").append(toJson(field.get(obj)));

            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Handle exception properly in real code
            }
        }

        json.append("}");
        return json.toString();
    }

    private static String mapToJson(Map<?, ?> map) {
        StringBuilder json = new StringBuilder("{");
        boolean first = true;

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!first) {
                json.append(",");
            } else {
                first = false;
            }
            json.append("\"").append(entry.getKey()).append("\":").append(toJson(entry.getValue()));
        }

        json.append("}");
        return json.toString();
    }

    private static String arrayToJson(Object[] array) {
        StringBuilder json = new StringBuilder("[");
        boolean first = true;

        for (Object item : array) {
            if (!first) {
                json.append(",");
            } else {
                first = false;
            }
            json.append(toJson(item));
        }

        json.append("]");
        return json.toString();
    }

    public static void main(String[] args) {
        class Person<Address> {
            String name;
            int age;
            Address address;
            String[] hobbies;

            public Person(String name, int age, Address address, String[] hobbies) {
                this.name = name;
                this.age = age;
                this.address = address;
                this.hobbies = hobbies;
            }
        }

        class Address {
            String street;
            String city;

            public Address(String street, String city) {
                this.street = street;
                this.city = city;
            }
        }

        Address address = new Address("123 Main St", "Anytown");
        Person person = new Person("Alice", 30, address, new String[]{"reading", "hiking"});

        System.out.println(toJson(person));

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", 123);
        map.put("key3", true);
        System.out.println(toJson(map));

        String[] array = {"a","b","c"};
        System.out.println(toJson(array));

        System.out.println(toJson("test"));
        System.out.println(toJson(123));
        System.out.println(toJson(true));
        System.out.println(toJson(null));

    }
}