import DTO.WeatherDTO;
import org.junit.jupiter.api.*;
import DTO.Coord;
import Connection.ConnectionManager;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CoordTests {
    public static WeatherDTO weatherDTO;
    public static Coord coord;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        coord = weatherDTO.getCoord();
    }

    @Nested
    @DisplayName("Checking that all values are formatted correctly")
    class checkFormatting {
        @Test
        @DisplayName("Check that longitude has 4 decimal places")
        public void checkLongitudeHas4DP() { Assertions.assertTrue(coord.checkFormat(coord.getLon()));}

        @Test
        @DisplayName("Check that latitude has 4 decimal places")
        public void checkLatitudeHas4DP() { Assertions.assertTrue(coord.checkFormat(coord.getLat()));}

    }

    @Nested
    @DisplayName("Checking that longitude and latitude are in valid ranges")
    class checkRanges {
        @Test
        @DisplayName("Check longitude falls between -180 and +180 inclusive")
        public void checkLongitudeInValidRange() { Assertions.assertTrue(coord.checkLongitudeRange(coord.getLon()));}

        @Test
        @DisplayName("Check that latitude falls between -180 and +180 inclusive")
        public void checkLatitudeInValidRange() { Assertions.assertTrue(coord.checkLatitudeRange(coord.getLat()));}
    }
}
