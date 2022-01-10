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
    public void testStatusCode() { Assertions.assertTrue(statusCode == 200); }

}
