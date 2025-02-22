package JUnit.BasicProblems;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtils {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEven_True(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9, 1, -3})
    public void testIsEven_False(int number) {
        assertFalse(NumberUtils.isEven(number));
    }
}