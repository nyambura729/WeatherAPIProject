package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class Wind{

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	public Integer getDeg(){
		return deg;
	}

	public Double getSpeed(){
		return speed;
	}

	public boolean checkSpeedFormat(Double speed) {
		String matchRegex = "\\d+\\.\\d{2}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(speed));
		return result;
	}

	public boolean checkSpeedRange(Double speed) { return (speed >= 0 && speed <= 135);}

	public boolean checkDirectionRange(Integer degrees) { return (degrees >= 0 && degrees <= 360);}
}