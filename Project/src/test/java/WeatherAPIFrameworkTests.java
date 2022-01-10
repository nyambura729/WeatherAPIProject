import org.junit.jupiter.api.*;
import DTO.WeatherDTO;
import Connection.ConnectionManager;
import org.junit.jupiter.api.Assertions.*;

public class WeatherAPIFrameworkTests {
    private static WeatherDTO weatherDTO;
    private static int statusCode;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCity("London"));
    }

    @Test
    @DisplayName("Test status code")
    public void testStatusCode() {
        Assertions.assertTrue(statusCode == 200);
    }

    @Test
    @DisplayName("Check that visibility is an Integer")
    public void testVisibilityIsInteger() {
        Assertions.assertEquals(true, weatherDTO.visibilityIsInteger());
    }

    @Test
    @DisplayName("Check that the timezone is an integer")
    public void testTimezoneIsInteger() {
        Assertions.assertTrue(weatherDTO.timezoneIsInteger());
    }

    @Test
    @DisplayName("Check that the dt is an integer")
    public void testDtIsInteger() {
        Assertions.assertTrue(weatherDTO.dtIsInteger());
    }

    @Test
    @DisplayName("Check that the name is a String")
    public void nameIsString() {
        Assertions.assertTrue(weatherDTO.nameIsString());
    }

    @Test
    @DisplayName("Check that the cod is an integer")
    public void testCodIsInteger() {
        Assertions.assertTrue(weatherDTO.codIsInteger());
    }

    @Test
    @DisplayName("Check that the id is an integer")
    public void testIdIsInteger() {
        Assertions.assertTrue(weatherDTO.idIsInteger());
    }

    @Test
    @DisplayName("Check that the base is a String")
    public void baseIsString() {
        Assertions.assertTrue(weatherDTO.baseIsString());
    }
}

