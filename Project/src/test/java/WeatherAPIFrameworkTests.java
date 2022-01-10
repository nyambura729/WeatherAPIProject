import Injection.Injector;
import org.junit.jupiter.api.*;
import DTO.WeatherDTO;
import Connection.ConnectionManager;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeatherAPIFrameworkTests {
    private static WeatherDTO weatherDTO;
    private static int statusCode;

    @Test
    @DisplayName("Test is able to get the weather information of the city")
    public void testCityCode() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity("London"));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCity("London"));
        Assertions.assertTrue(statusCode == 200); }


    @ParameterizedTest
    @CsvSource({
            "UK",
            "?",
            "0",
            "null"

    })
    @DisplayName("Test is unable to return the weather information of the city")
    public void testNotCityCode(String city) {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCity(city));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCity(city));
        Assertions.assertFalse(statusCode == 200);
    }

    @Test
    @DisplayName("Test to get the city and state")
    public void testCityStateCode() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCityState("Dothan","US-AL"));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCityState("Dothan","US-AL"));
        Assertions.assertEquals(200, statusCode); }

    @ParameterizedTest
    @CsvSource({
            "US-AL, United_Kingdom",
            "?, P",
            "0, UK-AP",
            "null, null"

    })
    @DisplayName("Test is unable to return the weather information of the city and state")
    public void testNotCityStateCode(String city, String state) {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCityState(city, state));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCityState(city, state));
        Assertions.assertFalse(statusCode == 200);
    }

    @Test
    @DisplayName("Test to get the city, state and country")
    public void testCityStateCountryCode() {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCityStateCountry("Dothan","US-AL","US"));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCityStateCountry("Dothan","US-AL","US"));
        Assertions.assertEquals(200, statusCode); }

    @ParameterizedTest
    @CsvSource({
            "US-AL, United_Kingdom, Spain",
            "?, P, #",
            "0, UK-AP, 23",
            "null, null , True"

    })
    @DisplayName("Test is unable to return the weather information of the city, state and country")
    public void testNotCityStateCode(String city, String state, String country) {
        weatherDTO = Injector.injectWeatherDTO(ConnectionManager.getConnectionCityStateCountry(city, state, country));
        statusCode = ConnectionManager.getStatusCode(ConnectionManager.getConnectionCityStateCountry(city, state, country));
        Assertions.assertFalse(statusCode == 200);
    }

}

