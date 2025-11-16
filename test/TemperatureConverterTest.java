import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private static final double DELTA = 0.0001; // acceptable floating-point error

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverterRefactored.celsiusToFahrenheit(0), DELTA);
        assertEquals(212.0, TemperatureConverterRefactored.celsiusToFahrenheit(100), DELTA);
        assertEquals(-40.0, TemperatureConverterRefactored.celsiusToFahrenheit(-40), DELTA);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverterRefactored.fahrenheitToCelsius(32), DELTA);
        assertEquals(100.0, TemperatureConverterRefactored.fahrenheitToCelsius(212), DELTA);
        assertEquals(-40.0, TemperatureConverterRefactored.fahrenheitToCelsius(-40), DELTA);
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, TemperatureConverterRefactored.celsiusToKelvin(0), DELTA);
        assertEquals(373.15, TemperatureConverterRefactored.celsiusToKelvin(100), DELTA);
        assertEquals(233.15, TemperatureConverterRefactored.celsiusToKelvin(-40), DELTA);
    }
}
