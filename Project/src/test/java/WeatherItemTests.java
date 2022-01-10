import DTO.Main;
import DTO.WeatherDTO;
import org.junit.jupiter.api.*;
import DTO.WeatherItem;
import Connection.ConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherItemTests {
    public static WeatherDTO weatherDTO;
    public static WeatherItem weatherItem;

    @BeforeAll
    public static void init() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        weatherItem = weatherDTO.getWeather().get(0);
    }

    @Test
    @DisplayName("Check that icon is correctly formatted")
    public void checkIconFormat() { Assertions.assertTrue(weatherItem.checkIconFormat(weatherItem.getIcon()));}

    // range for id is 200-804
    @Test
    @DisplayName("Check that id is between 200 and 804 inclusive")
    public void checkIdRange() { Assertions.assertTrue(weatherItem.checkIdRange(weatherItem.getId()));}

    @Nested
    @DisplayName("Check that the values are not null")
    class checkNotNull {
        @Test
        @DisplayName("Check that icon is not null")
        public void checkIconNotNull() { Assertions.assertTrue(weatherItem.getIcon() != null);}

        @Test
        @DisplayName("Check that description is not null")
        public void checkDescriptionNotNull() { Assertions.assertTrue(weatherItem.getDescription() != null);}

        @Test
        @DisplayName("Check that main is not null")
        public void checkMainNotNull() { Assertions.assertTrue(weatherItem.getMain() != null);}

        @Test
        @DisplayName("Check that id is not null")
        public void checkIdNotNull() { Assertions.assertTrue(weatherItem.getId() != null);}
    }
}
