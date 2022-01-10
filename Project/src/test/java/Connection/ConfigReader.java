package Connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    public static String getConfigKey() {
        try (BufferedReader in = new BufferedReader(new FileReader("src/resources/config.txt"))) {
            String key = in.readLine().trim();
            return key;
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        return "";
    }
}
