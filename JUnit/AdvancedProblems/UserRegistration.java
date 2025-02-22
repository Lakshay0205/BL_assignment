package JUnit.AdvancedProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: username, email, or password cannot be null or empty.");
        }

        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }
}

public class UserRegistrationTest {
    private final UserRegistration registration = new UserRegistration();

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("testuser", "test@example.com", "Password123"));
    }

    @Test
    public void testInvalidUsername_Null() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser(null, "test@example.com", "Password123"));
    }

    @Test
    public void testInvalidUsername_Empty() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "test@example.com", "Password123"));
    }

    @Test
    public void testInvalidEmail_Null() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", null, "Password123"));
    }

    @Test
    public void testInvalidEmail_Empty() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", "", "Password123"));
    }

    @Test
    public void testInvalidEmail_Format() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", "invalidemail", "Password123"));
    }

    @Test
    public void testInvalidPassword_Null() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", "test@example.com", null));
    }

    @Test
    public void testInvalidPassword_Empty() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", "test@example.com", ""));
    }

    @Test
    public void testInvalidPassword_TooShort() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("testuser", "test@example.com", "short"));
    }
}