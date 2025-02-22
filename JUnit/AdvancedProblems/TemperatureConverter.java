package JUnit.AdvancedProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureConverterTest {
    @Test
    public void testCelsiusToFahrenheit_Freezing() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit_Boiling() {
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit_Normal() {
        assertEquals(68.0, TemperatureConverter.celsiusToFahrenheit(20.0), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius_Freezing() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius_Boiling() {
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius_Normal() {
        assertEquals(20.0, TemperatureConverter.fahrenheitToCelsius(68.0), 0.001);
    }

    @Test
    public void testCelsiusToFahrenheit_Negative() {
        assertEquals(14.0, TemperatureConverter.celsiusToFahrenheit(-10.0), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius_Negative() {
        assertEquals(-17.777, TemperatureConverter.fahrenheitToCelsius(0.0), 0.001);
    }
}