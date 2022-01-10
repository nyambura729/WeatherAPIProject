import DTO.Coord;
import DTO.WeatherDTO;
import Injection.Injector;
import org.junit.jupiter.api.*;
import Connection.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherDTOTests {
    public static WeatherDTO weatherDTO;
    public static int statusCode;

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
    @DisplayName("Check that the dt is an Integer")
    public void testDtIsInteger() {
        Assertions.assertTrue(weatherDTO.dtIsInteger());
    }

    @Test
    @DisplayName("Check that the name is a String")
    public void nameIsString() {
        Assertions.assertTrue(weatherDTO.nameIsString());
    }

    @Test
    @DisplayName("Check that the cod is an Integer")
    public void testCodIsInteger() {
        Assertions.assertTrue(weatherDTO.codIsInteger());
    }

    @Test
    @DisplayName("Check that the id is an Integer")
    public void testIdIsInteger() {
        Assertions.assertTrue(weatherDTO.idIsInteger());
    }

    @Test
    @DisplayName("Check that the base is a String")
    public void baseIsString() {
        Assertions.assertTrue(weatherDTO.baseIsString());
    }

    @Test
    @DisplayName("Check that weather is a List")
    public void weatherIsList(){
        Assertions.assertTrue(weatherDTO.weatherIsList());
    }

    @Test
    @DisplayName("Check that clouds returns Clouds")
    public void cloudReturnsClouds(){
        Assertions.assertTrue(weatherDTO.cloudReturnsCloud());
    }

    @Test
    @DisplayName("Check that main returns Main")
    public void mainReturnsMain(){
        Assertions.assertTrue(weatherDTO.mainReturnsMain());
    }

    @Test
    @DisplayName("Check that sys returns Sys")
    public void sysReturnsSys(){
        Assertions.assertTrue(weatherDTO.sysReturnsSys());
    }

    @Test
    @DisplayName("Check that coord returns Coord")
    public void coordReturnsCoord(){
        Assertions.assertTrue(weatherDTO.coordReturnsCoord());
    }

    @Test
    @DisplayName("Check that wind returns Wind")
    public void windReturnsWind(){
        Assertions.assertTrue(weatherDTO.windReturnsWind());
    }

    @Test
    @DisplayName("Check that weather contains at least 1 Weather Item")
    public void weatherContainsWeatherItem(){
        Assertions.assertTrue(weatherDTO.weatherContainsWeatherItem());
    }
}
