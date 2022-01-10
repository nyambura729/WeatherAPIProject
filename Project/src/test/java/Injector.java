import DTO.WeatherDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Injector {
    // A class responsible for injecting the JSON response into a Weather DTO

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static WeatherDTO injectWeatherDTO(String path) {
        WeatherDTO weatherDTO = new WeatherDTO();
        try {
            weatherDTO = objectMapper.readValue(new URL(path), WeatherDTO.class);
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        return weatherDTO;
    }
}
