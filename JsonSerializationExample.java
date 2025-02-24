import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name() default "";
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

public class JsonSerializationExample {

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    if (!first) {
                        json.append(",");
                    } else {
                        first = true;
                        first = false;
                    }

                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    String fieldName = jsonField.name().isEmpty() ? field.getName() : jsonField.name();
                    json.append("\"").append(fieldName).append("\":\"").append(field.get(obj)).append("\"");

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        User user = new User("Alice", 30);
        String json = toJson(user);
        System.out.println(json);
    }
}