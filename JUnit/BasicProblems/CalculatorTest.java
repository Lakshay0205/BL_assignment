package JUnit.BasicProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-4, 3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-7, calculator.subtract(-4, 3));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-12, calculator.multiply(-4, 3));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(-4, 2));
        assertEquals(1, calculator.divide(5, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(5, 0);
    }
}