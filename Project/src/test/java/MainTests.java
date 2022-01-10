import DTO.WeatherDTO;
import org.junit.jupiter.api.*;
import DTO.Main;
import Connection.ConnectionManager;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTests {
    public static WeatherDTO weatherDTO;
    public static Main main;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        main = weatherDTO.getMain();
    }

    @Nested
    @DisplayName("Checking that all the temperatures fall in valid range")
    class checkingTemperatures {
        @Test
        @DisplayName("Check that temp is above 0 (kelvin)")
        public void checkTempAboveZero() { Assertions.assertTrue(main.checkTempsAboveZero(main.getTemp()));}

        @Test
        @DisplayName("Check that tempMin is above 0 (kelvin)")
        public void checkTempMinAboveZero() { Assertions.assertTrue(main.checkTempsAboveZero(main.getTempMin()));}

        @Test
        @DisplayName("Check that tempMax is above zero 0 (kelvin)")
        public void checkTempMaxAboveZero() { Assertions.assertTrue(main.checkTempsAboveZero(main.getTempMax()));}

        @Test
        @DisplayName("Check that feelsLike is above zero (kelvin)")
        public void checkFeelsLikeAboveZero() { Assertions.assertTrue(main.checkTempsAboveZero(main.getFeelsLike()));}
    }

    @Nested
    @DisplayName("Checking that both pressure and humidity are within valid ranges")
    class checkingRanges {
        @Test
        @DisplayName("Check pressure falls between 800 and 2000 (hPa) exclusive")
        public void checkPressureInValidRange() { Assertions.assertTrue(main.checkPressureRange(main.getPressure()));}

        @Test
        @DisplayName("Check humidity falls between 0% (exclusive) and 100% (inclusive)")
        public void checkHumidityInValidRange() { Assertions.assertTrue(main.checkHumidityRange(main.getHumidity()));}
    }

    @Nested
    @DisplayName("Checking that none of the fields are null")
    class checkingNullValues {
        @Test
        @DisplayName("Check that temp is not null")
        public void checkTempNotNull() { Assertions.assertTrue(main.getTemp() != null);}

        @Test
        @DisplayName("Check that tempMn is not null")
        public void checkTempMinNotNull() { Assertions.assertTrue(main.getTempMin() != null);}

        @Test
        @DisplayName("Check that tempMax is not null")
        public void checkTempMaxNotNull() { Assertions.assertTrue(main.getTempMax() != null);}

        @Test
        @DisplayName("Check that feelsLike is not null")
        public void checkFeelsLikeNotNull() { Assertions.assertTrue(main.getFeelsLike() != null);}

        @Test
        @DisplayName("Check that pressure is not null")
        public void checkPressureNotNull() { Assertions.assertTrue(main.getPressure() != null);}

        @Test
        @DisplayName("Check that humidity is not null")
        public void checkHumidityNotNull() { Assertions.assertTrue(main.getHumidity() != null);}
    }

}
