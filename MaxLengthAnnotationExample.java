import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            Field usernameField = User.class.getDeclaredField("username");
            if (usernameField.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = usernameField.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotationExample {

    public static void main(String[] args) {
        try {
            User validUser = new User("shortUser");
            System.out.println("Valid user: " + validUser.getUsername());

            User invalidUser = new User("veryLongUsername"); // Should throw exception
            System.out.println("Invalid user: " + invalidUser.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}