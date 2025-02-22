package JUnit.BasicProblems;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionHandler {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

public class ExceptionHandlerTest {
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        ExceptionHandler handler = new ExceptionHandler();
        handler.divide(10, 0);
    }

    @Test
    public void testDivideValid() {
        ExceptionHandler handler = new ExceptionHandler();
        assertEquals(2, handler.divide(10, 5));
    }
}