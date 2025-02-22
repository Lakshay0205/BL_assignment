package JUnit.AdvancedProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasDigit;
    }
}

public class PasswordValidatorTest {
    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("Password123"));
        assertTrue(PasswordValidator.isValidPassword("StrongPassA1"));
        assertTrue(PasswordValidator.isValidPassword("A1verylongpassword"));
    }

    @Test
    public void testInvalidPassword_TooShort() {
        assertFalse(PasswordValidator.isValidPassword("Pass1"));
    }

    @Test
    public void testInvalidPassword_NoUppercase() {
        assertFalse(PasswordValidator.isValidPassword("password123"));
    }

    @Test
    public void testInvalidPassword_NoDigit() {
        assertFalse(PasswordValidator.isValidPassword("PasswordABC"));
    }

    @Test
    public void testInvalidPassword_NoUppercaseAndNoDigit() {
        assertFalse(PasswordValidator.isValidPassword("password"));
    }

    @Test
    public void testInvalidPassword_Null() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    public void testInvalidPassword_EmptyString() {
      assertFalse(PasswordValidator.isValidPassword(""));
    }
}