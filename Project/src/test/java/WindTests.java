import DTO.WeatherDTO;
import Injection.Injector;
import org.junit.jupiter.api.*;
import DTO.Wind;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindTests {
    public static WeatherDTO weatherDTO;
    public static Wind wind;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        wind = weatherDTO.getWind();
    }

    @Test
    @DisplayName("Check that speed has 2 decimal places")
    public void checkSpeedHas2DP() { Assertions.assertTrue(wind.checkSpeedFormat(wind.getSpeed()));}

    @Nested
    @DisplayName("Checking that speed and direction are in valid ranges")
    class checkRanges {
        @Test
        @DisplayName("Check that speed falls between 0m/s and 135m/s inclusive")
        public void checkSpeedInValidRange() { Assertions.assertTrue(wind.checkSpeedRange(wind.getSpeed()));}

        @Test
        @DisplayName("Check that direction falls between 0 degrees and 360 degrees inclusve")
        public void checkDirectionInValidRange() { Assertions.assertTrue(wind.checkDirectionRange(wind.getDeg()));}
    }

    @Nested
    @DisplayName("Check that none of the values are null")
    class checkNotNull {
        @Test
        @DisplayName("Check that speed is not null")
        public void checkSpeedNotNull() { Assertions.assertTrue(wind.getSpeed() != null);}

        @Test
        @DisplayName("Check that direction is not null")
        public void checkDirectionNotNull() { Assertions.assertTrue(wind.getDeg() != null);}
    }
}
