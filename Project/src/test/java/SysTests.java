import DTO.Clouds;
import DTO.WeatherDTO;
import DTO.Sys;
import Injection.Injector;
import org.junit.jupiter.api.*;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SysTests {
    public static WeatherDTO weatherDTO;
    public static Sys sys;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        sys = weatherDTO.getSys();
    }

    @Nested
    @DisplayName("Checking that the values are correctly formatted")
    class checkingFormat {
        @Test
        @DisplayName("Check that country is formatted correctly")
        public void checkCountryFormat() { Assertions.assertTrue(sys.checkCountryFormat(sys.getCountry()));}

        @Test
        @DisplayName("Check that this value has >= 10 digits")
        public void checkSunriseFormat() { Assertions.assertTrue(sys.checkSunriseFormat(sys.getSunrise()));}

        @Test
        @DisplayName("Check that this value has >= 10 digits")
        public void checkSunsetFormat() { Assertions.assertTrue(sys.checkSunsetFormat(sys.getSunset()));}

        @Test
        @DisplayName("Check that the id is 7 consecutive numbers")
        public void checkIdFormat() { Assertions.assertTrue(sys.checkIdFormat(sys.getId()));}
    }

    @Nested
    @DisplayName("Checking that the values are in a valid range")
    class checkingRange {
        @Test
        @DisplayName("Check that sunrise is between 1.0x10^9 and 1.0x10^10")
        public void checkSunriseRange() { Assertions.assertTrue(sys.checkSunriseRange(sys.getSunrise()));}

        @Test
        @DisplayName("Check that sunset is between 1.0x10^9 and 1.0x10^10")
        public void checkSunsetRange() { Assertions.assertTrue(sys.checkSunsetRange(sys.getSunset()));}

        @Test
        @DisplayName("Check that sunset value is larger than sunrise value")
        public void checkSunsetLargerThanSunrise() { Assertions.assertTrue(sys.checkSunsetLargerThanSunrise(sys.getSunrise(), sys.getSunset()));}
    }

    @Nested
    @DisplayName("Check that the values are not null")
    class checkNotNull {
        @Test
        @DisplayName("Check that country is not null")
        public void checkCountryNotNull() { Assertions.assertTrue(sys.getCountry() != null);}

        @Test
        @DisplayName("Check that sunrise is not null")
        public void checkSunriseNotNull() { Assertions.assertTrue(sys.getSunrise() != null);}

        @Test
        @DisplayName("Check that sunset is not null")
        public void checkSunsetNotNull() { Assertions.assertTrue(sys.getSunset() != null);}

        @Test
        @DisplayName("Check that id is not null")
        public void checkIDNotNull() { Assertions.assertTrue(sys.getId() != null);}

        @Test
        @DisplayName("Check type is not null")
        public void testTypeNotNull() { Assertions.assertTrue(sys.getType() != null);}
    }
}
