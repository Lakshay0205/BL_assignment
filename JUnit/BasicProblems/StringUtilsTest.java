package JUnit.BasicProblems;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest {
    @Test
    public void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("level"));
        assertTrue(StringUtils.isPalindrome(""));
        assertTrue(StringUtils.isPalindrome("a"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome("abc"));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("TEST", StringUtils.toUpperCase("test"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertEquals("A", StringUtils.toUpperCase("a"));
    }
}