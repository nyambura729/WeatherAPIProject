package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class Sys{

	@JsonProperty("country")
	private String country;

	@JsonProperty("sunrise")
	private Long sunrise;

	@JsonProperty("sunset")
	private Long sunset;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("type")
	private Integer type;

	@JsonProperty("message")
	private Double message;

	public String getCountry(){
		return country;
	}

	public Long getSunrise(){
		return sunrise;
	}

	public Long getSunset(){
		return sunset;
	}

	public Integer getId(){
		return id;
	}

	public Integer getType(){
		return type;
	}

	public Double getMessage(){
		return message;
	}

	public boolean checkCountryFormat(String country) {
		String matchRegex = "[A-Z]{2}";
		boolean result = Pattern.matches(matchRegex, country);
		return result;
	}

	public boolean checkSunriseFormat(Long sunrise) {
		String matchRegex = "\\d{10,}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(sunrise));
		return result;
	}

	public boolean checkSunsetFormat(Long sunset) {
		String matchRegex = "\\d{10,}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(sunset));
		return result;
	}

	public boolean checkIdFormat(Integer id) {
		String matchRegex = "[0-9]{7}";
		boolean result = Pattern.matches(matchRegex, String.valueOf(id));
		return result;
	}

	public boolean checkSunriseRange(Long sunrise) { return (sunrise > 1_000_000_000 && sunrise < 10_000_000_000L);}

	public boolean checkSunsetRange(Long sunset) { return (sunset > 1_000_000_000 && sunset < 10_000_000_000L);}

	public boolean checkSunsetLargerThanSunrise(Long sunrise, Long sunset) { return sunset > sunrise;}
}