package Connection;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

public class ConnectionManager {
    // A class which handles the connection to the live system and collecting the response

    private static final String BASEURL = "http://api.openweathermap.org/data/2.5/weather";  // don't include query parameters here
    private static final String KEY = ConfigReader.getConfigKey();

    public static String getConnectionCity(String city) {
        var url = BASEURL + "?q=" + city + "&appid=" + KEY;
        return url;
    }

    public static String getConnectionCityState(String city, String state) {
        return BASEURL + "?q=" + city + "," + state + "&appid=" + KEY;
    }

    public static String getConnectionCityStateCountry(String city, String state, String country) {
        return BASEURL + "?q=" + city + "," + state + "," + country + "&appid=" + KEY;
    }

    private static HttpResponse<String> getStringHttpResponse(String connection) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(create(connection)).build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException i) {
            i.printStackTrace();
        }
        return httpResponse;
    }

    public static int getStatusCode(String connection) {
        HttpResponse<String> httpResponse = getStringHttpResponse(connection);
        return httpResponse.statusCode();
    }

}
