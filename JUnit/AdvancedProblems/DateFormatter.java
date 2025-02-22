package JUnit.AdvancedProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatter {
    public static String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty() || !inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Invalid Date";
        }

        String[] parts = inputDate.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }
}

public class DateFormatterTest {
    @Test
    public void testValidDate() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
        assertEquals("10-05-1999", DateFormatter.formatDate("1999-05-10"));
    }

    @Test
    public void testInvalidDate_WrongFormat() {
        assertEquals("Invalid Date", DateFormatter.formatDate("25-12-2023"));
        assertEquals("Invalid Date", DateFormatter.formatDate("2023/12/25"));
        assertEquals("Invalid Date", DateFormatter.formatDate("20231225"));
    }

    @Test
    public void testInvalidDate_Null() {
        assertEquals("Invalid Date", DateFormatter.formatDate(null));
    }

    @Test
    public void testInvalidDate_EmptyString() {
        assertEquals("Invalid Date", DateFormatter.formatDate(""));
    }

    @Test
    public void testInvalidDate_MalformedDate(){
        assertEquals("Invalid Date", DateFormatter.formatDate("2023-13-32"));
        assertEquals("Invalid Date", DateFormatter.formatDate("2023-02-30"));
        assertEquals("Invalid Date", DateFormatter.formatDate("2023-04-31"));
    }
}