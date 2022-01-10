import DTO.Snow;
import DTO.WeatherDTO;
import Injection.Injector;
import org.junit.jupiter.api.*;
import DTO.Rain;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SnowTests {
    public static WeatherDTO weatherDTO;
    public static Snow snow;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        if (weatherDTO.getRain() != null) {
            snow = weatherDTO.getSnow();
        } else {
            snow = new Snow();
        }
    }

    @Test
    @DisplayName("Check that snow is not null")
    public void checkRainNotNull() {
        Assertions.assertTrue(snow != null);
    }

    @Nested
    @DisplayName("Checking that the values are formatted correctly")
    class checkingFormat {
        @Test
        @DisplayName("Check that 1h has 1 decimal place")
        public void checkOneHourFormat() {
            Assertions.assertTrue(snow.checkSnowFormat(snow.getOneHour()));
        }

        @Test
        @DisplayName("Check that 3h has 1 decimal place")
        public void checkThreeHoursFormat() {
            Assertions.assertTrue(snow.checkSnowFormat(snow.getThreeHours()));
        }
    }

    @Nested
    @DisplayName("Check that rainfall values are in valid range")
    class checkingRange {
        @Test
        @DisplayName("Check that one hour rainfall is between 0mm and 2000mm")
        public void checkOneHourRange() { Assertions.assertTrue(snow.checkSnowRange(snow.getOneHour()));}

        @Test
        @DisplayName("Check that three hour rainfall is between 0mm and 2000mm")
        public void checkThreeHoursRange() { Assertions.assertTrue(snow.checkSnowRange(snow.getThreeHours()));}
    }
}
