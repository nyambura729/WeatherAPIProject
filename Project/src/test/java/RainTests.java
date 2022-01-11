import DTO.WeatherDTO;
import Injection.Injector;
import org.junit.jupiter.api.*;
import DTO.Rain;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RainTests {
    public static WeatherDTO weatherDTO;
    public static Rain rain;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        if (weatherDTO.getRain() != null) {
            rain = weatherDTO.getRain();
        } else {
            rain = new Rain();
        }
    }

    @Test
    @DisplayName("Check that rain is not null")
    public void checkRainNotNull() { Assertions.assertTrue(rain != null);}

    @Nested
    @DisplayName("Checking that the values are formatted correctly")
    class checkingFormat {
        @Test
        @DisplayName("Check that 1h has 1 decimal place")
        public void checkOneHourFormat() {
            Assertions.assertTrue(rain.checkRainFormat(rain.getOneHour()));
        }

        @Test
        @DisplayName("Check that 3h has 1 decimal place")
        public void checkThreeHoursFormat() {
            Assertions.assertTrue(rain.checkRainFormat(rain.getThreeHours()));
        }
    }

    @Nested
    @DisplayName("Check that rainfall values are in valid range")
    class checkingRange {
        @Test
        @DisplayName("Check that one hour rainfall is between 0mm and 2000mm")
        public void checkOneHourRange() { Assertions.assertTrue(rain.checkRainRange(rain.getOneHour()));}

        @Test
        @DisplayName("Check that three hour rainfall is between 0mm and 2000mm")
        public void checkThreeHoursRange() { Assertions.assertTrue(rain.checkRainRange(rain.getThreeHours()));}
    }
}
