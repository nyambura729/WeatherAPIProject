package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class Wind{

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("gust")
	private Double gust;

	public Integer getDeg(){
		return deg;
	}

	public Double getSpeed(){
		return speed;
	}

	public Double getGust() { return gust; }

	public boolean checkSpeedFormat(Double speed) {
		String matchRegex = "\\d+\\.\\d{2}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(speed));
		return result;
	}

	public boolean checkSpeedRange(Double speed) { return (speed >= 0 && speed <= 135);}

	public boolean checkDirectionRange(Integer degrees) { return (degrees >= 0 && degrees <= 360);}

	public boolean checkGustFormat(Double gust) {
		if (gust != null) {
			String matchRegex = "\\d+\\.\\d{2}";
			boolean result = Pattern.matches(matchRegex, String.valueOf(gust));
			return result;
		}
		else {
			return true;
		}
	}

	public boolean checkGustRange(Double gust) {
		if (gust != null) {
			return (gust >= 0 && gust <= 105);
		}
		else {
			return true;
		}
	}
}