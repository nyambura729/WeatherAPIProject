package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class Coord {

	@JsonProperty("lon")
	private Double lon;

	@JsonProperty("lat")
	private Double lat;

	public Double getLon(){
		return lon;
	}

	public Double getLat(){
		return lat;
	}

	public boolean checkFormat(Double val) {
		String matchRegex = "[+|-]?\\d+\\.\\d{4}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(val));
		return result;
	}

	public boolean checkLongitudeRange(Double lon) { return (lon >= -180 && lon <= 180);}

	public boolean checkLatitudeRange(Double lat) { return (lat >= -180 && lat <= 180);}

}