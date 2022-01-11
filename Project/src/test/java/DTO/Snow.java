package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class Snow {
    @JsonProperty("1h")
    private Double oneHour;

    @JsonProperty("3h")
    private Double threeHours;

    public Double getOneHour() { return oneHour; }

    public Double getThreeHours() { return threeHours; }

    public boolean checkSnowFormat(Double hours) {
        if (hours != null) {
            String matchRegex = "\\d+\\.\\d{1}";
            boolean result = Pattern.matches(matchRegex, String.valueOf(hours));
            return result;
        }
        else {
            return true;
        }
    }

    public boolean checkSnowRange(Double hour) {
        if (hour != null) {
            return (oneHour >= 0 && oneHour <= 2000);
        }
        else {
            return true;
        }
    }
}
