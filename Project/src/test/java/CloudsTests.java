import DTO.Main;
import DTO.WeatherDTO;
import DTO.Clouds;
import org.junit.jupiter.api.*;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CloudsTests {
    public static WeatherDTO weatherDTO;
    public static Clouds clouds;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        clouds = weatherDTO.getClouds();
    }

    @Test
    @DisplayName("Check that cloud is in a valid range")
    public void checkCloudRange() { Assertions.assertTrue(clouds.checkCloudsRange(clouds.getAll()));}

    @Test
    @DisplayName("Check that cloudiness is not null")
    public void checkCloudinessNotNull() { Assertions.assertTrue(clouds.getAll() != null);}
}
